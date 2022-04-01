package fr.aseure.tp004;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class SRP {
    public static void main(String[] args) throws IOException, InterruptedException {
        String url = "https://en.wikipedia.org/wiki/Recursion_(computer_science)";

        var downloader = new Downloader();
        var body = downloader.downloadPage(url);
        var doc = new Document(body);

        var processors = Arrays.asList(
                new CountOccurence("recursion"),
                new MaxLineLength()
        );
        process(doc, processors);

        for (Processor p : processors) {
            p.report();
        }
    }

    static void process(Document doc, List<Processor> processors) {
        for (String line : doc.splitByLine()) {
            for (Processor p : processors) {
                p.processLine(line);
            }
        }
    }
}