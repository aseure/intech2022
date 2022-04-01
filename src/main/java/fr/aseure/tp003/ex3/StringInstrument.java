package fr.aseure.tp003.ex3;

public class StringInstrument extends Instrument {
    @Override
    public void play() {
        System.out.println("StringInstrument");
    }

    public void parent() {
        // Will display "StringInstrument" because the .getClass() method
        // is subject to virtual dispatch, and will be called on the dynamic
        // type of the instance, which is StringInstrument i.e. the current
        // class.
        System.out.println(super.getClass());
    }
}