package fr.aseure.tp003.ex3;

public class Piano extends StringInstrument {
    @Override
    public void play() {
        System.out.println("Piano");
    }

    public void parent() {
        // Will display StringInstrument, as expected.
        System.out.println(this.getClass().getSuperclass());
        System.out.println(StringInstrument.class);
    }
}