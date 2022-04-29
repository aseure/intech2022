package fr.aseure.tp009.ex1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

public class AppWithTryCatch {
    public static void main(String[] args) {
        System.out.println(countLinesInFile("myFile.txt"));
    }

    public static int countLinesInFile(String filename) {
        Path path = Path.of("myFile.txt");
        List<String> lines;
        try {
            lines = Files.readAllLines(path);
        } catch (IOException e) {
            System.out.println(e);
            lines = Collections.emptyList();
        }
        return lines.size();
    }
}