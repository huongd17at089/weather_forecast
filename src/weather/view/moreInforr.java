/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weather.view;

import java.awt.Color;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import org.json.JSONException;
import weather.data.WeatherResponse;
import weather.model.Forecast;
import weather.model.Location;

/**
 *
 * @author Admin
 */
public class moreInforr extends javax.swing.JFrame {

    /**
     * Creates new form moreInforr
     */
    int X, Y;
    private Forecast f;
    private ArrayList<Forecast> hourlyForecast;
    private ArrayList<Forecast> daylyForecast;
    private weather.data.WeatherResponse weatherResponse;
    public moreInforr(Forecast f) {
        initComponents();
        setSize(768, 1024);
        setLocationRelativeTo(null);
        btnBack.setBackground(new Color(0, 0, 0, 0));
        btnClose.setBackground(new Color(0, 0, 0, 0));
        btnMinium.setBackground(new Color(0, 0, 0, 0));
        setBackground(new Color(0, 0, 0, 0));
        pn1H.setBackground(new Color(0, 0, 0, 0));
        pn2H.setBackground(new Color(0, 0, 0, 0));
        pn3H.setBackground(new Color(0, 0, 0, 0));
        pn4H.setBackground(new Color(0, 0, 0, 0));
        pn5H.setBackground(new Color(0, 0, 0, 0));
        pnNow.setBackground(new Color(0, 0, 0, 0));
        pnSun.setBackground(new Color(0, 0, 0, 0));
        pnMon.setBackground(new Color(0, 0, 0, 0));
        pnTues.setBackground(new Color(0, 0, 0, 0));
        pnWed.setBackground(new Color(0, 0, 0, 0));
        pnThur.setBackground(new Color(0, 0, 0, 0));
        pnFri.setBackground(new Color(0, 0, 0, 0));
        pnSat.setBackground(new Color(0, 0, 0, 0));
        jActive1.setVisible(false);
        jActive2.setVisible(false);
        jActive3.setVisible(false);
        jActive4.setVisible(false);
        jActive5.setVisible(false);
        jActive6.setVisible(false);
        jActive7.setVisible(false);
        jActive7.setVisible(false);
        btnExitNet.setBackground(new Color(0, 0, 0, 0));
        pnNetWorkErr.setBackground(new Color(0, 0, 0, 0));
        pnNetWorkErr.setVisible(false);
        this.f = f;
        Location l = f.getLocation();
        txtDeg.setText(f.getTemp().get("current") + "°C");
        txtHumidity.setText(f.getHumidity() + "%");
        txtUV.setText(f.getUvi() + "nm");
        txtWindSpeed.setText(f.getWind_speed() + "m/s");
        weatherResponse = new WeatherResponse();
        try {
            hourlyForecast = weatherResponse.requestHourlyForecastByCoordinates(l);
//            hourNow.setText(hourlyForecast.get(0).getDt().getHours() + ":00");
            hour1H.setText(hourlyForecast.get(1).getDt().getHours()  + ":00");
            hour2H.setText(hourlyForecast.get(2).getDt().getHours()  + ":00");
            hour3H.setText(hourlyForecast.get(3).getDt().getHours()  + ":00");
            hour4H.setText(hourlyForecast.get(4).getDt().getHours()  + ":00");
            hour5H.setText(hourlyForecast.get(5).getDt().getHours()  + ":00");
            
            iconNow.setIcon(new ImageIcon("C:\\Users\\Huong\\Documents\\NetBeansProjects\\Weather\\pic\\" + hourlyForecast.get(0).getWeather().getIcon() + "_" + iconNow.getSize().width + ".png" ));
            icon1H.setIcon(new ImageIcon("C:\\Users\\Huong\\Documents\\NetBeansProjects\\Weather\\pic\\" + hourlyForecast.get(1).getWeather().getIcon() + "_" + icon1H.getSize().width + ".png" ));
            icon2H.setIcon(new ImageIcon("C:\\Users\\Huong\\Documents\\NetBeansProjects\\Weather\\pic\\" + hourlyForecast.get(2).getWeather().getIcon() + "_" + icon2H.getSize().width + ".png" ));
            icon3H.setIcon(new ImageIcon("C:\\Users\\Huong\\Documents\\NetBeansProjects\\Weather\\pic\\" + hourlyForecast.get(3).getWeather().getIcon() + "_" + icon3H.getSize().width + ".png" ));
            icon4H.setIcon(new ImageIcon("C:\\Users\\Huong\\Documents\\NetBeansProjects\\Weather\\pic\\" + hourlyForecast.get(4).getWeather().getIcon() + "_" + icon4H.getSize().width + ".png" ));
            icon5H.setIcon(new ImageIcon("C:\\Users\\Huong\\Documents\\NetBeansProjects\\Weather\\pic\\" + hourlyForecast.get(5).getWeather().getIcon() + "_" + icon5H.getSize().width + ".png" ));
//            System.out.println("C:\\Users\\Huong\\Documents\\NetBeansProjects\\Weather\\pic\\" + hourlyForecast.get(5).getWeather().getIcon() + "_" + icon5H.getSize().width + ".png");
            tempNow.setText(hourlyForecast.get(0).getTemp().get("current") + "°C");
            temp1H.setText(hourlyForecast.get(1).getTemp().get("current") + "°C");
            temp2H.setText(hourlyForecast.get(2).getTemp().get("current") + "°C");
            temp3H.setText(hourlyForecast.get(3).getTemp().get("current") + "°C");
            temp4H.setText(hourlyForecast.get(4).getTemp().get("current") + "°C");
            temp5H.setText(hourlyForecast.get(5).getTemp().get("current") + "°C");
            
            daylyForecast = weatherResponse.requestDailyForecastByCoordinates(l);
            jIcon1.setIcon(new ImageIcon("C:\\Users\\Huong\\Documents\\NetBeansProjects\\Weather\\pic\\" + daylyForecast.get(0).getWeather().getIcon() + "_" + jIcon1.getSize().width + ".png" ));
            jIcon2.setIcon(new ImageIcon("C:\\Users\\Huong\\Documents\\NetBeansProjects\\Weather\\pic\\" + daylyForecast.get(1).getWeather().getIcon() + "_" + jIcon2.getSize().width + ".png" ));
            jIcon3.setIcon(new ImageIcon("C:\\Users\\Huong\\Documents\\NetBeansProjects\\Weather\\pic\\" + daylyForecast.get(2).getWeather().getIcon() + "_" + jIcon3.getSize().width + ".png" ));
            jIcon4.setIcon(new ImageIcon("C:\\Users\\Huong\\Documents\\NetBeansProjects\\Weather\\pic\\" + daylyForecast.get(3).getWeather().getIcon() + "_" + jIcon4.getSize().width + ".png" ));
            jIcon5.setIcon(new ImageIcon("C:\\Users\\Huong\\Documents\\NetBeansProjects\\Weather\\pic\\" + daylyForecast.get(4).getWeather().getIcon() + "_" + jIcon5.getSize().width + ".png" ));
            jIcon6.setIcon(new ImageIcon("C:\\Users\\Huong\\Documents\\NetBeansProjects\\Weather\\pic\\" + daylyForecast.get(5).getWeather().getIcon() + "_" + jIcon6.getSize().width + ".png" ));
            jIcon7.setIcon(new ImageIcon("C:\\Users\\Huong\\Documents\\NetBeansProjects\\Weather\\pic\\" + daylyForecast.get(6).getWeather().getIcon() + "_" + jIcon7.getSize().width + ".png" ));
            
            jDeg1.setText(daylyForecast.get(0).getTemp().get("day") +"°C");
            jDeg2.setText(daylyForecast.get(1).getTemp().get("day") +"°C");
            jDeg3.setText(daylyForecast.get(2).getTemp().get("day") +"°C");
            jDeg4.setText(daylyForecast.get(3).getTemp().get("day") +"°C");
            jDeg5.setText(daylyForecast.get(4).getTemp().get("day") +"°C");
            jDeg6.setText(daylyForecast.get(5).getTemp().get("day") +"°C");
            jDeg7.setText(daylyForecast.get(6).getTemp().get("day") +"°C");
            
            SimpleDateFormat simpleDateformat = new SimpleDateFormat("E");
            jDay1.setText(simpleDateformat.format(daylyForecast.get(0).getDt()));
            jDay2.setText(simpleDateformat.format(daylyForecast.get(1).getDt()));
            jDay3.setText(simpleDateformat.format(daylyForecast.get(2).getDt()));
            jDay4.setText(simpleDateformat.format(daylyForecast.get(3).getDt()));
            jDay5.setText(simpleDateformat.format(daylyForecast.get(4).getDt()));
            jDay6.setText(simpleDateformat.format(daylyForecast.get(5).getDt()));
            jDay7.setText(simpleDateformat.format(daylyForecast.get(6).getDt()));
            
            simpleDateformat = new SimpleDateFormat("E, dd MMM yyyy");
            txtDate.setText(simpleDateformat.format(f.getDt()));
            iconWeather.setIcon(new ImageIcon("C:\\Users\\Huong\\Documents\\NetBeansProjects\\Weather\\pic\\" + f.getWeather().getIcon() + "_" + iconWeather.getSize().width + ".png" ));
        
        
        } catch (IOException ex) {
            Logger.getLogger(moreInforr.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(moreInforr.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(moreInforr.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnNetWorkErr = new javax.swing.JPanel();
        btnExitNet = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        txtDate = new javax.swing.JLabel();
        btnMinium = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        lbIconDeg = new javax.swing.JLabel();
        iconWeather = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtDeg = new javax.swing.JLabel();
        lbWind = new javax.swing.JLabel();
        lbVisibility = new javax.swing.JLabel();
        lbHumidity = new javax.swing.JLabel();
        lbUV = new javax.swing.JLabel();
        txtWindSpeed = new javax.swing.JLabel();
        txtVisibility = new javax.swing.JLabel();
        txtHumidity = new javax.swing.JLabel();
        txtUV = new javax.swing.JLabel();
        pn5H = new javax.swing.JPanel();
        hour5H = new javax.swing.JLabel();
        icon5H = new javax.swing.JLabel();
        temp5H = new javax.swing.JLabel();
        pn4H = new javax.swing.JPanel();
        hour4H = new javax.swing.JLabel();
        icon4H = new javax.swing.JLabel();
        temp4H = new javax.swing.JLabel();
        pn3H = new javax.swing.JPanel();
        hour3H = new javax.swing.JLabel();
        icon3H = new javax.swing.JLabel();
        temp3H = new javax.swing.JLabel();
        pn2H = new javax.swing.JPanel();
        hour2H = new javax.swing.JLabel();
        icon2H = new javax.swing.JLabel();
        temp2H = new javax.swing.JLabel();
        pn1H = new javax.swing.JPanel();
        hour1H = new javax.swing.JLabel();
        icon1H = new javax.swing.JLabel();
        temp1H = new javax.swing.JLabel();
        pnNow = new javax.swing.JPanel();
        hourNow = new javax.swing.JLabel();
        iconNow = new javax.swing.JLabel();
        tempNow = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        pnSat = new javax.swing.JPanel();
        jIcon7 = new javax.swing.JLabel();
        jDeg7 = new javax.swing.JLabel();
        jDay7 = new javax.swing.JLabel();
        jActive7 = new javax.swing.JLabel();
        pnFri = new javax.swing.JPanel();
        jIcon6 = new javax.swing.JLabel();
        jDeg6 = new javax.swing.JLabel();
        jDay6 = new javax.swing.JLabel();
        jActive6 = new javax.swing.JLabel();
        pnThur = new javax.swing.JPanel();
        jIcon5 = new javax.swing.JLabel();
        jDeg5 = new javax.swing.JLabel();
        jDay5 = new javax.swing.JLabel();
        jActive5 = new javax.swing.JLabel();
        pnWed = new javax.swing.JPanel();
        jIcon4 = new javax.swing.JLabel();
        jDeg4 = new javax.swing.JLabel();
        jDay4 = new javax.swing.JLabel();
        jActive4 = new javax.swing.JLabel();
        pnTues = new javax.swing.JPanel();
        jIcon3 = new javax.swing.JLabel();
        jDeg3 = new javax.swing.JLabel();
        jDay3 = new javax.swing.JLabel();
        jActive3 = new javax.swing.JLabel();
        pnMon = new javax.swing.JPanel();
        jIcon2 = new javax.swing.JLabel();
        jDeg2 = new javax.swing.JLabel();
        jDay2 = new javax.swing.JLabel();
        jActive2 = new javax.swing.JLabel();
        pnSun = new javax.swing.JPanel();
        jIcon1 = new javax.swing.JLabel();
        jDeg1 = new javax.swing.JLabel();
        jDay1 = new javax.swing.JLabel();
        jActive1 = new javax.swing.JLabel();
        BG = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(null);

        pnNetWorkErr.setLayout(null);

        btnExitNet.setBorder(null);
        pnNetWorkErr.add(btnExitNet);
        btnExitNet.setBounds(600, 330, 60, 50);

        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Users\\Huong\\Documents\\NetBeansProjects\\Weather\\pic\\NetWorkErr.png")); // NOI18N
        jLabel6.setMaximumSize(new java.awt.Dimension(726, 1024));
        jLabel6.setMinimumSize(new java.awt.Dimension(726, 1024));
        pnNetWorkErr.add(jLabel6);
        jLabel6.setBounds(0, 0, 768, 1024);

        getContentPane().add(pnNetWorkErr);
        pnNetWorkErr.setBounds(1000, 0, 768, 1024);

        btnBack.setIcon(new javax.swing.ImageIcon("C:\\Users\\Huong\\Documents\\NetBeansProjects\\Weather\\pic\\backIcon.png")); // NOI18N
        btnBack.setToolTipText("");
        btnBack.setBorder(null);
        btnBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBack.setPreferredSize(new java.awt.Dimension(42, 42));
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        getContentPane().add(btnBack);
        btnBack.setBounds(48, 31, 42, 42);

        txtDate.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        txtDate.setForeground(new java.awt.Color(227, 110, 121));
        txtDate.setText("Weather Forecast");
        getContentPane().add(txtDate);
        txtDate.setBounds(130, 144, 230, 28);

        btnMinium.setIcon(new javax.swing.ImageIcon("C:\\Users\\Huong\\Documents\\NetBeansProjects\\Weather\\pic\\Asset 4.png")); // NOI18N
        btnMinium.setToolTipText("");
        btnMinium.setBorder(null);
        btnMinium.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMinium.setPreferredSize(new java.awt.Dimension(42, 42));
        btnMinium.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMiniumActionPerformed(evt);
            }
        });
        getContentPane().add(btnMinium);
        btnMinium.setBounds(656, 31, 42, 42);

        btnClose.setIcon(new javax.swing.ImageIcon("C:\\Users\\Huong\\Documents\\NetBeansProjects\\Weather\\pic\\Asset 5.png")); // NOI18N
        btnClose.setToolTipText("");
        btnClose.setBorder(null);
        btnClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClose.setPreferredSize(new java.awt.Dimension(42, 42));
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        getContentPane().add(btnClose);
        btnClose.setBounds(706, 31, 42, 42);

        lbIconDeg.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 32)); // NOI18N
        lbIconDeg.setForeground(new java.awt.Color(247, 138, 85));
        lbIconDeg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lbIconDeg);
        lbIconDeg.setBounds(596, 129, 48, 48);

        iconWeather.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(iconWeather);
        iconWeather.setBounds(32, 113, 90, 90);

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(227, 110, 121));
        jLabel2.setText("Weather Forecast");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(248, 33, 272, 36);

        txtDeg.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 32)); // NOI18N
        txtDeg.setForeground(new java.awt.Color(247, 138, 85));
        txtDeg.setText("33 C");
        getContentPane().add(txtDeg);
        txtDeg.setBounds(620, 140, 90, 38);

        lbWind.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 22)); // NOI18N
        lbWind.setForeground(new java.awt.Color(72, 86, 123));
        lbWind.setText("Wind");
        getContentPane().add(lbWind);
        lbWind.setBounds(48, 232, 56, 28);

        lbVisibility.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 22)); // NOI18N
        lbVisibility.setForeground(new java.awt.Color(72, 86, 123));
        lbVisibility.setText("Visibility");
        getContentPane().add(lbVisibility);
        lbVisibility.setBounds(48, 276, 100, 28);

        lbHumidity.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 22)); // NOI18N
        lbHumidity.setForeground(new java.awt.Color(72, 86, 123));
        lbHumidity.setText("Humidity");
        getContentPane().add(lbHumidity);
        lbHumidity.setBounds(456, 232, 106, 28);

        lbUV.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 22)); // NOI18N
        lbUV.setForeground(new java.awt.Color(72, 86, 123));
        lbUV.setText("UV");
        getContentPane().add(lbUV);
        lbUV.setBounds(456, 276, 34, 28);

        txtWindSpeed.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 22)); // NOI18N
        txtWindSpeed.setForeground(new java.awt.Color(181, 98, 145));
        txtWindSpeed.setText("12Km/h");
        getContentPane().add(txtWindSpeed);
        txtWindSpeed.setBounds(217, 232, 100, 28);

        txtVisibility.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 22)); // NOI18N
        txtVisibility.setForeground(new java.awt.Color(181, 98, 145));
        txtVisibility.setText("12Km");
        getContentPane().add(txtVisibility);
        txtVisibility.setBounds(217, 276, 100, 28);

        txtHumidity.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 22)); // NOI18N
        txtHumidity.setForeground(new java.awt.Color(181, 98, 145));
        txtHumidity.setText("12Km");
        getContentPane().add(txtHumidity);
        txtHumidity.setBounds(631, 232, 100, 28);

        txtUV.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 22)); // NOI18N
        txtUV.setForeground(new java.awt.Color(181, 98, 145));
        txtUV.setText("12");
        getContentPane().add(txtUV);
        txtUV.setBounds(631, 276, 100, 28);

        pn5H.setBackground(new java.awt.Color(255, 255, 255));
        pn5H.setLayout(null);

        hour5H.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 22)); // NOI18N
        hour5H.setForeground(new java.awt.Color(46, 72, 89));
        hour5H.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hour5H.setText("17:00");
        pn5H.add(hour5H);
        hour5H.setBounds(0, 8, 80, 28);

        icon5H.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pn5H.add(icon5H);
        icon5H.setBounds(24, 44, 32, 32);

        temp5H.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 22)); // NOI18N
        temp5H.setForeground(new java.awt.Color(181, 98, 145));
        temp5H.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        temp5H.setText("22 C");
        pn5H.add(temp5H);
        temp5H.setBounds(0, 84, 80, 28);

        getContentPane().add(pn5H);
        pn5H.setBounds(624, 332, 80, 118);

        pn4H.setBackground(new java.awt.Color(255, 255, 255));
        pn4H.setLayout(null);

        hour4H.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 22)); // NOI18N
        hour4H.setForeground(new java.awt.Color(46, 72, 89));
        hour4H.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hour4H.setText("16:00");
        pn4H.add(hour4H);
        hour4H.setBounds(0, 8, 80, 28);

        icon4H.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pn4H.add(icon4H);
        icon4H.setBounds(24, 44, 32, 32);

        temp4H.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 22)); // NOI18N
        temp4H.setForeground(new java.awt.Color(181, 98, 145));
        temp4H.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        temp4H.setText("22 C");
        pn4H.add(temp4H);
        temp4H.setBounds(0, 84, 80, 28);

        getContentPane().add(pn4H);
        pn4H.setBounds(512, 332, 80, 118);

        pn3H.setBackground(new java.awt.Color(255, 255, 255));
        pn3H.setLayout(null);

        hour3H.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 22)); // NOI18N
        hour3H.setForeground(new java.awt.Color(46, 72, 89));
        hour3H.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hour3H.setText("15:00");
        pn3H.add(hour3H);
        hour3H.setBounds(0, 8, 80, 28);

        icon3H.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pn3H.add(icon3H);
        icon3H.setBounds(24, 44, 32, 32);

        temp3H.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 22)); // NOI18N
        temp3H.setForeground(new java.awt.Color(181, 98, 145));
        temp3H.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        temp3H.setText("22 C");
        pn3H.add(temp3H);
        temp3H.setBounds(0, 84, 80, 28);

        getContentPane().add(pn3H);
        pn3H.setBounds(400, 332, 80, 118);

        pn2H.setBackground(new java.awt.Color(255, 255, 255));
        pn2H.setLayout(null);

        hour2H.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 22)); // NOI18N
        hour2H.setForeground(new java.awt.Color(46, 72, 89));
        hour2H.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hour2H.setText("14:00");
        pn2H.add(hour2H);
        hour2H.setBounds(0, 8, 80, 28);

        icon2H.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pn2H.add(icon2H);
        icon2H.setBounds(24, 44, 32, 32);

        temp2H.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 22)); // NOI18N
        temp2H.setForeground(new java.awt.Color(181, 98, 145));
        temp2H.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        temp2H.setText("22 C");
        pn2H.add(temp2H);
        temp2H.setBounds(0, 84, 80, 28);

        getContentPane().add(pn2H);
        pn2H.setBounds(288, 332, 80, 118);

        pn1H.setBackground(new java.awt.Color(255, 255, 255));
        pn1H.setLayout(null);

        hour1H.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 22)); // NOI18N
        hour1H.setForeground(new java.awt.Color(46, 72, 89));
        hour1H.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hour1H.setText("13:00");
        pn1H.add(hour1H);
        hour1H.setBounds(0, 8, 80, 28);

        icon1H.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pn1H.add(icon1H);
        icon1H.setBounds(24, 44, 32, 32);

        temp1H.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 22)); // NOI18N
        temp1H.setForeground(new java.awt.Color(181, 98, 145));
        temp1H.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        temp1H.setText("22 C");
        pn1H.add(temp1H);
        temp1H.setBounds(0, 84, 80, 28);

        getContentPane().add(pn1H);
        pn1H.setBounds(176, 332, 80, 118);

        pnNow.setBackground(new java.awt.Color(255, 255, 255));
        pnNow.setLayout(null);

        hourNow.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 22)); // NOI18N
        hourNow.setForeground(new java.awt.Color(46, 72, 89));
        hourNow.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hourNow.setText("Now");
        pnNow.add(hourNow);
        hourNow.setBounds(15, 8, 51, 28);

        iconNow.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pnNow.add(iconNow);
        iconNow.setBounds(24, 44, 32, 32);

        tempNow.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 22)); // NOI18N
        tempNow.setForeground(new java.awt.Color(181, 98, 145));
        tempNow.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tempNow.setText("22 C");
        pnNow.add(tempNow);
        tempNow.setBounds(0, 84, 80, 28);

        getContentPane().add(pnNow);
        pnNow.setBounds(64, 332, 80, 118);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jPanel8);
        jPanel8.setBounds(48, 476, 672, 292);

        pnSat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnSatMouseClicked(evt);
            }
        });
        pnSat.setLayout(null);

        jIcon7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pnSat.add(jIcon7);
        jIcon7.setBounds(14, 22, 48, 48);

        jDeg7.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 20)); // NOI18N
        jDeg7.setForeground(new java.awt.Color(227, 110, 121));
        jDeg7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jDeg7.setText("33 C");
        pnSat.add(jDeg7);
        jDeg7.setBounds(0, 76, 75, 24);

        jDay7.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        jDay7.setForeground(new java.awt.Color(72, 86, 123));
        jDay7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jDay7.setText("Sat");
        pnSat.add(jDay7);
        jDay7.setBounds(0, 106, 75, 24);

        jActive7.setBackground(new java.awt.Color(255, 255, 255));
        jActive7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jActive7.setIcon(new javax.swing.ImageIcon("C:\\Users\\Huong\\Documents\\NetBeansProjects\\Weather\\pic\\active.png")); // NOI18N
        pnSat.add(jActive7);
        jActive7.setBounds(0, 0, 75, 160);

        getContentPane().add(pnSat);
        pnSat.setBounds(643, 792, 75, 160);

        pnFri.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnFriMouseClicked(evt);
            }
        });
        pnFri.setLayout(null);

        jIcon6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pnFri.add(jIcon6);
        jIcon6.setBounds(14, 22, 48, 48);

        jDeg6.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 20)); // NOI18N
        jDeg6.setForeground(new java.awt.Color(227, 110, 121));
        jDeg6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jDeg6.setText("33 C");
        pnFri.add(jDeg6);
        jDeg6.setBounds(0, 76, 75, 24);

        jDay6.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        jDay6.setForeground(new java.awt.Color(72, 86, 123));
        jDay6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jDay6.setText("Fri");
        pnFri.add(jDay6);
        jDay6.setBounds(0, 106, 75, 24);

        jActive6.setBackground(new java.awt.Color(255, 255, 255));
        jActive6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jActive6.setIcon(new javax.swing.ImageIcon("C:\\Users\\Huong\\Documents\\NetBeansProjects\\Weather\\pic\\active.png")); // NOI18N
        pnFri.add(jActive6);
        jActive6.setBounds(0, 0, 75, 160);

        getContentPane().add(pnFri);
        pnFri.setBounds(544, 792, 75, 160);

        pnThur.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnThurMouseClicked(evt);
            }
        });
        pnThur.setLayout(null);

        jIcon5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pnThur.add(jIcon5);
        jIcon5.setBounds(14, 22, 48, 48);

        jDeg5.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 20)); // NOI18N
        jDeg5.setForeground(new java.awt.Color(227, 110, 121));
        jDeg5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jDeg5.setText("33 C");
        pnThur.add(jDeg5);
        jDeg5.setBounds(0, 76, 75, 24);

        jDay5.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        jDay5.setForeground(new java.awt.Color(72, 86, 123));
        jDay5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jDay5.setText("Thur");
        pnThur.add(jDay5);
        jDay5.setBounds(0, 106, 75, 24);

        jActive5.setBackground(new java.awt.Color(255, 255, 255));
        jActive5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jActive5.setIcon(new javax.swing.ImageIcon("C:\\Users\\Huong\\Documents\\NetBeansProjects\\Weather\\pic\\active.png")); // NOI18N
        pnThur.add(jActive5);
        jActive5.setBounds(0, 0, 75, 160);

        getContentPane().add(pnThur);
        pnThur.setBounds(445, 792, 75, 160);

        pnWed.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnWedMouseClicked(evt);
            }
        });
        pnWed.setLayout(null);

        jIcon4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pnWed.add(jIcon4);
        jIcon4.setBounds(14, 22, 48, 48);

        jDeg4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 20)); // NOI18N
        jDeg4.setForeground(new java.awt.Color(227, 110, 121));
        jDeg4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jDeg4.setText("33 C");
        pnWed.add(jDeg4);
        jDeg4.setBounds(0, 76, 75, 24);

        jDay4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        jDay4.setForeground(new java.awt.Color(72, 86, 123));
        jDay4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jDay4.setText("Web");
        pnWed.add(jDay4);
        jDay4.setBounds(0, 106, 75, 24);

        jActive4.setBackground(new java.awt.Color(255, 255, 255));
        jActive4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jActive4.setIcon(new javax.swing.ImageIcon("C:\\Users\\Huong\\Documents\\NetBeansProjects\\Weather\\pic\\active.png")); // NOI18N
        pnWed.add(jActive4);
        jActive4.setBounds(0, 0, 75, 160);

        getContentPane().add(pnWed);
        pnWed.setBounds(346, 792, 75, 160);

        pnTues.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnTuesMouseClicked(evt);
            }
        });
        pnTues.setLayout(null);

        jIcon3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pnTues.add(jIcon3);
        jIcon3.setBounds(14, 22, 48, 48);

        jDeg3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 20)); // NOI18N
        jDeg3.setForeground(new java.awt.Color(227, 110, 121));
        jDeg3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jDeg3.setText("33 C");
        pnTues.add(jDeg3);
        jDeg3.setBounds(0, 76, 75, 24);

        jDay3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        jDay3.setForeground(new java.awt.Color(72, 86, 123));
        jDay3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jDay3.setText("Tue");
        pnTues.add(jDay3);
        jDay3.setBounds(0, 106, 75, 24);

        jActive3.setBackground(new java.awt.Color(255, 255, 255));
        jActive3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jActive3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Huong\\Documents\\NetBeansProjects\\Weather\\pic\\active.png")); // NOI18N
        pnTues.add(jActive3);
        jActive3.setBounds(0, 0, 75, 160);

        getContentPane().add(pnTues);
        pnTues.setBounds(247, 792, 75, 160);

        pnMon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnMonMouseClicked(evt);
            }
        });
        pnMon.setLayout(null);

        jIcon2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pnMon.add(jIcon2);
        jIcon2.setBounds(14, 22, 48, 48);

        jDeg2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 20)); // NOI18N
        jDeg2.setForeground(new java.awt.Color(227, 110, 121));
        jDeg2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jDeg2.setText("33 C");
        pnMon.add(jDeg2);
        jDeg2.setBounds(0, 76, 75, 24);

        jDay2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        jDay2.setForeground(new java.awt.Color(72, 86, 123));
        jDay2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jDay2.setText("Mon");
        pnMon.add(jDay2);
        jDay2.setBounds(0, 106, 75, 24);

        jActive2.setBackground(new java.awt.Color(255, 255, 255));
        jActive2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jActive2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Huong\\Documents\\NetBeansProjects\\Weather\\pic\\active.png")); // NOI18N
        pnMon.add(jActive2);
        jActive2.setBounds(0, 0, 75, 160);

        getContentPane().add(pnMon);
        pnMon.setBounds(148, 792, 75, 160);

        pnSun.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnSunMouseClicked(evt);
            }
        });
        pnSun.setLayout(null);

        jIcon1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pnSun.add(jIcon1);
        jIcon1.setBounds(14, 22, 48, 48);

        jDeg1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 20)); // NOI18N
        jDeg1.setForeground(new java.awt.Color(227, 110, 121));
        jDeg1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jDeg1.setText("33 C");
        pnSun.add(jDeg1);
        jDeg1.setBounds(0, 76, 75, 24);

        jDay1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        jDay1.setForeground(new java.awt.Color(72, 86, 123));
        jDay1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jDay1.setText("Sun");
        pnSun.add(jDay1);
        jDay1.setBounds(0, 106, 75, 24);

        jActive1.setBackground(new java.awt.Color(255, 255, 255));
        jActive1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jActive1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Huong\\Documents\\NetBeansProjects\\Weather\\pic\\active.png")); // NOI18N
        pnSun.add(jActive1);
        jActive1.setBounds(0, 0, 75, 160);

        getContentPane().add(pnSun);
        pnSun.setBounds(49, 792, 75, 160);

        BG.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        BG.setIcon(new javax.swing.ImageIcon("C:\\Users\\Huong\\Documents\\NetBeansProjects\\Weather\\pic\\bgMoreInfor.png")); // NOI18N
        BG.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                BGMouseDragged(evt);
            }
        });
        BG.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BGMousePressed(evt);
            }
        });
        getContentPane().add(BG);
        BG.setBounds(0, 0, 770, 1024);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        this.setVisible(false);
        (new main()).setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnMiniumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMiniumActionPerformed
        setState(this.ICONIFIED);
    }//GEN-LAST:event_btnMiniumActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed

        this.setVisible(false);
        (new miniMain(f)).setVisible(true);

    }//GEN-LAST:event_btnCloseActionPerformed

    private void pnSunMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnSunMouseClicked
        
        jActive2.setVisible(false);
        jActive3.setVisible(false);
        jActive4.setVisible(false);
        jActive5.setVisible(false);
        jActive6.setVisible(false);
        jActive7.setVisible(false);

        jActive1.setVisible(true);
        jDeg1.setForeground(Color.WHITE);
        jDay1.setForeground(Color.WHITE);
    }//GEN-LAST:event_pnSunMouseClicked

    private void pnMonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnMonMouseClicked
        jActive1.setVisible(!true);
        jActive3.setVisible(false);
        jActive4.setVisible(false);
        jActive5.setVisible(false);
        jActive6.setVisible(false);
        jActive7.setVisible(false);

        jActive2.setVisible(true);
        jDeg2.setForeground(Color.WHITE);
        jDay2.setForeground(Color.WHITE);

    }//GEN-LAST:event_pnMonMouseClicked

    private void pnTuesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnTuesMouseClicked
        jActive1.setVisible(false);
        jActive2.setVisible(false);
        jActive3.setVisible(false);
        jActive4.setVisible(false);
        jActive5.setVisible(false);
        jActive6.setVisible(false);
        jActive7.setVisible(false);

        jActive3.setVisible(true);
        jDeg3.setForeground(Color.WHITE);
        jDay3.setForeground(Color.WHITE);
    }//GEN-LAST:event_pnTuesMouseClicked

    private void pnWedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnWedMouseClicked
        jActive1.setVisible(false);
        jActive2.setVisible(false);
        jActive3.setVisible(false);
        jActive4.setVisible(false);
        jActive5.setVisible(false);
        jActive6.setVisible(false);
        jActive7.setVisible(false);
   
        jActive4.setVisible(true);
        jDeg4.setForeground(Color.WHITE);
        jDay4.setForeground(Color.WHITE);
    }//GEN-LAST:event_pnWedMouseClicked

    private void pnThurMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnThurMouseClicked
        jActive1.setVisible(false);
        jActive2.setVisible(false);
        jActive3.setVisible(false);
        jActive4.setVisible(false);
        jActive5.setVisible(false);
        jActive6.setVisible(false);
        jActive7.setVisible(false);
   
        jActive5.setVisible(true);
        jDeg5.setForeground(Color.WHITE);
        jDay5.setForeground(Color.WHITE);
    }//GEN-LAST:event_pnThurMouseClicked

    private void pnFriMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnFriMouseClicked
        jActive1.setVisible(false);
        jActive2.setVisible(false);
        jActive3.setVisible(false);
        jActive4.setVisible(false);
        jActive5.setVisible(false);
        jActive6.setVisible(false);
        jActive7.setVisible(false);

        jActive6.setVisible(true);
        jDeg6.setForeground(Color.WHITE);
        jDay6.setForeground(Color.WHITE);
    }//GEN-LAST:event_pnFriMouseClicked

    private void pnSatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnSatMouseClicked
        jActive1.setVisible(false);
        jActive2.setVisible(false);
        jActive3.setVisible(false);
        jActive4.setVisible(false);
        jActive5.setVisible(false);
        jActive6.setVisible(false);
        jActive7.setVisible(false);

        jActive7.setVisible(true);
        jDeg7.setForeground(Color.WHITE);
        jDay7.setForeground(Color.WHITE);
    }//GEN-LAST:event_pnSatMouseClicked

    private void BGMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BGMouseDragged
        this.setLocation((evt.getX()+this.getX())-X,( evt.getY()+this.getY())-Y);
    }//GEN-LAST:event_BGMouseDragged

    private void BGMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BGMousePressed
        X = evt.getX();
        Y = evt.getY();
    }//GEN-LAST:event_BGMousePressed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(moreInforr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(moreInforr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(moreInforr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(moreInforr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new moreInforr().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BG;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnExitNet;
    private javax.swing.JButton btnMinium;
    private javax.swing.JLabel hour1H;
    private javax.swing.JLabel hour2H;
    private javax.swing.JLabel hour3H;
    private javax.swing.JLabel hour4H;
    private javax.swing.JLabel hour5H;
    private javax.swing.JLabel hourNow;
    private javax.swing.JLabel icon1H;
    private javax.swing.JLabel icon2H;
    private javax.swing.JLabel icon3H;
    private javax.swing.JLabel icon4H;
    private javax.swing.JLabel icon5H;
    private javax.swing.JLabel iconNow;
    private javax.swing.JLabel iconWeather;
    private javax.swing.JLabel jActive1;
    private javax.swing.JLabel jActive2;
    private javax.swing.JLabel jActive3;
    private javax.swing.JLabel jActive4;
    private javax.swing.JLabel jActive5;
    private javax.swing.JLabel jActive6;
    private javax.swing.JLabel jActive7;
    private javax.swing.JLabel jDay1;
    private javax.swing.JLabel jDay2;
    private javax.swing.JLabel jDay3;
    private javax.swing.JLabel jDay4;
    private javax.swing.JLabel jDay5;
    private javax.swing.JLabel jDay6;
    private javax.swing.JLabel jDay7;
    private javax.swing.JLabel jDeg1;
    private javax.swing.JLabel jDeg2;
    private javax.swing.JLabel jDeg3;
    private javax.swing.JLabel jDeg4;
    private javax.swing.JLabel jDeg5;
    private javax.swing.JLabel jDeg6;
    private javax.swing.JLabel jDeg7;
    private javax.swing.JLabel jIcon1;
    private javax.swing.JLabel jIcon2;
    private javax.swing.JLabel jIcon3;
    private javax.swing.JLabel jIcon4;
    private javax.swing.JLabel jIcon5;
    private javax.swing.JLabel jIcon6;
    private javax.swing.JLabel jIcon7;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JLabel lbHumidity;
    private javax.swing.JLabel lbIconDeg;
    private javax.swing.JLabel lbUV;
    private javax.swing.JLabel lbVisibility;
    private javax.swing.JLabel lbWind;
    private javax.swing.JPanel pn1H;
    private javax.swing.JPanel pn2H;
    private javax.swing.JPanel pn3H;
    private javax.swing.JPanel pn4H;
    private javax.swing.JPanel pn5H;
    private javax.swing.JPanel pnFri;
    private javax.swing.JPanel pnMon;
    private javax.swing.JPanel pnNetWorkErr;
    private javax.swing.JPanel pnNow;
    private javax.swing.JPanel pnSat;
    private javax.swing.JPanel pnSun;
    private javax.swing.JPanel pnThur;
    private javax.swing.JPanel pnTues;
    private javax.swing.JPanel pnWed;
    private javax.swing.JLabel temp1H;
    private javax.swing.JLabel temp2H;
    private javax.swing.JLabel temp3H;
    private javax.swing.JLabel temp4H;
    private javax.swing.JLabel temp5H;
    private javax.swing.JLabel tempNow;
    private javax.swing.JLabel txtDate;
    private javax.swing.JLabel txtDeg;
    private javax.swing.JLabel txtHumidity;
    private javax.swing.JLabel txtUV;
    private javax.swing.JLabel txtVisibility;
    private javax.swing.JLabel txtWindSpeed;
    // End of variables declaration//GEN-END:variables
}
