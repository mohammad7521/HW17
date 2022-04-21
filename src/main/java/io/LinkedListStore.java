package io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class LinkedListStore {

    //reading a txt file line by line and storing it in a linked list and
    //then reading it backwards

    public static void main(String args[]){

        String strLine = "";
        LinkedList<String> list = new LinkedList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\MMD\\IdeaProjects\\HW17\\src\\main\\java\\io\\textReader\\List.txt"));
            while (strLine != null)
            {
                strLine = br.readLine();
                if (strLine==null)
                    break;
                list.add(strLine);

            }

            for (int i=list.size()-1;i>=0;i--){
                System.out.println(list.get(i));
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        } catch (IOException e) {
            System.err.println("Unable to read the file.");
        }
    }
}
