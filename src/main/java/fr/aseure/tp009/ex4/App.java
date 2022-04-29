package fr.aseure.tp009.ex4;

public class App {
    public static void main(String[] args) throws Exception {
        theAnswer();
    }

    // Question 1
    //
    // Throws the `finally` exception which shadows all other exceptions.

    public static void theAnswer() throws Exception {
        try {
            throw new Exception("from the try");
        } catch (Exception e) {
            throw new Exception("from the catch");
        } finally {
            throw new Exception("from the finally");
        }
    }

    // Question 2
    //
    // Does not compile because the return is rightfully considered
    // unreachable by the compiler. This is due to the  `finally`
    // exception which is shadowing the return statement.

    // public static int theAnswer() throws Exception {
    //     try {
    //         throw new Exception("from the try");
    //     } catch (Exception e) {
    //         throw new Exception("from the catch");
    //     } finally {
    //         throw new Exception("from the finally");
    //     }
    //
    //     return 42;
    // }

    // Question 3
    //
    // The finally statement correctly returns the integer value, which, once
    // again, completely shadows the thrown exceptions from the try and catch
    // statements.

    // public static int theAnswer() throws Exception {
    //     try {
    //         throw new Exception("from the try");
    //     } catch (Exception e) {
    //         throw new Exception("from the catch");
    //     } finally {
    //         return 42;
    //     }
    // }

    // Question 4
    //
    // Throws the `finally` exception which shadows all other exceptions and
    // any other return statement.

    // public static int theAnswer() throws Exception {
    //     try {
    //         throw new Exception("from the try");
    //     } catch (Exception e) {
    //         return 42;
    //     } finally {
    //         throw new Exception("from the finally");
    //     }
    // }
}