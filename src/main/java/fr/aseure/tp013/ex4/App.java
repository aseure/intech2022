package fr.aseure.tp013.ex4;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

public class App {
    public static void main(String[] args) {
        // Answer 1
        //
        // With nbThreads=1 and nbTasks=1, we can see a 100% usage of our CPU.

        // Answer 2
        //
        // With nbThreads=8 and nbTasks=8, we can see a 800% usage of our CPU.

        // Answer 3
        //
        // With nbThreads=42 and nbTasks=42, we can see a 800% usage of our CPU
        // as well because the thread pool is always limited by the number of
        // physical cores of the machine.

        var nbThreads = 8;
        var nbTasks = 8;
        var ex = Executors.newFixedThreadPool(nbThreads);

        Supplier<Void> task = () -> {
            for (; ; ) {
            }
        };

        var futures = new ArrayList<CompletableFuture<Void>>();
        for (int i = 0; i < nbTasks; i++) {
            futures.add(CompletableFuture.supplyAsync(task, ex));
        }

        futures.stream().map(CompletableFuture::join);

        ex.shutdown();
    }
}