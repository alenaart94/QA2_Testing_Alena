package stepDefs;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.sl.In;
import model.Response;
import org.junit.jupiter.api.Assertions;
import requesters.WeatherRequester;

public class WeatherStepDefs {
//    @Given("Print welcome message")
//    public void print_message() {
//        System.out.println("Our first step ever!");
//    }

    private String city;
    private Response response;

    @Given("city is: (.*)")
    public void set_city(String city) {
        this.city = city;
    }


    @When("we are requesting weather")
    public void request_weather() throws JsonProcessingException {
        WeatherRequester requester = new WeatherRequester();
        response = requester.requestWeather(city);
    }

    @Then("lon is (.*)")
    public void check_lon(Double lon) {
        Assertions.assertEquals(lon, response.getCoord().getLon(), "Wrong lon");
    }

    @Then("lat is (.*)")
    public void check_lat(Double lat) {
        Assertions.assertEquals(lat, response.getCoord().getLat(), "Wrong lat");
    }

//    @Then("weather id is (.*)")
//    public void check_weather_id(Integer id) {
//        Assertions.assertEquals(id, response.getWeather().getId(), "Wrong weather ID!");
//    }

//    @Then("weather main is (.*)")
//    public void check_weather_main(String main) {
//        Assertions.assertEquals(main, response.getWeather().getMain(), "Wrong weather main");
//    }
//
//    @Then("weather description is (.*)")
//    public void check_weather_description(String description) {
//        Assertions.assertEquals(description, response.getWeather().getDescription(), "Wrong Weather description");
//    }
//
//    @Then("weather icon is (.*)")
//    public void check_weather_icon(String icon) {
//        Assertions.assertEquals(icon, response.getWeather().getIcon(), "Wrong Weather Icon");
//    }

//      @Then("base is (.*)")
//      public void check_base(String base) {
//        //Assertions.assertEquals(base, response.get);
//      }
    @Then("main temp is (.*)")
    public void check_main_temp(Double temp) {
        Assertions.assertEquals(temp, response.getMain().getTemp(), "Wrong main temp");
    }

    @Then("main pressure is (.*)")
    public void check_main_pressure(Integer pressure) {
        Assertions.assertEquals(pressure, response.getMain().getPressure(), "Wrong main pressure");
    }

    @Then("main humidity is (.*)")
    public void check_main_humidity(Integer humidity) {
        Assertions.assertEquals(humidity, response.getMain().getHumidity(), "Wrong main humidity");
    }

    @Then("main temp_min is (.*)")
    public void check_main_temp_min(Double temp_min) {
        Assertions.assertEquals(temp_min, response.getMain().getTemp_min(), "Wrong min temperature");
    }

    @Then("main temp_max is (.*)")
    public void check_main_temp_max(Double temp_max) {
        Assertions.assertEquals(temp_max, response.getMain().getTemp_max(), "Wrong max temperature");
    }

//    @Then("visibility is (.*)")
//    public void check_visibility(Integer visibility) {
//
//    }
    @Then("wind speed is (.*)")
    public void check_wind_speed(Double speed) {
        Assertions.assertEquals(speed, response.getWind().getSpeed(), "Wind speed is wrong");
    }

    @Then("wind deg is (.*)")
    public void check_wind_deg(Integer deg) {
        Assertions.assertEquals(deg, response.getWind().getDeg(), "Wrong wind deg value");
    }

    @Then("clouds all is (.*)")
    public void check_clouds_all (Integer all) {
        Assertions.assertEquals(all, response.getClouds().getAll(), "Wrong cloud value");
    }

//    @Then("dt is (.*)")
////    public void check_dt (Integer dt) {
////
////    }

    @Then("sys type is (.*)")
    public void check_sys_type (Integer type) {
        Assertions.assertEquals(type, response.getSys().getType(), "Wrong sys type");
    }

    @Then("sys id is (.*)")
    public void check_sys_id (Integer id) {
        Assertions.assertEquals(id, response.getSys().getId(), "Wrong sys ID");
    }

    @Then("sys message is (.*)")
    public void check_sys_message (Double message) {
        Assertions.assertEquals(message, response.getSys().getMessage(), "Wrong sys message");
    }

    @Then("sys country is (.*)")
    public void check_sys_country (String country) {
        Assertions.assertEquals(country, response.getSys().getCountry(), "Wrong sys country");
    }

    @Then("sys sunrise is (.*)")
    public void check_sys_sunrise (Integer sunrise) {
        Assertions.assertEquals(sunrise, response.getSys().getSunrise(), "Wrong sunrise");
    }

    @Then("sys sunset is (.*)")
    public void check_sys_sunset(Integer sunset) {
        Assertions.assertEquals(sunset, response.getSys().getSunset(), "Wrong sunset");
    }

//    @Then("id is (.*)")
//    public void check_id (Integer id) {
//        Assertions.assertEquals(id, response.getOverall().getId(), "Wrong ID");
//    }
//
//    @Then("name is (.*)")
//    public void check_name (Integer name) {
//        Assertions.assertEquals(name, response.getOverall().getId(), "Wrong name");//change
//    }
//
//    @Then("cod is (.*)")
//    public void check_cod (Integer cod) {
//        Assertions.assertEquals(cod, response.getOverall().getId(), "Wrong cod");//change
//    }
}
