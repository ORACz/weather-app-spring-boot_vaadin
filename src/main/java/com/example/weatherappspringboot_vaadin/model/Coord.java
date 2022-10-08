package com.example.weatherappspringboot_vaadin.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Coord {
    @SerializedName("lon")
    @Expose
    private Double lon;  //Geographical coordinates of the location (longitude)

    @SerializedName("lat")
    @Expose
    private Double lat;  //Geographical coordinates of the location (latitude)


    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }
}
