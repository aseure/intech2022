package fr.aseure.tp004;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

class Downloader {
    private static final HttpClient client = HttpClient.newHttpClient();

    String downloadPage(String url) throws IOException, InterruptedException {
        URI uri = URI.create(url);
        HttpRequest req = HttpRequest.newBuilder(uri).build();
        HttpResponse<String> res = client.send(req, HttpResponse.BodyHandlers.ofString());
        return res.body();
    }
}