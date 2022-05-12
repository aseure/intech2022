package fr.aseure.tp011.ex1;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {

        // Answer 1
        //
        // Does not compile because of the words.get() which returns Object
        // and the plus operator doesn't work with Object.

        {
            List words = new ArrayList();
            words.add("Hello ");
            words.add("world!");
//            String s = words.get(0) + words.get(1);
//            System.out.println(s);
        }

        // Answer 2
        //
        // Does compile thanks to the manual conversion (downcasting) from
        // Object to String.

        {
            List words = new ArrayList();
            words.add("Hello ");
            words.add("world!");
            String s = (String) words.get(0) + (String) words.get(1);
            System.out.println(s);
        }

        // Answer 3
        //
        // Does work because the words list only contains instances of Object,
        // so we are not limited to store String instances.

        {
            List words = new ArrayList();
            words.add("Hello ");
            words.add("world!");
            words.add(42);
            String s = (String) words.get(0) + (String) words.get(1);
            System.out.println(s);
        }

        // Answer 4
        //
        // This will correctly compile but will throw the following exception
        // at runtime because the downcasting from Object to String is not
        // possible since the dynamic type of the 3rd value actually is an
        // Integer.
        //
        //   ClassCastException: class java.lang.Integer cannot be cast to
        //                       class java.lang.String

        {
            List words = new ArrayList();
            words.add("Hello ");
            words.add("world!");
            words.add(42);
//            String s = (String) words.get(0) + (String) words.get(2);
//            System.out.println(s);
        }

        // Answer 5
        //
        // After making the code generic (we say "generifying it"), the code
        // now compiles, because the words.get() calls now directly return
        // instances of String instead of Object, thanks to the generic type.

        {
            List<String> words = new ArrayList<String>();
            words.add("Hello ");
            words.add("world!");
            String s = words.get(0) + words.get(1);
            System.out.println(s);
        }

        // Answer 6
        //
        // This time, Java will not let us compile, again, thanks to the
        // generic String type which ensures we only store String instances
        // within our list.

        {
            List<String> words = new ArrayList<String>();
            words.add("Hello ");
            words.add("world!");
//            words.add(42);
            String s = words.get(0) + words.get(1);
            System.out.println(s);
        }
    }
}