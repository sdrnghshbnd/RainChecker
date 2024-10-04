package com.sederikko.model;

import lombok.Data;

import java.util.List;

@Data
public class WeatherResponse {
    private List<Forecast> list;
}