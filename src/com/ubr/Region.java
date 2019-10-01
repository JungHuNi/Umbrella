package com.ubr;

public enum Region {
    Seoul("Seoul");

    private String query;

    Region(String query){
        this.query = query;
    }

    public String getQuery(){
        return query;
    }
}
