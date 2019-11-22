package kasia.simple.chat;

import kasia.simple.chat.util.ConsoleInputProvider;
import kasia.simple.chat.util.ParrotInputProvider;

public class Main {
    public static void main(String[] args) {
        Server server = new Server();

        Client client1 = new Client("Jack Sparrow", server, System.out, new ConsoleInputProvider());
        Client client2 = new Client("Parrot", server, System.err, new ParrotInputProvider());



        new Thread(() -> {
            client1.start();
        }).start();

        client2.start();

    }
}
