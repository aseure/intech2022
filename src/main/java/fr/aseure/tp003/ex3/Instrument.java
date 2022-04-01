package fr.aseure.tp003.ex3;

public class Instrument {
    public void play() {
        System.out.println("Instrument");
    }

    public void parent() {
        // Will both display Object, which is the default super class of all
        // classes in Java.
        System.out.println(this.getClass().getSuperclass());
        System.out.println(Object.class);
    }
}