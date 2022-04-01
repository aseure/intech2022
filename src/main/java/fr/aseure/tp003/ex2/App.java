package fr.aseure.tp003.ex2;

public class App {
    public static void main(String[] args) {
        System.out.println("Todo #1");
        Instrument i1 = new Instrument();
        i1.play();

        StringInstrument si1 = new StringInstrument();
        si1.play();

        Piano p1 = new Piano();
        p1.play();

        System.out.println("Todo #2");
        Instrument i2 = new Instrument();
        i2.play();

        Instrument si2 = new StringInstrument();
        si2.play();

        Instrument p2 = new Piano();
        p2.play();

        System.out.println("Todo #3");
        // Does not compile because we cannot downcast
        // StringInstrument i3 = new Instrument();
        // i3.play();

        StringInstrument si3 = new StringInstrument();
        si3.play();

        StringInstrument p3 = new Piano();
        p3.play();

        System.out.println("Todo #4");
        // Does not compile because we cannot downcast
        // Piano i4 = new Instrument();
        // i4.play();

        // Does not compile because we cannot downcast
        // Piano is4 = new StringInstrument();
        // is4.play();

        Piano p4 = new Piano();
        p4.play();
    }
}