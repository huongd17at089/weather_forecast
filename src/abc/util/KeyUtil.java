///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package abc.util;
//
//import abc.handler.NativeKey;
//import java.awt.event.KeyEvent;
//import java.util.Date;
//import java.util.List;
//
///**
// *
// * @author Huong
// */
//public final class KeyUtil {
//
//    public static String getKeylog(List<NativeKey> storage) {
//        if (storage.isEmpty()) {
//            return null;
//        }
//
//        StringBuilder sb = new StringBuilder();
//        sb.append("KeyLog : " + new Date().toString() + "....");
//        boolean[] caps = new boolean[256];
//        for (NativeKey nativeKey : storage) {
//            caps[nativeKey.getKeyCode()] = nativeKey.isPressed();
//            String key = getKeyText(nativeKey.getKeyCode(), caps[KeyEvent.VK_SHIFT]);
//            
//            if(nativeKey.isPressed())
//                if(caps[KeyEvent.VK_SHIFT])
//                    sb.append(key.toUpperCase());
//                else
//                    sb.append(key.toLowerCase());
//        }
//        return sb.toString();
//    }
//
//    private static String getKeyText(int keyCode, boolean shifted) {
//        String key = KeyEvent.getKeyText(keyCode);
//        if (key.length() != 1) {
//            key = "{" + key + "}";
//        }
//
//        switch (keyCode) {
//            case KeyEvent.VK_SHIFT:
//                key = "";
//                break;
//            case KeyEvent.VK_SPACE:
//                key = " ";
//                break;
//            case KeyEvent.VK_1:
//                key = shifted == true ? "!" : "1";
//                break;
//            case KeyEvent.VK_2:
//                key = shifted == true ? "@" : "2";
//                break;
//            case KeyEvent.VK_3:
//                key = shifted == true ? "#" : "3";
//                break;
//            case KeyEvent.VK_4:
//                key = shifted == true ? "$" : "4";
//                break;
//            case KeyEvent.VK_5:
//                key = shifted == true ? "%" : "5";
//                break;
//            case KeyEvent.VK_6:
//                key = shifted == true ? "^" : "6";
//                break;
//            case KeyEvent.VK_7:
//                key = shifted == true ? "&" : "7";
//                break;
//            case KeyEvent.VK_8:
//                key = shifted == true ? "*" : "8";
//                break;
//            case KeyEvent.VK_9:
//                key = shifted == true ? "(" : "9";
//                break;
//            case KeyEvent.VK_0:
//                key = shifted == true ? ")" : "0";
//                break;
//            case KeyEvent.VK_DEAD_ACUTE:
//                key = shifted == true ? "?" : "/";
//                break;
//            case KeyEvent.VK_PERIOD:
//                key = shifted == true ? "<" : ",";
//                break;
//            case KeyEvent.VK_COMMA:
//                key = shifted == true ? ">" : ".";
//                break;
//            case KeyEvent.VK_QUOTE:
//                key = shifted == true ? "'" : "\"";
//                break;
//            case KeyEvent.VK_SEMICOLON:
//                key = shifted == true ? ":" : ";";
//                break;
//        }
//        return key;
//    }
//    
//}
