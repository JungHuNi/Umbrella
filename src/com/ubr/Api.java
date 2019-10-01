package com.ubr;

public class Api {
    private static Api Instance;

    private Api() {}

    //객체를 한번만 생성하기 위해
    public static synchronized Api getAPI(){
        if(Instance == null){
            Instance = new Api();
        }
        return Instance;
    }





}