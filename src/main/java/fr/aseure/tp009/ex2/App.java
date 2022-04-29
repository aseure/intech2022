package fr.aseure.tp009.ex2;

import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {
        var numbers = Arrays.asList(1, 2, 3);
        System.out.println(average(numbers));

        numbers = null;
        System.out.println(average(numbers));
    }

    public static float average(List<Integer> numbers) {
        try {
            var sum = numbers.stream().reduce(0, Integer::sum);
            var size = numbers.size();
            return (float) sum / (float) size;
        } catch (NullPointerException e) {
            System.out.println(e);
            return 0;
        }
    }


}