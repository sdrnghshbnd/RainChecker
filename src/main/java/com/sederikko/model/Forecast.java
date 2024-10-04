package com.sederikko.model;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class Forecast {
    private List<Weather> weather;
}