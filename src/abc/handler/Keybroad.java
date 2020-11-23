/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abc.handler;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

/**
 *
 * @author Huong
 */
public class Keybroad implements NativeKeyListener{
    
    private ArrayList<String> keyBuffer = new ArrayList<>();
    private final int bufferSize = 10;
    
    @Override
    public void nativeKeyPressed(NativeKeyEvent e) {
        keyBuffer.add(KeyEvent.getKeyText(e.getKeyCode()));
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent e) {
        keyBuffer.add(KeyEvent.getKeyText(e.getKeyCode()));
    }
    

    @Override
    public void nativeKeyTyped(NativeKeyEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ArrayList<String> getKeyBuffer() {
        return keyBuffer;
    }
    
    public boolean isFullBuffer() {
        return keyBuffer.size() >= this.bufferSize;
    }
    
    public void refreshBuffers(){
        keyBuffer.clear();
    }
}
