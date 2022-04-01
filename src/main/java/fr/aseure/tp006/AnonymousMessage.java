package fr.aseure.tp006;

class AnonymousMessage extends Message {
    AnonymousMessage(String receiver, String content) {
        super(receiver, content);
    }

    @Override
    public void display() {
        System.out.printf("Sending anonymous message to %s: %s\n", receiver, content);
    }
}