///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package abc.util;
//
//import java.util.Properties;
//import javax.mail.Message;
//import javax.mail.Message.RecipientType;
//import javax.mail.MessagingException;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.AddressException;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//
///**
// *
// * @author Huong
// */
//public class EmailUtil {
//
//    private static final String SENDERS_EMAIL = "ahbcgd590@gmail.com";
//    private static final String SENDER_PASS = "102102102";
//    
//    private static final String RECIEVERS_EMAIL = "ahbcgd590@gmail.com";
//    
//    private static Properties mailServerProperties;
//    private static Session mailSession;
//    private static MimeMessage mailMessage;
//    
//    public static void sendMail(String sub, String content) throws AddressException, MessagingException{
//        mailServerProperties = System.getProperties();
//        mailServerProperties.put("mail.smtp.port", "587");
//        mailServerProperties.put("mail.smtp.auth", "true");
//        mailServerProperties.put("mail.smtp.starttls.enable", "true");
//        
//        mailSession = Session.getDefaultInstance(mailServerProperties);
//        mailMessage = new MimeMessage(mailSession);
//        mailMessage.addRecipient(RecipientType.TO, new InternetAddress(RECIEVERS_EMAIL));
//        mailMessage.setSubject(sub);
//        mailMessage.setContent(content, "text/html");
//        
//        Transport transport = mailSession.getTransport("smtp");
//        transport.connect("smtp.gmail.com", SENDERS_EMAIL, SENDER_PASS);
//        transport.sendMessage(mailMessage, mailMessage.getRecipients(RecipientType.TO));
//        transport.close();
//        
//    }
//}
