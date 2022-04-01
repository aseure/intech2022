package fr.aseure.tp008.dictionary;

import fr.aseure.tp008.io.Reader;
import fr.aseure.tp008.io.Speaker;

import java.util.Map;
import java.util.stream.Collectors;

abstract class Dictionary implements Reader, Speaker {
    protected Map<String, Integer> wordToInt;
    protected Map<Integer, String> intToWord;

    protected Dictionary(Map<String, Integer> wordToInt) {
        this.wordToInt = wordToInt;
        this.intToWord = wordToInt
                .entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey));
    }

    @Override
    public int read(String number) {
        return wordToInt.getOrDefault(number, 0);
    }

    @Override
    public String speak(int number) {
        return intToWord.getOrDefault(number, intToWord.get(0));
    }
}