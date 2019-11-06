package com.ubr;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;


//?q={Query}&appid={Key}

class APIConnect {
    private static final String API_KEY = "0c1818989a9b42fe3c625ad9dcebc43e";
    private static final String API_URL = "http://api.openweathermap.org/data/2.5/weather";
    String city = "Seoul";

    public JSONObject connectAPI() throws Exception {
        String urlstr = API_URL + "?q=" + city + "&appid=" + API_KEY;
        URL url = new URL(urlstr);

        BufferedReader bf;
        String line;
        String result = "";

        bf = new BufferedReader(new InputStreamReader(url.openStream()));

        while ((line = bf.readLine()) != null) {
            result = result.concat(line);
        }

        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(result);

        return jsonObject;
    }

   /* StringBuilder builder;
    {
        try {
            builder = new StringBuilder(API_URL + "?")
                            .append(URLEncoder.encode("id", "UTF-8") + "=" + URLEncoder.encode("1835848", "UTF-8"))
                            .append("&" + URLEncoder.encode("appid", "UTF-8") + "=" + URLEncoder.encode(API_KEY, "UTF-8"));

            System.out.println(builder.toString());
            URL url = new URL(builder.toString());
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-type", "application/json");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String read = "";



        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

    /*String cityNmae = "Seoul";

    String urlstr = API_URL + "?" + "q=" + cityNmae + "&appid=" + API_KEY;
    URL url;

    {

        try {
            url = new URL(urlstr);

            BufferedReader bf;
            String line;
            String result = "";

            bf = new BufferedReader(new InputStreamReader(url.openStream()));

            while ((line = bf.readLine()) != null) {
                result = result.concat(line);
            }

            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(result);

            System.out.println(jsonObject.get("name"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

}