package fr.aseure.tp013.ex1;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class App {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // Answer 1
        //
        // The counter are properly incremented but their values will never,
        // expect by chance, be equal to 2000. The reason is that sometimes the
        // two threads are incrementing the same value and are simple overriding
        // each others' work.
        {
            ExecutorService ex = Executors.newFixedThreadPool(2);

            var c = new Counter();

            var start = Instant.now();
            var f1 = ex.submit(c);
            var f2 = ex.submit(c);

            System.out.printf("Future returned %d\n", f1.get());
            System.out.printf("Future returned %d\n", f2.get());
            System.out.printf("Took %s\n", Duration.between(start, Instant.now()));
            System.out.println();

            ex.shutdown();
        }

        // Answer 2
        //
        // If the number of fixed thread pool is set to 1 instead of 2, the
        // counter gets properly updated to 2000 because there will only be one
        // thread at a time executing.
        // Note that the completion of the second future is conditioned by the
        // completion of the first one.
        {
            ExecutorService ex = Executors.newFixedThreadPool(1);

            var c = new Counter();

            var start = Instant.now();
            var f1 = ex.submit(c);
            var f2 = ex.submit(c);

            System.out.printf("Future returned %d\n", f1.get());
            System.out.printf("Future returned %d\n", f2.get());
            System.out.printf("Took %s\n", Duration.between(start, Instant.now()));
            System.out.println();

            ex.shutdown();
        }

        // Answer 3
        //
        // Same as question 4, the counter gets incremented properly but the
        // intermediate value after the first future's completion is not likely
        // to be exactly 1000 because the two threads are incrementing
        // independently.
        {
            ExecutorService ex = Executors.newFixedThreadPool(2);

            var c = new CounterWithSynchronized();

            var start = Instant.now();
            var f1 = ex.submit(c);
            var f2 = ex.submit(c);

            System.out.printf("Future returned %d\n", f1.get());
            System.out.printf("Future returned %d\n", f2.get());
            System.out.printf("Took %s\n", Duration.between(start, Instant.now()));
            System.out.println();

            ex.shutdown();
        }

        // Answer 4
        //
        // Same as question 3.
        {
            ExecutorService ex = Executors.newFixedThreadPool(2);

            var c = new CounterWithLock();

            var start = Instant.now();
            var f1 = ex.submit(c);
            var f2 = ex.submit(c);

            System.out.printf("Future returned %d\n", f1.get());
            System.out.printf("Future returned %d\n", f2.get());
            System.out.printf("Took %s\n", Duration.between(start, Instant.now()));
            System.out.println();

            ex.shutdown();
        }
    }
}

class Counter implements Callable<Integer> {
    private Integer counter;

    public Counter() {
        this.counter = 0;
    }

    @Override
    public Integer call() {
        for (int i = 0; i < 1000; i++) {
            incr();
        }
        return counter;
    }

    void incr() {
        counter++;
    }
}

class CounterWithSynchronized implements Callable<Integer> {
    private Integer counter;

    public CounterWithSynchronized() {
        this.counter = 0;
    }

    @Override
    public Integer call() {
        for (int i = 0; i < 1000; i++) {
            incr();
        }
        return counter;
    }

    synchronized void incr() {
        counter++;
    }
}

class CounterWithLock implements Callable<Integer> {
    private ReentrantLock lock;
    private Integer counter;

    public CounterWithLock() {
        this.lock = new ReentrantLock();
        this.counter = 0;
    }

    @Override
    public Integer call() {
        for (int i = 0; i < 1000; i++) {
            incr();
        }
        return counter;
    }

    void incr() {
        lock.lock();
        counter++;
        lock.unlock();
    }
}