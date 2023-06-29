package com.api.api_weather.responses;

import com.api.api_weather.model.MainData;
import com.api.api_weather.model.Weather;
import com.api.api_weather.model.Wind;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenWeatherApiResponse {
    private List<Weather> weather;
    private MainData main;
    private Wind wind;
}
