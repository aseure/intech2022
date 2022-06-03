package fr.aseure.tp014.ex1;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class SortedListHandler implements HttpHandler {
    private final SortedList sortedList;

    public SortedListHandler() {
        this.sortedList = new SortedList();
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        try (var is = exchange.getRequestBody();
             var os = exchange.getResponseBody()) {

            var body = readBody(is);

            var response = switch (exchange.getRequestMethod()) {
                case "GET" -> {
                    var res = this.sortedList.snapshot()
                            .stream()
                            .map(Objects::toString)
                            .collect(Collectors.joining(","));
                    yield "[" + res + "]";
                }
                case "PUT" -> {
                    var values = parseIntegers(body);
                    this.sortedList.add(values);
                    yield values.toString();
                }
                case "DELETE" -> {
                    var values = parseIntegers(body);
                    this.sortedList.remove(values);
                    yield values.toString();
                }
                default -> "[]";
            };

            exchange.sendResponseHeaders(200, response.length());
            os.write(response.getBytes());
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    private static String readBody(InputStream is) throws IOException {
        try (var inputStreamReader = new InputStreamReader(is);
             var bufferedReader = new BufferedReader(inputStreamReader)) {
            return bufferedReader
                    .lines()
                    .collect(Collectors.joining("\n"));
        }
    }

    private static List<Long> parseIntegers(String body) {
        try {
            return Arrays
                    .stream(body.split(","))
                    .map(Long::valueOf)
                    .toList();
        } catch (Exception ex) {
            System.out.println("Cannot parse integers: " + ex);
            return new ArrayList<>();
        }
    }
}
