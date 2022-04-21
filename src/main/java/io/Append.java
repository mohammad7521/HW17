package io;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Append {

    //appending a text to end of a txt file
    public static void main(String[] args) {

        File file = new File("C:\\Users\\MMD\\IdeaProjects\\HW17\\src\\main\\java\\io\\textReader\\List.txt");

        FileWriter fileWriter;
        Scanner scanner;
        {
            try {
                fileWriter = new FileWriter(file, true);
                System.out.println("what do you want to add to the file?");
                scanner = new Scanner(System.in);
                fileWriter.write(scanner.next());
                fileWriter.close();
                System.out.println("done");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
