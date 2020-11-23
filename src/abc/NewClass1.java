/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abc;

import abc.handler.Logger;
import java.io.IOException;
import java.util.ArrayList;
import javax.mail.MessagingException;

/**
 *
 * @author Huong
 */
public class NewClass1 {
    public static void main(String[] args) throws IOException, MessagingException {
//        FileWriter myWriter = new FileWriter("filename.txt");
//      myWriter.write("Files in Java might be tricky, but it is fun enough!");
//      myWriter.close();
//      myWriter.write("Files in Java might be tricky, but it is fun enough!");
//        MailSender sender = new MailSender();
//        sender.sendMail("test", "filename.txt");
//    File myObj = new File("filename.txt"); 
//        System.out.println(myObj.length());
//    if (myObj.delete()) { 
//      System.out.println("Deleted the folder: " + myObj.getName());
//      FileWriter myWriter = new FileWriter(myObj);
//      myWriter.write("Files in Java might be tricky, but it is fun enough!");
//      myWriter.close();
//    } else {
//      System.out.println("Failed to delete the folder.");
//    } 
ArrayList<String> buffer = new ArrayList<>();
buffer.add("a");
buffer.add("e");
//String str = String.join(", ", buffer);; 
//        System.out.println(str);
Logger l = new Logger();
        System.out.println(l.isFullFile());

    }
}
