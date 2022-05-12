package fr.aseure.tp011.ex4;

import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Integer> ints = Arrays.asList(1, 2, 3);
        System.out.println(countIntegers(ints));

        List<Double> dbls = Arrays.asList(4.0, 5.0, 6.0);
        System.out.println(countDoubles(dbls));

        // Answers 1, 2
        //
        // The two following calls do no compile because List<Integer> and
        // List<Double> are not subtypes of List<Number>, even though Integer
        // and Double are subtypes of Number. This is due to Java generics
        // being invariant.

        System.out.println(countNumbers(ints));
        System.out.println(countNumbers(dbls));

        // Answer 3
        //
        // Using the upper bounded wildcard ? extends Number, the code now
        // compiles because we tell the Java compiler that the function accepts
        // any List whose generic type is Number or one of its derived classes.
    }

    public static int countIntegers(List<Integer> ints) {
        int count = 0;
        for (Integer i : ints) {
            count++;
        }
        return count;
    }

    public static int countDoubles(List<Double> dbls) {
        int count = 0;
        for (Double d : dbls) {
            count++;
        }
        return count;
    }

    public static int countNumbers(List<? extends Number> nums) {
        int count = 0;
        for (Number n : nums) {
            count++;
        }
        return count;
    }
}