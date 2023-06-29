package com.api.api_weather.responses;

import com.api.api_weather.model.Weather;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherResponse {
    private String location;
    private double temperature;
    private int humidity;
    private double windSpeed;
    private Weather weatherConditions;
}
