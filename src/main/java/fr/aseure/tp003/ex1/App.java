package fr.aseure.tp003.ex1;

import fr.aseure.tp003.ex1.subpackage.SubChild;

class App {
    public static void main(String[] args) {
        Parent p = new Parent();
        p.one();
        p.two();
        // Does not compile because it's private
        // p.three();
        p.four();

        Child c = new Child();
        c.one();
        c.two();
        // Does not compile because it's private
        // c.three();
        c.four();

        SubChild sc = new SubChild();
        sc.one();
        sc.two();
        // Does not compile because it's private
        // sc.three();
        // Does not compile because it's package-private (default, no modifier)
        // sc.four();
    }
}