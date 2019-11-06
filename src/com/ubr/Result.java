package com.ubr;

import org.json.simple.JSONObject;

public class Result{

    APIConnect apiConnect = new APIConnect();
    JSONObject jsonObject;

    {
        try {
            jsonObject = apiConnect.connectAPI();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    String city = "";
    int rain;

    public Result(APIConnect apiConnect){
        this.apiConnect = apiConnect;
    }

    public String getCityName(){
        try {
            //jsonObject = apiConnect.connectAPI();
            city = jsonObject.get("name").toString();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return city;
    }

    public int getRain(){
        try {
            //jsonObject = apiConnect.connectAPI();
            rain = (int) jsonObject.get("rain[3h]");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rain;

    }

}