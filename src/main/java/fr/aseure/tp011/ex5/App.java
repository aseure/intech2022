package fr.aseure.tp011.ex5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Object> objs = new ArrayList<>();
        List<Number> nums = new ArrayList<>();
        List<Integer> ints = Arrays.asList(1, 2, 3);

        addTo(objs, ints);
        addTo(nums, ints);

        System.out.println(objs);
        System.out.println(nums);
        System.out.println(ints);
    }

    // Answer 1
    //
    // At first, with the following function, the code does not compile on
    // addTo(objs, ints) because objs has a List<Object> while the function
    // expects a List<Number>. Even though Object is a parent class of Number,
    // it is not the case for List<Object> and List<Number>. Again, Java
    // generics are invariant!

//    public static void addTo(List<Number> container, List<Integer> ints) {
//        for (Integer i : ints) {
//            container.add(i);
//        }
//    }

    // Answer 2
    //
    // Now, with the following function, the code does not compile on
    // addTo(nums, ints) because nums is a List<Number> while the function
    // expects a List<Object>. Even though Object is a parent class of Number,
    // it is not the case for List<Object> and List<Number>. Again, Java
    // generics are invariant! Same reason as before.

//    public static void addTo(List<Object> container, List<Integer> ints) {
//        for (Integer i : ints) {
//            container.add(i);
//        }
//    }

    // Answer 3
    //
    // Using the lower bounded wildcard ? super Integer, the code now compiles
    // because we tell the Java compiler that the function accepts any List
    // whose generic type is Integer or one of its base classes.

    public static void addTo(List<? super Integer> container, List<Integer> ints) {
        for (Integer i : ints) {
            container.add(i);
        }
    }
}