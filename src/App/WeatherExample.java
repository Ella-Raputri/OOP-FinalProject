/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;

/**
 *
 * @author Asus
 */
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherExample {
    private static final String API_KEY = "53df037de4b6740e159a2d4f1841580f"; // Replace with your OpenWeatherMap API key
    private static final String WEATHER_URL = "http://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s";

    public static void main(String[] args) {
        String city = "Jakarta"; // Change this to the city you want to query
        getWeather(city);
    }

    public static void getWeather(String city) {
        try {
            String urlString = String.format(WEATHER_URL, city, API_KEY);
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                parseWeatherResponse(response.toString());
            } else {
                System.out.println("GET request failed. Response code: " + responseCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void parseWeatherResponse(String response) {
        JSONObject jsonObject = new JSONObject(response);

        String cityName = jsonObject.getString("name");
        JSONObject main = jsonObject.getJSONObject("main");
        double temperature = main.getDouble("temp");
        double tempInCelsius = temperature - 273.15; // Convert from Kelvin to Celsius

        System.out.println("City: " + cityName);
        System.out.println("Temperature: " + String.format("%.2f", tempInCelsius) + " °C");
    }
}

