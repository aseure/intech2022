package fr.aseure.tp011.ex6;

import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Integer> ints = Arrays.asList(1, 2, 3);
        List<Double> dbls = Arrays.asList(4.0, 5.0, 6.0);

        // Answer 1
        //
        // No issue at compiling the code at first, because the two methods
        // have different names so there's no overloading involved.

        System.out.println(countIntegers(ints));
        System.out.println(countDoubles(dbls));

        // Answer 2
        //
        // The following code cannot compile. Because of type erasure, the two
        // functions are actually typed as `int count(List)`, hence from the
        // point of view of the compiler, only one function exists, which is
        // why it is failing to compile.

        // System.out.println(count(ints));
        // System.out.println(count(dbls));
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

//    public static int count(List<Integer> ints) {
//        int count = 0;
//        for (Integer i : ints) {
//            count++;
//        }
//        return count;
//    }
//
//    public static int count(List<Double> dbls) {
//        int count = 0;
//        for (Double d : dbls) {
//            count++;
//        }
//        return count;
//    }
}