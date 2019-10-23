package kasia.simple.chat.data;

public class Message {
    private final String author;
    private final String data;

    public Message(String author, String data) {
        this.author = author;
        this.data = data;
    }

    public String getAuthor() {
        return author;
    }

    public String getData() {
        return data;
    }
}
