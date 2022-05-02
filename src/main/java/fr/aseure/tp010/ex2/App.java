package fr.aseure.tp010.ex2;

public class App {
    // Starting the following program with no specific configuration, it will
    // run just fine, and displays the length of the array (50000000).
    //
    // However, by configuring the java option -Xmx to -Xmx10m, which limits
    // the maximum size of the heap to 10MB, because the program won't be able
    // to instantiate a block of 50MB, the program will throw an unchecked and
    // unrecoverable exception: java.lang.OutOfMemoryError: Java heap space.
    public static void main(String[] args) {
        byte[] bytes = new byte[50_000_000];
        System.out.println(bytes.length);
    }
}