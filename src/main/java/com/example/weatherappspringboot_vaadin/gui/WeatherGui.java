package com.example.weatherappspringboot_vaadin.gui;

import com.example.weatherappspringboot_vaadin.model.WeatherApi;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@Route("weather")
@StyleSheet("/style.css")
@HtmlImport("/style.html")
public class WeatherGui extends VerticalLayout {
    private String city;
    private String units = "metric";
    private final String apiKey = "db6239bd53a1e1713d28cd4f1e88ec9f";

    private ResponseEntity<WeatherApi> connectToApi() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<WeatherApi> exchange = restTemplate.exchange(
                "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&units=" + units + "&APPID=" + apiKey,
                HttpMethod.GET,
                HttpEntity.EMPTY,
                com.example.weatherappspringboot_vaadin.model.WeatherApi.class
        );

        return exchange;
    }

    public WeatherGui() {
        TextField textFieldSetCity = new TextField("Enter a city:");
        Button buttonCheckWeather = new Button("Check weather!");

        Label labelCityAndCountry = new Label();
        Image weatherIcon = new Image();
        Label labelTemperature = new Label();
        Label labelPressure = new Label();
        Label labelWind = new Label();
        Label labelWindSpeed = new Label();
        Label labelWindDegrees = new Label();
        Label labelLocation = new Label();
        Label labelLocationLongitude = new Label();
        Label labelLocationLatitude = new Label();

        buttonCheckWeather.addClickShortcut(Key.ENTER);

        textFieldSetCity.getClassNames().add("textFieldSetCity");
        buttonCheckWeather.getClassNames().add("buttonCheckWeather");

        labelCityAndCountry.getClassNames().add("labelCityAndCountry");
        labelTemperature.getClassNames().add("labelTemperature");
        labelPressure.getClassNames().add("labelPressure");
        labelWind.getClassNames().add("labelWind");
        labelWindSpeed.getClassNames().add("labelWindSpeed");
        labelWindDegrees.getClassNames().add("labelWindDegrees");
        labelLocation.getClassNames().add("labelLocation");
        labelLocationLongitude.getClassNames().add("labelLocationLongitude");
        labelLocationLatitude.getClassNames().add("labelLocationLatitude");

        buttonCheckWeather.addClickListener(clickEvent -> {
            this.city = textFieldSetCity.getValue();

            labelCityAndCountry.setText(connectToApi().getBody().getName() + ", " + connectToApi().getBody().getSys().getCountry());
            weatherIcon.setSrc("http://openweathermap.org/img/wn/" + connectToApi().getBody().getWeather().get(0).getIcon() + "@2x.png");
            labelTemperature.setText("Temperature: " + connectToApi().getBody().getMain().getTemp().intValue() + "??C");
            labelPressure.setText("Pressure: " + connectToApi().getBody().getMain().getPressure() + " hPa");
            labelWind.setText("Wind:");
            labelWindSpeed.setText("Speed: " + connectToApi().getBody().getWind().getSpeed() + " m/s");
            labelWindDegrees.setText("Degrees: " + connectToApi().getBody().getWind().getDeg() + "??");
            labelLocation.setText("Location of city:");
            labelLocationLongitude.setText("Longitude: " + connectToApi().getBody().getCoord().getLon());
            labelLocationLatitude.setText("Latitude: " + connectToApi().getBody().getCoord().getLat());

            textFieldSetCity.setValue("");
        });

        add(
                textFieldSetCity,
                buttonCheckWeather,
                labelCityAndCountry,
                weatherIcon,
                labelTemperature,
                labelPressure,
                labelWind,
                labelWindSpeed,
                labelWindDegrees,
                labelLocation,
                labelLocationLongitude,
                labelLocationLatitude
        );
    }
}

