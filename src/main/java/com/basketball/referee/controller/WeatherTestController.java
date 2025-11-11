package com.basketball.referee.controller;

import com.basketball.referee.model.ClimaData;
import com.basketball.referee.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping; // ¡Importante!
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
// Añadimos una ruta base. En este caso, la dejamos vacía para mantener la ruta original.
// Pero ayuda a Spring a ubicar el controlador.
// link referencia: http://localhost:8080/test-weather?city=Envigado,CO
@RequestMapping("/") 
public class WeatherTestController {

    private final WeatherService weatherService;

    // Inyecta el servicio de clima
    @Autowired
    public WeatherTestController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    /**
     * Endpoint para probar la conexión a la API del clima.
     * Ejemplo de uso: http://localhost:8080/test-weather?city=bogota
     * (Ajusta el puerto si es diferente)
     */
    @GetMapping("/test-weather") // Mantenemos solo el subpath aquí
    public ResponseEntity<ClimaData> testWeatherConnection(
            @RequestParam(defaultValue = "Envigado,CO") String city) {
        
        System.out.println("Buscando clima para la ciudad: " + city);
        
        try {
            // Llama a tu servicio para obtener los datos
            ClimaData data = weatherService.getCurrentweather(city);
            
            if (data != null) {
                // Si la llamada fue exitosa y deserializó, devuelve el objeto
                System.out.println("¡Conexión Exitosa! Temperatura: " + data.getTemperature() + "°C");
                return ResponseEntity.ok(data);
            } else {
                // Si regresa nulo (aunque WebClient con .block() generalmente arroja excepción en error HTTP)
                return ResponseEntity.status(500).body(null);
            }

        } catch (Exception e) {
            // Manejo de errores de conexión o deserialización
            System.err.println("Error al conectar o procesar el clima: " + e.getMessage());
            // Puedes devolver un error más detallado si lo deseas
            return ResponseEntity.status(500).body(null);
        }
    }
}