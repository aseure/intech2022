package fr.aseure.tp006;

abstract class Message implements Displayable {
    protected String receiver;
    protected String content;

    protected Message(String receiver, String content) {
        this.receiver = receiver;
        this.content = content;
    }
}