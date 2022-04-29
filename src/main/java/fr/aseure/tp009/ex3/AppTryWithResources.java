package fr.aseure.tp009.ex3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AppTryWithResources {
    public static void main(String[] args) {
        System.out.println(maxLength("myFile.txt"));
    }

    public static int maxLength(String filename) {
        File file = new File(filename);
        int max = 0;

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (max < line.length()) {
                    max = line.length();
                }
            }
        } catch (FileNotFoundException e) {
            System.out.printf("File %s cannot be found\n", filename);
        }

        return max;
    }
}