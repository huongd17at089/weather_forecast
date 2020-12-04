/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weather;

import weather.util.JsonReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import weather.model.Forecast;
import weather.model.Location;

/**
 *
 * @author Huong
 */
public class NewClass {
    public static void main(String[] args) throws IOException, JSONException {
//        String s = JsonReader.readJsonString("https://us1.locationiq.com/v1/search.php?key=pk.7ac589cca1fe0b7eca7c0e8a387819f8&format=json&q=hanoi,vietnam");
//        s = s.substring(1, s.length()-1);
//        JSONObject json = new JSONObject(s);
//        System.out.println(json.toString());
//          weather.model.Location location = new weather.data.LocationResponse().getLocationByIp(weather.data.GetIp.getExternalIpV4());
//          System.out.println(location.getCity());
//            weather.model.Location location = new Location("hanoi", "vietnam");
//            new weather.data.LocationResponse().setCoordinatesByAddress(location);
//            System.out.println(location.getLat());
        weather.model.Location location = new Location("ha noi", "");
        try {
            new weather.data.LocationResponse().setCoordinatesByAddress(location);
            System.out.println(location);
        ArrayList<Forecast> list = new weather.data.WeatherResponse().requestDailyForecastByCoordinates(location);
        for( int i = 0; i < list.size(); i++)
            System.out.println(list.get(i));
//Forecast f= new weather.data.WeatherResponse().re;
//            System.out.println(f);
        } catch (IOException ex) {
//            Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
System.out.println("khong tim thay vi tri hoac k co mang");
        } catch (JSONException ex) {
            System.out.println("ok");
        }
        
        
    }
}


