package com.example.weatherappspringboot_vaadin.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//https://openweathermap.org/weather-conditions // weather_icons
public class Weather {
    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("temperature")
    @Expose
    private String temperature;

    @SerializedName("descriptions")
    @Expose
    private String descriptions;

    @SerializedName("icon")
    @Expose
    private String icon;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
