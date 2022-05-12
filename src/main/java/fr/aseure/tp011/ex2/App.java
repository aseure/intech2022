package fr.aseure.tp011.ex2;

public class App {
    public static void main(String[] args) {
        // Answer 1
        //
        // The 3rd assignment prevents the compilation because we cannot store
        // a double value within an Integer array.

        // Answer 2
        //
        // Now if we execute the code, the 4th assignment generates an
        // following exception at runtime, because the compiler does not prevent us from
        // adding a double value to an Number array, but at runtime, we see
        // that it is not possible, since the underlying dynamic type is an
        // array of Integer.
        //
        //   java.lang.ArrayStoreException: java.lang.Double

        {
            Integer[] ints = new Integer[10];
            Number[] nums = ints;

            ints[0] = 42;
            nums[1] = 43;
//            ints[2] = 44.0;
            nums[3] = 45.0;
        }

        // Answer 3
        //
        // The code does not compile since the downcasting, from Integer to
        // Number is not possible, as opposed to the previous upcasting, from
        // Number to Integer, that we did.

        {
            Number[] nums = new Number[10];
//            Integer[] ints = nums;
        }
    }
}