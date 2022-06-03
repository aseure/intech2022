package fr.aseure.tp013.ex3;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

public class App {
    public static void main(String[] args) {
        var nbThreads = 100;
        var nbTasks = 100;
        var ex = Executors.newFixedThreadPool(nbThreads);

        // Answer 1
        //
        // Each task will take 1s to complete, but since each of them is
        // scheduled on a different threads, there will be some context switch
        // between them so that the CPU can make them all move forward with
        // their execution as they are all "waiting" and not performing any
        // computation. So the total number of time we wait is around 1s as
        // well, and not 100s.

        // Answer 2
        //
        // When we divide the number of threads by 2 in our fixed thread pool,
        // the time it takes to run all the threads is multiplied by 2 and takes
        // about 2s. This is because the thread pool has to schedule all the
        // tasks on a limited number of fixed thread pool available.

        // Answer 3
        //
        // When we double the number of threads by 2 in our fixed thread pool,
        // the time it takes to run all the threads is going back down to 1s.
        // This is because we have more available threads than tasks to perform,
        // so all tasks complete without interfering with each other.

        Supplier<Boolean> task = () -> {
            try {
                Thread.sleep(1_000);
                return true;
            } catch (InterruptedException e) {
                return false;
            }
        };

        Instant start = Instant.now();

        var futures = new ArrayList<CompletableFuture<Boolean>>();
        for (int i = 0; i < nbTasks; i++) {
            futures.add(CompletableFuture.supplyAsync(task, ex));
        }

        var countSuccesses = futures
                .stream()
                .map(CompletableFuture::join)
                .map((succeeded) -> succeeded ? 1 : 0)
                .reduce(Integer::sum)
                .orElse(0);

        Instant end = Instant.now();
        Duration took = Duration.between(start, end);

        System.out.printf("nbThreads = %d\n", nbThreads);
        System.out.printf("nbTasks = %d\n", nbTasks);
        System.out.printf("countSuccesses = %d\n", countSuccesses);
        System.out.printf("took = %s\n", took);

        ex.shutdown();
    }
}