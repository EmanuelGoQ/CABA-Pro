package com.basketball.referee.config;

import com.basketball.referee.model.User;
import com.basketball.referee.model.Referee;
import com.basketball.referee.model.Role;
import com.basketball.referee.repository.UserRepository;
import com.basketball.referee.service.RefereeService;
import com.basketball.referee.repository.RoleRepository;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private RefereeService refereeService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        // Crear roles si no existen
        if (roleRepository.findByName("ROLE_ADMIN") == null) {
            Role adminRole = new Role();
            adminRole.setName("ROLE_ADMIN");
            roleRepository.save(adminRole);
        }

        if (roleRepository.findByName("ROLE_REFEREE") == null) {
            Role refereeRole = new Role();
            refereeRole.setName("ROLE_REFEREE");
            roleRepository.save(refereeRole);
        }

        // Crear usuario administrador por defecto
        if (!userRepository.findByUsername("admin").isPresent()) {
            User admin = new User();
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("admin123"));
            admin.setEmail("admin@basketball.com");
            admin.setFirstName("Administrador");
            admin.setLastName("Sistema");
            admin.setEnabled(true);
            admin.getRoles().add(roleRepository.findByName("ROLE_ADMIN"));
            userRepository.save(admin);
            System.out.println("Usuario admin creado");
        }

        if (!userRepository.findByUsername("referee").isPresent()) {
            User referee = new User();
            referee.setUsername("referee");
            referee.setPassword(passwordEncoder.encode("referee123"));
            referee.setEmail("referee@basketball.com");
            referee.setFirstName("Juan");
            referee.setLastName("Pérez");
            referee.setEnabled(true);
            referee.getRoles().add(roleRepository.findByName("ROLE_REFEREE"));
            userRepository.save(referee);
            System.out.println("Usuario referee creado");
        }

        // Crear árbitros de ejemplo
        String[][] sampleRefs = {
            {"luis", "Luis", "Ramírez", "123456", "luis@test.com"},
            {"carlos", "Carlos", "Martínez", "654321", "carlos@test.com"},
            {"andres", "Andrés", "Gómez", "111222", "andres@test.com"},
            {"marco", "Marco", "Ruiz", "444555", "marco@test.com"}
        };

        for (String[] data : sampleRefs) {

            if (!userRepository.findByUsername(data[0]).isPresent()) {
                User u = new User();
                u.setUsername(data[0]);
                u.setPassword(passwordEncoder.encode("test123"));
                u.setEmail(data[4]);
                u.setFirstName(data[1]);
                u.setLastName(data[2]);
                u.setEnabled(true);
                u.getRoles().add(roleRepository.findByName("ROLE_REFEREE"));
                userRepository.save(u);

                Referee r = new Referee();
                r.setUser(u);
                r.setDocument(data[3]);
                r.setRank(Referee.Rank.FORMATION);
                r.setSpecialty(Referee.Specialty.BOTH);
                r.setPhone("3000000000"); // Teléfono dummy
                r.setBirthDate(LocalDate.of(1990, 1, 1)); // Fecha dummy
                refereeService.createReferee(r, u.getId());

            }
        }

        System.out.println("Árbitros de prueba cargados");
        System.out.println("listo el comand line runner" );
    }
}
