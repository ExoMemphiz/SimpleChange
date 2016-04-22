/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author pelo
 */
public class FileHandler {

    public FileHandler() {
    }
    
    public static ArrayList<String> readFromFile (String path) {
        File f = new File(path);
        ArrayList<String> readList = new ArrayList();
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String newline = "";
            br.readLine();
            while ( (newline = br.readLine()) != null) {
                readList.add( newline );
            }
            br.close();
        } catch (IOException ioe) {
            System.out.println( ioe.getMessage() );
        }        
        
        return readList;
    }
    
    public static void writeFile (String path, ArrayList<String> writeList) {
        File f = new File(path);
        try {
            FileWriter fw = new FileWriter( f.getName() );
            BufferedWriter bw = new BufferedWriter(fw);
            for (String string : writeList) {
                bw.write(string);
                bw.newLine();
            }
            bw.close();
        } catch (IOException ioe) {
            System.out.println( ioe.getMessage() );
        }
    }
      

}