package com.sederikko.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    private final JavaMailSender mailSender;

    public MailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendWeatherAlert(boolean rainOrNot, String... recipientEmail) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("sample@gmail.com");
        message.setTo(recipientEmail);
        message.setSubject((rainOrNot) ? "Weather Alert: Raaaainiiiiiiiiiiiiiiiiing !!!" : "Not Raining ");
        message.setText((rainOrNot) ? "Hey, You need to bring an umbrella. Rain is expected in the next 12 hours." : "Hey, No need to bring an umbrella");

        mailSender.send(message);
    }
}