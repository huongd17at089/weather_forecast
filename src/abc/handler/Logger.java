/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abc.handler;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author Huong
 */
public class Logger {
    private final String FILE_PATH = "log.txt";
    private final int MAX_SIZE = 20;
    private File file;
    private PrintWriter writer;

    public Logger() throws IOException {
        file = new File(FILE_PATH);
    }

    public void writeLog(ArrayList<String> buffer) throws IOException{
       
        writer = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
        String str = String.join(", ", buffer) + ", ";
        writer.println(str);
        writer.close();
    }

    public String getFilePath() {
        return FILE_PATH;
    }
    
    public boolean isFullLog(){
//        System.out.println(file.length() + "?" + MAX_SIZE);
        return file.length() >= MAX_SIZE;
    }
    
    public void removeLog(){
        file.delete();
    }
    
}

