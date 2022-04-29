package fr.aseure.tp009.ex1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class AppWithPropagation {
    public static void main(String[] args) throws IOException {
        System.out.println(countLinesInFile("myFile.txt"));
    }

    public static int countLinesInFile(String filename) throws IOException {
        Path path = Path.of("myFile.txt");
        List<String> lines = Files.readAllLines(path);
        return lines.size();
    }
}