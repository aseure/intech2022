package fr.aseure.tp006;

class AuthoredMessage extends Message {
    private final String sender;

    AuthoredMessage(String sender, String receiver, String content) {
        super(receiver, content);
        this.sender = sender;
    }

    @Override
    public void display() {
        System.out.printf("Sending message from %s to %s: %s\n", sender, receiver, content);
    }
}