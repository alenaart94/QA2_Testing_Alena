package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Response {

    private Coord coord; //objekt response soderzhit v sebe objekt coord
    //private Weather weather;
    private Main main;
    private Wind wind;
    private Clouds clouds;
    private Sys sys;
    //private Overall overall;

//    public Overall getOverall() {
//        return overall;
//    }
//
//    public void setOverall(Overall overall) {
//        this.overall = overall;
//    }

    //getter and setter dolzhni bitj v ljubom objekte
    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

//    public Weather getWeather() {
//        return weather;
//    }
//
//    public void setWeather(Weather weather) {
//        this.weather = weather;
//    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public Sys getSys() {
        return sys;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }
}
