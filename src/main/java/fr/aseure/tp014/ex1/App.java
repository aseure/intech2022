package fr.aseure.tp014.ex1;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class App {
    public static void main(String[] args) throws IOException {
        var server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/", new SortedListHandler());
        server.setExecutor(Executors.newSingleThreadExecutor());
        server.start();
    }
}