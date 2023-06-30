package com.api.api_weather.service;

import com.api.api_weather.exceptions.WeatherServiceException;
import com.api.api_weather.responses.OpenWeatherApiResponse;
import com.api.api_weather.responses.WeatherResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Log4j2
public class WeatherService {

    private final RestTemplate restTemplate;
    private final String apiUrl;
    private final String apiKey;

    public WeatherService(
            RestTemplate restTemplate,
            @Value("${openweather.api.url}") String apiUrl,
            @Value("${openweather.api.key}") String apiKey) {
        this.restTemplate = restTemplate;
        this.apiUrl = apiUrl;
        this.apiKey = apiKey;
    }

    public WeatherResponse getWeather(String location) {
        String url = apiUrl.replace("{location}", location).replace("{apiKey}", apiKey);
        try {
            var response = restTemplate.getForEntity(url, OpenWeatherApiResponse.class);

            if (response.getStatusCode().is2xxSuccessful()) {
                var body = response.getBody();

                return WeatherResponse.builder()
                        .location(location)
                        .temperature(body.getMain().getTemp())
                        .humidity(body.getMain().getHumidity())
                        .windSpeed(body.getWind().getSpeed())
                        .weatherConditions(body.getWeather().get(0))
                        .build();

            } else {
                throw new WeatherServiceException("Error getting weather data from OpenWeather API");
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new WeatherServiceException("Error getting weather data from OpenWeather API");
        }
    }
}
