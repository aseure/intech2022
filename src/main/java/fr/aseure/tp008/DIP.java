package fr.aseure.tp008;

import fr.aseure.tp008.dictionary.EnglishDictionary;
import fr.aseure.tp008.dictionary.FrenchDictionary;


public class DIP {
    public static void main(String[] args) {
        var enToFr = new Translator<>(
                new EnglishDictionary(),
                new FrenchDictionary()
        );
        System.out.println(enToFr.translate("two"));
        System.out.println(enToFr.translate("four"));

        var frToEn = new Translator<>(
                new FrenchDictionary(),
                new EnglishDictionary()
        );
        System.out.println(frToEn.translate("trois"));
        System.out.println(frToEn.translate("cinq"));
    }
}