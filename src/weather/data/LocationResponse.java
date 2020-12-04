/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weather.data;

import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import weather.model.Location;

/**
 *
 * @author Huong
 */
public class LocationResponse {
    private String ipstackKey = "940e700fe8748b034e3c809c02023ac4";
    private String locationiqKey = "pk.7ac589cca1fe0b7eca7c0e8a387819f8";
    
    public weather.model.Location getLocationByIp(String ip) throws IOException, JSONException{
        String q = "http://api.ipstack.com/" + ip + "?access_key=" + ipstackKey;
        String jsonString = weather.util.JsonReader.readJsonString(q);
        JSONObject json = new JSONObject(jsonString);
        float lat = Float.parseFloat(json.get("latitude").toString());
        float lon = Float.parseFloat(json.get("longitude").toString());
        String city = json.get("city").toString();
        String country = json.get("country_name").toString();
//        String flag = json.get("country_flag").toString();
        
        return new Location(lat, lon, city, country);
    }
    
    public void setCoordinatesByAddress (Location location) throws IOException, JSONException{
        String q = "https://us1.locationiq.com/v1/search.php?key=" + locationiqKey 
                + "&format=json&q=" + location.getCity() + "," + location.getCountry();
        String jsonString = weather.util.JsonReader.readJsonString(q);
        JSONObject json = new JSONArray(jsonString).getJSONObject(0);
        location.setLat(Float.parseFloat(json.get("lat").toString()));
        location.setLon(Float.parseFloat(json.get("lon").toString()));
        
    }
    
    //https://us1.locationiq.com/v1/search.php?key=pk.7ac589cca1fe0b7eca7c0e8a387819f8&format=json&q=hà nộgdfghgfhi,việdvxdfvft nam
    
}
