package com.ubr;

import org.json.simple.JSONObject;

public class Result{

    APIConnect apiConnect = null;
    JSONObject jsonObject = null;
    String city = "";
    String rain = "";

    public Result(APIConnect apiConnect){
        this.apiConnect = apiConnect;
    }

    public String getCityName(){
        try {
            jsonObject = apiConnect.connectAPI();
            city = jsonObject.get("name").toString();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return city;
    }

    public String getRain(){
        try {
            jsonObject = apiConnect.connectAPI();
            rain = jsonObject.get("rain").toString();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rain;

    }

}