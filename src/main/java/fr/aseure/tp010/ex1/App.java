package fr.aseure.tp010.ex1;

public class App {
    private static int depth = 0;

    public static void main(String[] args) {
        try {
            int res = factorial(10);
            System.out.println(res);
        } catch (StackOverflowError e) {
            System.out.printf("Stack depth was %d\n", depth);
        }
    }

    public static int factorial(int n) {
        depth++;
        return n * factorial(n - 1);
    }
}