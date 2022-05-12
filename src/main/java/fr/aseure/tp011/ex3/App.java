package fr.aseure.tp011.ex3;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        upcast();
        downcast();
    }

    // Answers 1, 2, 3, 4
    //
    // Code does not compile because of:
    //
    //  - the nums assignment in the upcast() function
    //  - the ints assignment in the downcast() function
    //
    // This is due to the fact that it would be illegal to store anything else
    // than Integers in the ints instance in the upcast() function, so the
    // generic type prevents us from making this wrong conversion, as opposed
    // to arrays.
    //
    // In the downcast() function, things are a bit different: it would be
    // illegal to access anything else than an Integer from the ints list of
    // Integer, that's why the compiler prevents it, exactly like for arrays.
    //
    // This finally tells us that Java generics are invariant (neither
    // covariant nor contravariant).

    public static void upcast() {
        List<Integer> ints = new ArrayList<Integer>();
//        List<Number> nums = ints;
    }

    public static void downcast() {
        List<Number> nums = new ArrayList<Number>();
//        List<Integer> ints = nums;
    }
}