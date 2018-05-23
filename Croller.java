/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.impl;

import csci152.adt.Queue;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;

/**
 *
 * @author Адильбек
 */
public class Croller {

    public static void main(String[] args) throws Exception {
        Queue<String> q = new ArrayQueue();

        File myDir = new File("src");
        if (myDir.exists()) {
            File[] files = myDir.listFiles();

            for (File file : files) {
                if (file.isFile()) {
                    String str = file.getName();
                    if (str.endsWith(".txt")) {
                     {
                       q.enqueue(str);
                       System.out.println(q);
                    }
                } else {
                    return;
                }
            }
        }
        }

        File file1 = new File("file1");
        file1.createNewFile();
        File file2 = new File("file2");
        file2.createNewFile();

        PrintWriter pr;
            try (BufferedReader reader = new BufferedReader(new FileReader(file1))) {
                pr = new PrintWriter(new FileOutputStream(file2, true));
                int ch;
                do {
                    ch = reader.read();
                    pr.print((char)ch);
                    System.out.println(" " + (char) ch);
                    
                } while (ch != -1);
            }  
          pr.close();
        
       
       
        pr.close();
        BufferedReader read = new BufferedReader(new FileReader(file1));
       
        int cor;
        String token=" ";
        do{
            cor=read.read();
         if( cor == '' || cor=='\n'|| cor=='\r'|| cor=='\t' || cor == -1){
                if(token.length()>0){
                    System.out.println("token"+token);
                    token= " ";
                }
            } else{
             token=token+(char) cor;       
                    
             }
    }
    }
}



