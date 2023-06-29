package com.api.api_weather.responses;

import lombok.Data;

@Data
public class WeatherResponse {
    private String temperature;
    private String humidity;
    private String windSpeed;
    private String weatherCondition;
}
