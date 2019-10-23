package kasia.simple.chat;

import kasia.simple.chat.data.Message;
import kasia.simple.chat.util.InputProvider;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Client {
    private final String name;
    private Server server;
    private final PrintStream outputStream;
    private InputProvider inputProvider;

    private final List<Message> messagesBuffer = new ArrayList<>();

    public Client(String name, Server server, PrintStream outputStream, InputProvider inputProvider) {
        this.name = name;
        this.server = server;
        this.outputStream = outputStream;
        this.inputProvider = inputProvider;
    }

    public void acceptMessage(Message message) {
        messagesBuffer.add(message);
    }

    private void printAllMessagesFromBuffer() {
        for (Message message : messagesBuffer) {
            outputStream.println(message.getAuthor() + ": " + message.getData());
        }
        messagesBuffer.clear();
    }

    public void start() {
        server.register(this);
        printAllMessagesFromBuffer();

        try {
            while (true) {
                String line = inputProvider.readLine();
                server.acceptMessage(new Message(name, line));
                printAllMessagesFromBuffer();
            }
        } finally {
            server.unregister(this);
        }

    }

    public static void main(String[] args) {


    }
}
