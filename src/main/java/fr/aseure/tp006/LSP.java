package fr.aseure.tp006;

import java.util.Arrays;
import java.util.List;

public class LSP {
    public static void main(String[] args) {
        List<Message> messages = Arrays.asList(
                new AuthoredMessage("Steve Wozniak", "Steve Jobs", "Get the JACK back!"),
                new AnonymousMessage("Steve Jobs", "Get the JACK back!")
        );

        sendMessages(messages);
    }

    static void sendMessages(List<Message> list) {
        list.forEach(Displayable::display);
    }
}