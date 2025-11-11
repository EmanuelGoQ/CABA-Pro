package com.basketball.referee.model;

import java.util.List;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import jakarta.persistence.Transient;
import com.fasterxml.jackson.annotation.JsonProperty;

@Embeddable
public class ClimaData {
    @JsonProperty("name")
    public String cityWeather; //El nombre de la ciudad

    @JsonProperty("main")
    @Embedded
    public MainData main; //La parte principal (main) del JSON

    @JsonProperty("weather")
    @Transient
    public List<WeatherDescription> weather;

    public ClimaData() {}

    @Embeddable
    public static class MainData {
        public double temp;
        public int humidity;

        public MainData() {}

        public double tempGet(){
            return temp;
        }

        public void setTemp(double temperature){
            temp = temperature;
        }
        
        public double humidityGet(){
            return humidity;
        }

        public void setHumidity(int humid){
            humidity = humid;
        }

    }

    @Embeddable
    public static class WeatherDescription {
        public String description;

        public WeatherDescription() {}

        public String getDescription(){
            return description;
        }

        public void setDescription(String Des){
            description = Des;
        }
    }

    public String getDescription() {
        return weather != null && !weather.isEmpty() ? weather.get(0).description : "No disponible";    
    }

    public double getTemperature() {
        return main != null ? main.temp : 0.0;
    }
    
}
