package fr.aseure.tp008.dictionary;

import java.util.Map;

public class FrenchDictionary extends Dictionary {
    public FrenchDictionary() {
        super(Map.of(
                "zéro", 0,
                "un", 1,
                "deux", 2,
                "trois", 3,
                "quatre", 4,
                "cinq", 5,
                "six", 6,
                "sept", 7,
                "huit", 8,
                "neuf", 9
        ));
    }
}