package fr.aseure.tp012;

import java.util.Base64;

// The Jar file was produced and tested with the following steps:
//
//   mvn clean compile
//   jar cvf surprise.jar -C target/classes fr/aseure/tp012/Surprise.class

public class Surprise {
    private final int firstStepSecretKey;
    private final Base64.Encoder secondStepEncoder;
    private final String superSecretMessage;

    public Surprise() {
        this.firstStepSecretKey = 1;
        this.secondStepEncoder = Base64.getEncoder();
        var firstStep = firstStepEncode("The cake is a lie", this.firstStepSecretKey);
        var secondStep = this.secondStepEncoder.encodeToString(firstStep.getBytes());
        this.superSecretMessage = secondStep;
    }

    private static String firstStepEncode(String message, int key) {
        var decoded = message.toCharArray();
        var encoded = new char[decoded.length];
        for (int i = 0; i < decoded.length; i++) {
            encoded[i] = (char) (decoded[i] + key);
        }
        return new String(encoded);
    }

    private static String firstStepDecode(String message, int key) {
        return firstStepEncode(message, -key);
    }

}