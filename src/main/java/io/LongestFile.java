package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LongestFile {
    //finding the longest word in a txt file

    public static void main(String[] args) {

        File file=new File("C:\\Users\\MMD\\IdeaProjects\\HW17\\src\\main\\java\\io\\textReader\\List.txt");

        try {
            Scanner scanner=new Scanner(file);
            String longest="";
            String word;

            while (scanner.hasNext()){
                word=scanner.next();
                if (word.length()>longest.length()){
                    longest=word;
                }
            }

            System.out.println("the longest word in "+file.getName()+" is "+longest);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
