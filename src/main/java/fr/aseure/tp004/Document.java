package fr.aseure.tp004;

import java.util.Arrays;
import java.util.List;

class Document {
    private final String content;

    public Document(String content) {
        this.content = content;
    }

    public List<String> splitByLine() {
        return Arrays.asList(content.split("\n"));
    }
}