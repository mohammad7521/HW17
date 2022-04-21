package io;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadAndStore {

    //reading the content of txt file and storing it into a variable

    public static void main(String[] args) {
        try {
            DataInputStream dts=new DataInputStream(new FileInputStream("C:\\Users\\MMD\\IdeaProjects\\HW17\\src\\main\\java\\io\\textReader\\List.txt"));
            byte[]fileBytes=new byte[dts.available()];
            dts.readFully(fileBytes);
            dts.close();

            String txt=new String(fileBytes,0,fileBytes.length);
            System.out.println(txt);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
