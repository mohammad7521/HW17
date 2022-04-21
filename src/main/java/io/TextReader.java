package io;

import java.io.*;

public class TextReader {


    //reading the content of a txt file using bufferedReader.
    public static void main(String[] args) {
        File file = new File("C:\\Users\\MMD\\IdeaProjects\\HW17\\src\\main\\java\\io\\textReader\\List.txt");

        BufferedReader bufferedReader;

        {
            try {
                bufferedReader = new BufferedReader(new FileReader(file));
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
