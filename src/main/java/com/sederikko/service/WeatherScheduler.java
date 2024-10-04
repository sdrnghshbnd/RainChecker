package com.sederikko.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class WeatherScheduler {

    private final WeatherService weatherService;

    private final MailService mailService;

    public WeatherScheduler(WeatherService weatherService, MailService mailService) {
        this.weatherService = weatherService;
        this.mailService = mailService;
    }

    // Run every day at 8:30 AM
    @Scheduled(cron = "0 30 08 * * ?", zone = "Europe/London")
    public void checkWeatherAndSendEmail() {
        mailService.sendWeatherAlert(weatherService.isRainExpectedInNext12Hours(),"sample@gmail.com","sample@gmail.com");
    }
}