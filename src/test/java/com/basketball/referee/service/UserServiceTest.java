package com.basketball.referee.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import com.basketball.referee.model.User;
import com.basketball.referee.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void UserService_findByUsername_ReturnsUser(){
        User usuario = new User("user", "password", "email", "firstName", "lastName");
        
        when(userRepository.findByUsername("user")).thenReturn(Optional.of(usuario));

        Optional<User> result = userService.findByUsername("user");

        assertEquals(true, result.isPresent(), "El usuario debe estar presente");
        assertEquals("email", result.get().getEmail(), "El correo del usuario debe ser email");
    }

}
