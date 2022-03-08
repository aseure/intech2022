package fr.aseure.tp002.ex1;

public class App {
    public static void main(String[] args) {
        System.out.println(ClassLoader.getSystemClassLoader());
        System.out.println(ClassLoader.getSystemClassLoader().getParent());
        System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());
        // At this point, calling one more time .getParent() will result in a
        // `NullPointerException` getting thrown because the
        // `BootstrapClassLoader` is represented as `null` in Java.

        System.out.println();
        System.out.println(ClassLoader.getPlatformClassLoader());
        System.out.println(ClassLoader.getPlatformClassLoader().getParent());
        // ... same thing here

        System.out.println();
        System.out.println(App.class.getClassLoader());
        System.out.println(App.class.getClassLoader().getParent());
        System.out.println(App.class.getClassLoader().getParent().getParent());
        // ... same thing here
    }
}