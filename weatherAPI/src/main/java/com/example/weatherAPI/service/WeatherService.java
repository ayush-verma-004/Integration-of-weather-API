package com.example.weatherAPI.service;


import com.example.weatherAPI.model.WeatherRequest;
import com.example.weatherAPI.model.WeatherResponse;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.json.JSONObject;

@Service
public class WeatherService {

    @Autowired
    private WebClient.Builder webClientBuilder;

    private final String API_KEY = "YOUR_WEATHER_API";

    public WeatherResponse getWeatherData(WeatherRequest request) throws JSONException {
        String city = request.getCity();

        String uri = String.format("https://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s&units=metric", city, API_KEY);

        String apiResponse = webClientBuilder.build()
                .get()
                .uri(uri)
                .retrieve()
                .bodyToMono(String.class)
                .block();  // blocking for simplicity

        JSONObject json = new JSONObject(apiResponse);

        String temperature = json.getJSONObject("main").get("temp") + "°C";
        String description = json.getJSONArray("weather").getJSONObject(0).getString("description");
        String humidity = json.getJSONObject("main").get("humidity") + "%";
        String windSpeed = json.getJSONObject("wind").get("speed") + " m/s";

        return new WeatherResponse(city, temperature, description, humidity, windSpeed);
    }
}
