package com.example.weatherAPI.controller;


import com.example.weatherAPI.model.WeatherRequest;
import com.example.weatherAPI.model.WeatherResponse;
import com.example.weatherAPI.service.WeatherService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @PostMapping
    public WeatherResponse getWeather(@RequestBody WeatherRequest request) throws JSONException {
        return weatherService.getWeatherData(request);
    }
}