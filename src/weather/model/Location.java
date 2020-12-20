/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weather.model;

/**
 *
 * @author Huong
 */
public class Location {
    private float lat;
    private float lon;
    private String city;
    private String Country;
    private String timeZone;
//    private String flagURL;

    public Location() {
    }

    public Location(float lat, float lon, String city, String Country, String timeZone) {
        this.lat = lat;
        this.lon = lon;
        this.city = city;
        this.Country = Country;
        this.timeZone = timeZone;
      //  this.flagURL = flagURL;
    }
    
    public Location(float lat, float lon, String city, String Country) {
        this.lat = lat;
        this.lon = lon;
        this.city = city;
        this.Country = Country;
        
      //  this.flagURL = flagURL;
    }

    public Location(String city, String Country) {
        this.city = city;
        this.Country = Country;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }
    

//    public String getFlagURL() {
//        return flagURL;
//    }
//
//    public void setFlagURL(String flagURL) {
//        this.flagURL = flagURL;
//    }

    

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getLon() {
        return lon;
    }

    public void setLon(float lon) {
        this.lon = lon;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String Country) {
        this.Country = Country;
    }

    @Override
    public String toString() {
        return "Location{" + "lat=" + lat + ", lon=" + lon + ", city=" + city + ", Country=" + Country + '}';
    }
    
    
}
