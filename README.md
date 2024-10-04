# Weather Alert Application

This Spring Boot application checks the weather forecast using the [OpenWeatherMap API](https://openweathermap.org/) and sends an email alert if rain is expected in the next 12 hours. The application uses `@Scheduled` tasks to automate this process and runs daily at 8:30 AM.

## Features

- Fetches weather data from OpenWeatherMap API based on the specified latitude and longitude.
- Parses the weather forecast and checks for rain or thunderstorms within the next 12 hours.
- Sends an email alert if rain is detected.
- Configurable through `application.properties`.
- Scheduled to run every day at 8:30 AM using Spring's `@Scheduled` annotation.

## Technologies Used

- **Java 21** (or higher)
- **Spring Boot** for backend service
- **Spring Mail** for sending emails
- **Spring Scheduler** for task scheduling
- **RestTemplate** for making RESTful API calls
- **OpenWeatherMap API** for weather data

## Prerequisites

1. **Java 21** or above installed.
2. **Maven** or **Gradle** for dependency management.
3. **Gmail account** with 2-Step Verification enabled and [App Password](https://support.google.com/accounts/answer/185833?hl=en) generated.
4. **OpenWeatherMap API Key**. Register and obtain your API key [here](https://home.openweathermap.org/users/sign_up).

## Setup

1. Clone the repository:

    ```bash
    git clone https://github.com/yourusername/weather-alert-app.git
    cd weather-alert-app
    ```

2. Update the `application.properties` file with your credentials and configuration:

    ```properties
    # Weather API Configuration
    weather.api.key=YOUR_OPENWEATHERMAP_API_KEY
    weather.latitude=YOUR_LATITUDE
    weather.longitude=YOUR_LONGITUDE

    # Spring Mail Configuration (Gmail SMTP)
    spring.mail.host=smtp.gmail.com
    spring.mail.port=587
    spring.mail.username=your-email@gmail.com
    spring.mail.password=YOUR_APP_SPECIFIC_PASSWORD
    spring.mail.properties.mail.smtp.auth=true
    spring.mail.properties.mail.smtp.starttls.enable=true

    # Scheduling Time Zone
    spring.task.scheduling.timezone=Europe/London
    ```

3. Build and run the application:

    ```bash
    ./mvnw spring-boot:run
    ```

4. Verify that the application is running. You should see logs indicating that the scheduled task is running at 8:30 AM each day.

## Running the Application

The application will automatically run every day at 8:30 AM (as configured in the `WeatherScheduler` class). You can modify the scheduled time by changing the `@Scheduled` annotation:

```java
@Scheduled(cron = "0 30 8 * * ?", zone = "Europe/London")
