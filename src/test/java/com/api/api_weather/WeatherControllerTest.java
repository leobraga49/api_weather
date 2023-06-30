package com.api.api_weather;

import com.api.api_weather.controller.WeatherController;
import com.api.api_weather.responses.WeatherResponse;
import com.api.api_weather.service.WeatherService;
import com.api.api_weather.utils.WeatherTestUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
class WeatherControllerTest {

    private WeatherController weatherController;

    @Mock
    private WeatherService weatherService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        weatherController = new WeatherController(weatherService);
    }

    @Test
    void testGetWeather_Sucess() {
        String location = "London";
        WeatherResponse weatherResponse = WeatherTestUtils.createWeatherResponse(location);
        when(weatherService.getWeather(location)).thenReturn(weatherResponse);
        ResponseEntity<WeatherResponse> weatherEntity = weatherController.getWeather(location);
        assertEquals(HttpStatus.OK, weatherEntity.getStatusCode());
        assertEquals(location, Objects.requireNonNull(weatherEntity.getBody()).getLocation());
    }
}