package com.api.api_weather.controller;

import com.api.api_weather.responses.WeatherResponse;
import com.api.api_weather.service.WeatherService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Log4j2
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @RequestMapping("/weather")
    public ResponseEntity<WeatherResponse> getWeather(@RequestParam("location") String location) {
        try {
            var weatherResponse = weatherService.getWeather(location);
            if (weatherResponse == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(weatherResponse);
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }
}

