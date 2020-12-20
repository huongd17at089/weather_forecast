/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weather.view;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.Timer;
import org.json.JSONException;
import weather.data.WeatherResponse;
import weather.model.Forecast;
import weather.model.Location;

/**
 *
 * @author Admin
 */
public class miniMain extends javax.swing.JFrame {

    /**
     * Creates new form miniMain
     */
    private int X, Y;
    private weather.data.WeatherResponse weatherResponse;
    private Location location;

    public miniMain(Forecast f) {
        initComponents();
        // if f null - > k co mang
        weatherResponse = new WeatherResponse();
        Timer tim = new Timer(1800000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                try {
                    update();
                    
                } catch (IOException ex) {
//                    pnNetWorkErr.setVisible(true);
                } catch (JSONException ex) {
                    Logger.getLogger(moreInforr.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        });
tim.start();
        setBackground(new Color(72, 86, 123));
        btnClose.setBackground(new Color(0, 0, 0, 0));
        btnMinium.setBackground(new Color(0, 0, 0, 0));
        location = f.getLocation();
        try {
            update();
        } catch (IOException ex) {
//            Logger.getLogger(miniMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(miniMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        txtCountryName.setText(location.getCity() + "," + location.getCountry());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtCountryName = new javax.swing.JLabel();
        txtDeg = new javax.swing.JLabel();
        iconWeather = new javax.swing.JLabel();
        btnMinium = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(72, 86, 123));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });
        jPanel1.setLayout(null);

        txtCountryName.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        txtCountryName.setForeground(new java.awt.Color(255, 255, 255));
        txtCountryName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtCountryName.setText("Ha Noi, Viet Nam");
        jPanel1.add(txtCountryName);
        txtCountryName.setBounds(0, 155, 275, 17);

        txtDeg.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 48)); // NOI18N
        txtDeg.setForeground(new java.awt.Color(255, 255, 255));
        txtDeg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtDeg.setText("33 C");
        jPanel1.add(txtDeg);
        txtDeg.setBounds(0, 92, 275, 57);

        iconWeather.setPreferredSize(new java.awt.Dimension(48, 48));
        jPanel1.add(iconWeather);
        iconWeather.setBounds(117, 33, 48, 48);

        btnMinium.setIcon(new javax.swing.ImageIcon(getClass().getResource("/minium.png"))); // NOI18N
        btnMinium.setToolTipText("");
        btnMinium.setBorder(null);
        btnMinium.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMinium.setPreferredSize(new java.awt.Dimension(42, 42));
        btnMinium.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMiniumActionPerformed(evt);
            }
        });
        jPanel1.add(btnMinium);
        btnMinium.setBounds(190, 0, 42, 42);

        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/close.png"))); // NOI18N
        btnClose.setToolTipText("");
        btnClose.setBorder(null);
        btnClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClose.setPreferredSize(new java.awt.Dimension(42, 42));
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        jPanel1.add(btnClose);
        btnClose.setBounds(230, 0, 42, 42);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMiniumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMiniumActionPerformed
        setState(this.ICONIFIED);
    }//GEN-LAST:event_btnMiniumActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed

        setState(HIDE_ON_CLOSE);
    }//GEN-LAST:event_btnCloseActionPerformed

    private void update() throws IOException, JSONException {
        Forecast f = weatherResponse.requestCurrentForecastByCoordinates(location);
        this.setLocation(Toolkit.getDefaultToolkit().getScreenSize().width - this.getWidth(), Toolkit.getDefaultToolkit().getScreenSize().height - this.getHeight());
        txtDeg.setText(f.getTemp().get("current") + "°C");
        iconWeather.setIcon(new ImageIcon("pic\\" + f.getWeather().getIcon() + "_" + iconWeather.getSize().width + ".png"));
    }
    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        if (evt.getClickCount() == 2 && !evt.isConsumed()) {
            this.setVisible(false);
            (new main()).setVisible(true);

        }
    }//GEN-LAST:event_jPanel1MouseClicked

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
//            java.util.logging.Logger.getLogger(miniMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(miniMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(miniMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(miniMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new miniMain().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnMinium;
    private javax.swing.JLabel iconWeather;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel txtCountryName;
    private javax.swing.JLabel txtDeg;
    // End of variables declaration//GEN-END:variables
}
