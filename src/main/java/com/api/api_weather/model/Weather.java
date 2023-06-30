package com.api.api_weather.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Weather {
    private String main;
    private String description;

}
