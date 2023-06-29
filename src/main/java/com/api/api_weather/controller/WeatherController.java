package com.api.api_weather.controller;

import com.api.api_weather.responses.WeatherResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class WeatherController {

    @Value("${openweather.api.key}")
    private String API_KEY;

    @RequestMapping("/weather")
    public ResponseEntity<WeatherResponse> getWeather(@RequestParam("location") String location) {
        String apiUrl = "https://api.openweathermap.org/data/2.5/weather?q={location}&appid={apiKey}";
        var restTemplate = new RestTemplate();
        String url = apiUrl.replace("{location}", location).replace("{apiKey}", API_KEY);
        return restTemplate.getForEntity(url, WeatherResponse.class);
    }
}

