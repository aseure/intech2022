package fr.aseure.tp013.ex2;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) {

        // Answer 1
        //
        // The API of the CompletableFuture class is more modern and more
        // advanced than the one using the old Java Future class. Most of the
        // time, there is no reason to pick Future over CompletableFuture in
        // modern Java.

        var ex = Executors.newFixedThreadPool(2);
        var c = new Counter();

        Instant start = Instant.now();
        var f1 = CompletableFuture.supplyAsync(c, ex);
        var f2 = CompletableFuture.supplyAsync(c, ex);

        var results = Stream
                .of(f1, f2)
                .map(CompletableFuture::join)
                .collect(Collectors.toList());

        System.out.println(results);
        System.out.printf("Took %s\n", Duration.between(start, Instant.now()));

        ex.shutdown();
    }
}

class Counter implements Supplier<Integer> {
    private Integer counter;

    public Counter() {
        this.counter = 0;
    }

    synchronized void incr() {
        counter++;
    }

    @Override
    public Integer get() {
        for (int i = 0; i < 1000; i++) {
            incr();
        }
        return counter;
    }
}