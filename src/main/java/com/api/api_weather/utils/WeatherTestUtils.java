package com.api.api_weather.utils;

import com.api.api_weather.model.Weather;
import com.api.api_weather.responses.WeatherResponse;

public class WeatherTestUtils {

    private WeatherTestUtils() {
    }

    public static WeatherResponse createWeatherResponse(String location) {
        return WeatherResponse.builder()
                .location(location)
                .temperature(10.0)
                .humidity(10)
                .windSpeed(10.0)
                .weatherConditions(new Weather("Clouds", "Cloudy"))
                .build();
    }
}
