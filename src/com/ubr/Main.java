package com.ubr;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class Main {

        public static void main(String[] args) throws Exception {
            APIConnect apiConnect = new APIConnect();
            Result result = new Result(apiConnect);

            System.out.println(result.getCityName());
            System.out.println(result.getRain());
        }
}
