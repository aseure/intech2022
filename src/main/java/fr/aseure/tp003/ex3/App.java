package fr.aseure.tp003.ex3;

public class App {
    public static void main(String[] args) {
        Instrument i = new Instrument();
        StringInstrument si = new StringInstrument();
        Piano p = new Piano();

        System.out.println("Display the classes");
        System.out.println(i.getClass());
        System.out.println(si.getClass());
        System.out.println(p.getClass());

        System.out.println("Display the parent classes");
        System.out.println(i.getClass().getSuperclass());
        System.out.println(si.getClass().getSuperclass());
        System.out.println(p.getClass().getSuperclass());

        System.out.println("Invoke the .parent() methods");
        p.parent();
        i.parent();
        si.parent();

    }
}