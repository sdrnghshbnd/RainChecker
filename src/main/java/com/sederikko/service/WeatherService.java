package com.sederikko.service;

import com.sederikko.model.Forecast;
import com.sederikko.model.Weather;
import com.sederikko.model.WeatherResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${weather.api.key}")
    private String apiKey;

    @Value("${weather.latitude}")
    private double latitude;

    @Value("${weather.longitude}")
    private double longitude;

    public boolean isRainExpectedInNext12Hours() {
        // Construct the URL with the provided latitude, longitude, and API key.
        String url = String.format("https://api.openweathermap.org/data/2.5/forecast?lat=%s&lon=%s&appid=%s&cnt=4",
                latitude, longitude, apiKey);

        // Use RestTemplate to retrieve the response as a WeatherResponse object
        WeatherResponse response = restTemplate.getForObject(url, WeatherResponse.class);

        if (response == null || response.getList() == null) return false;

        // Iterate through each forecast in the response
        for (Forecast forecast : response.getList()) {
            // Check each weather condition in the forecast
            for (Weather weather : forecast.getWeather()) {
                // If the weather ID is less than 700, it indicates rain/snow/thunderstorm
                if (weather.getId() < 700) {
                    return true;
                }
            }
        }
        return false;
    }
}
