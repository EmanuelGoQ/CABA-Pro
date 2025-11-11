package com.basketball.referee.service;

import com.basketball.referee.model.ClimaData;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class WeatherService {
    
    private final WebClient webClient;

    @Value("${openweathermap.api-key}")
    private String apiKey;

    private static final String BASE_URL = "https://api.openweathermap.org/data/2.5/weather";
    
    public WeatherService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(BASE_URL).build();
    }

    public ClimaData getCurrentweather(String city) {
        String uri = String.format("?q=%s&appid=%s&units=metric&lang=es", city, apiKey);

        ClimaData weatherData = webClient.get()
            .uri(uri)
            .retrieve()
            .bodyToMono(ClimaData.class)
            .block();
        
            return weatherData;
    }
}
