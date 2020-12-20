/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weather.data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import weather.model.Forecast;
import weather.model.Location;
import weather.model.Weather;
import weather.util.JsonReader;

/**
 *
 * @author Huong
 */
public class WeatherResponse {

    private String openweathermapKey = "b9646b5c4862a50b506f75c00c3b6eda";
    private String lang = "vi";
    private String unit = "metric";

    private Forecast setForecastFeature(JSONObject json) {
        Forecast f = new Forecast();
        f.setDt(json.optInt("dt"));
        HashMap<String, Integer> temp = new HashMap<String, Integer>();
        if (json.optJSONObject("temp") != null) {
            JSONObject j = json.optJSONObject("temp");
            temp.put("day", (int)Float.parseFloat(j.opt("day").toString()));
            temp.put("night", (int)Float.parseFloat(j.opt("night").toString()));
            temp.put("eve", (int)Float.parseFloat(j.opt("eve").toString()));
            temp.put("morn", (int)Float.parseFloat(j.opt("morn").toString()));
            temp.put("min", (int)Float.parseFloat(j.opt("min").toString()));
            temp.put("max", (int)Float.parseFloat(j.opt("max").toString()));

        } else {

            temp.put("current", (int)Float.parseFloat(json.opt("temp").toString()));
        }
        f.setTemp(temp);
        f.setClouds(json.optInt("clouds"));
        f.setPressure(json.optInt("pressure"));
        f.setHumidity(json.optInt("humidity"));
        f.setDew_point(Float.parseFloat(json.opt("dew_point").toString()));
        if(json.has("rain")){
            JSONObject j = json.optJSONObject("rain");
            if( j != null)
                f.setRain(Float.parseFloat(j.opt("1h").toString()));
            else
                f.setRain(Float.parseFloat(json.opt("rain").toString()));
            
        }
        
        if(json.has("snow")){
            JSONObject j = json.optJSONObject("snow");
            if( j != null)
                f.setRain(Float.parseFloat(j.opt("1h").toString()));
            else
                f.setRain(Float.parseFloat(json.opt("snow").toString()));
            
        }
        if(json.has("snow"))
            f.setSnow(Float.parseFloat(json.opt("snow").toString()));
        if (json.has("wind_gust")) {
            f.setWind_gust(Float.parseFloat(json.opt("wind_gust").toString()));
        }

        f.setUvi(Float.parseFloat(json.opt("uvi").toString()));
        f.setVisibility(json.optInt("visibility"));
        f.setWind_deg(json.optInt("wind_deg"));
        f.setWind_speed(Float.parseFloat(json.opt("wind_speed").toString()));

        HashMap<String, Float> feelsLike = new HashMap<String, Float>();
        if (json.optJSONObject("feels_like") != null) {
            JSONObject j = json.optJSONObject("feels_like");
            feelsLike.put("day", Float.parseFloat(j.opt("day").toString()));
            feelsLike.put("night", Float.parseFloat(j.opt("night").toString()));
            feelsLike.put("eve", Float.parseFloat(j.opt("eve").toString()));
            feelsLike.put("morn", Float.parseFloat(j.opt("morn").toString()));

        } else {

            feelsLike.put("current", Float.parseFloat(json.opt("feels_like").toString()));
        }

        f.setFeels_like(feelsLike);
        JSONObject jso = json.optJSONArray("weather").optJSONObject(0);
        Weather weather = new Weather(
                jso.optInt("id"),
                jso.optString("main"),
                jso.optString("description"),
                jso.optString("icon"));
        f.setWeather(weather);

        return f;
    }

    public Forecast requestCurrentForecastByCoordinates(Location location) throws IOException, JSONException {
        String q = "http://api.openweathermap.org/data/2.5/onecall?lat=" + location.getLat() + "&lon="
                + location.getLon() + "&lang=" + lang + "&units=metric"+ "&exclude=minutely,hourly,daily"
                + "&units" + unit + "&appid=" + openweathermapKey;

        String jsonString = JsonReader.readJsonString(q);
        JSONObject json = new JSONObject(jsonString);
        location.setTimeZone(json.getString("timezone"));
        json = json.optJSONObject("current");
        Forecast f = setForecastFeature(json);
        f.setLocation(location);
        f.setType("CurrentWeatherForecas");
        return f;

    }

    public ArrayList<Forecast> requestHourlyForecastByCoordinates(Location location) throws IOException, JSONException {
        String q = "http://api.openweathermap.org/data/2.5/onecall?lat=" + location.getLat() + "&lon="
                + location.getLon() + "&lang=" + lang + "&units=metric" + "&exclude=current,minutely,daily"
                + "&units" + unit + "&appid=" + openweathermapKey;

        String jsonString = JsonReader.readJsonString(q);
        JSONObject json = new JSONObject(jsonString);
        location.setTimeZone(json.getString("timezone"));
        JSONArray jso = json.optJSONArray("hourly");
        ArrayList<Forecast> list = new ArrayList<>();
        int len = jso.length();
        for (int i = 0; i < len; i++) {
            Forecast f = setForecastFeature(jso.optJSONObject(i));
            f.setLocation(location);
            f.setType("hourlyWeatherForecas");
            list.add(f);
        }
        return list;
    }

    public ArrayList<Forecast> requestDailyForecastByCoordinates(Location location) throws IOException, JSONException {
        String q = "http://api.openweathermap.org/data/2.5/onecall?lat=" + location.getLat() + "&lon="
                + location.getLon() + "&lang=" + lang + "&units=metric"+ "&exclude=current,minutely,hourly"
                + "&units" + unit + "&appid=" + openweathermapKey;

        String jsonString = JsonReader.readJsonString(q);
//        System.out.println(jsonString);
        JSONObject json = new JSONObject(jsonString);
        location.setTimeZone(json.getString("timezone"));
        JSONArray jso = json.optJSONArray("daily");
        ArrayList<Forecast> list = new ArrayList<>();
        int len = jso.length();
        for (int i = 0; i < len; i++) {
            Forecast f = setForecastFeature(jso.getJSONObject(i));
            f.setLocation(location);
            f.setType("DailyWeatherForecas");
            list.add(f);
        }
        return list;
    }
}
