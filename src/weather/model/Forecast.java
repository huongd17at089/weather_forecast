/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weather.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Huong
 */
public class Forecast {
    private String type;
    private Location location;
    private int dt;
    private HashMap<String,Integer> temp;
    private HashMap<String,Float> feels_like;
    private int pressure;
    private int humidity;
    private float dew_point;
    private int clouds;
    private float uvi;
    private int visibility;
    private float wind_speed;
    private float wind_gust;
    private int wind_deg;
    private float rain;
    private float snow;
    private Weather weather;

    public Forecast() {
        rain = 0;
        snow = 0;
        wind_gust = 0;
    }

    public Forecast(String type, Location location, int dt, HashMap<String,Integer> temp, HashMap<String,Float> feels_like, int pressure, int humidity, float dew_point, int clouds, float uvi, int visibility, float wind_speed, float wind_gust, int wind_deg, float rain, float snow, Weather weather) {
        this.type = type;
        this.location = location;
        this.dt = dt;
        this.temp = temp;
        this.feels_like = feels_like;
        this.pressure = pressure;
        this.humidity = humidity;
        this.dew_point = dew_point;
        this.clouds = clouds;
        this.uvi = uvi;
        this.visibility = visibility;
        this.wind_speed = wind_speed;
        this.wind_gust = wind_gust;
        this.wind_deg = wind_deg;
        this.rain = rain;
        this.snow = snow;
        this.weather = weather;
    }

    

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }
    
    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Date getDt() throws ParseException {
        SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
        sdf.setTimeZone(java.util.TimeZone.getTimeZone(location.getTimeZone()));
        return sdf.parse(sdf.format(new Date(dt * 1000L)));
    }

    public void setDt(int dt) {
        this.dt = dt;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public HashMap<String,Integer> getTemp() {
        return temp;
    }

    public void setTemp(HashMap<String,Integer> temp) {
        this.temp = temp;
    }

    public HashMap<String,Float> getFeels_like() {
        return feels_like;
    }

    public void setFeels_like(HashMap<String,Float> feels_like) {
        this.feels_like = feels_like;
    }

    

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public float getDew_point() {
        return dew_point;
    }

    public void setDew_point(float dew_point) {
        this.dew_point = dew_point;
    }

    public int getClouds() {
        return clouds;
    }

    public void setClouds(int clouds) {
        this.clouds = clouds;
    }

    public float getUvi() {
        return uvi;
    }

    public void setUvi(float uvi) {
        this.uvi = uvi;
    }

    public int getVisibility() {
        return visibility;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    public float getWind_speed() {
        return wind_speed;
    }

    public void setWind_speed(float wind_speed) {
        this.wind_speed = wind_speed;
    }

    public float getWind_gust() {
        return wind_gust;
    }

    public void setWind_gust(float wind_gust) {
        this.wind_gust = wind_gust;
    }

    public int getWind_deg() {
        return wind_deg;
    }

    public void setWind_deg(int wind_deg) {
        this.wind_deg = wind_deg;
    }

    public float getRain() {
        return rain;
    }

    public void setRain(float rain) {
        this.rain = rain;
    }

    public float getSnow() {
        return snow;
    }

    public void setSnow(float snow) {
        this.snow = snow;
    }

    @Override
    public String toString(){
        try {
            return "Forecast{" + "type=" + type + ", location=" + location + ", dt=" + this.getDt().toString() +
                    ", temp=" + temp + ", feels_like=" + feels_like + ", pressure=" +
                    pressure + ", humidity=" + humidity + ", dew_point=" + dew_point +
                    ", clouds=" + clouds + ", uvi=" + uvi + ", visibility=" + visibility +
                    ", wind_speed=" + wind_speed + ", wind_gust=" + wind_gust + ", wind_deg=" +
                    wind_deg + ", rain=" + rain + ", snow=" + snow + ", weather=" + weather + '}';
        } catch (ParseException ex) {
            Logger.getLogger(Forecast.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    
    
    
}
