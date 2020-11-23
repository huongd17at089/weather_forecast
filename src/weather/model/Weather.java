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
public class Weather {
    private int id;
    private String main;
    private String des;
    private String icon;

    public Weather() {
    }

    public Weather(int id, String main, String des, String icon) {
        this.id = id;
        this.main = main;
        this.des = des;
        this.icon = icon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        return "Weather{" + "id=" + id + ", main=" + main + ", des=" + des + ", icon=" + icon + '}';
    }
    
    
}
