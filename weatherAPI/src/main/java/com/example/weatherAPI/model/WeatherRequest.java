package com.example.weatherAPI.model;


public class WeatherRequest {
    private String city;

    public WeatherRequest() {}

    public WeatherRequest(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}