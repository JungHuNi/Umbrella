package com.ubr;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class Main {

    public static void main(String... args) throws Exception {
        final String API_URL = "http://api.openweathermap.org/data/2.5/weather?q=Seoul&appid=0c1818989a9b42fe3c625ad9dcebc43e";

        URL url = new URL(API_URL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Content-type", "application/json");

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String read = "";

        while ((read = reader.readLine()) != null) {
            System.out.println(read);
        }
    }
}
