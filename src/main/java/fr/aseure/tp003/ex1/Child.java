package fr.aseure.tp003.ex1;

public class Child extends Parent {
    public void one() {
        System.out.println("Child.one");
    }

    protected void two() {
        System.out.println("Child.two");
    }

    private void three() {
        System.out.println("Child.three");
    }

    void four() {
        System.out.println("Child.four");
    }
}