package kasia.simple.chat;

import kasia.simple.chat.data.Message;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Server {
    private final List<Message> messages = new LinkedList<>();

    private final List<Client> clients = new ArrayList<>();

    public void register(Client client) {
        clients.add(client);
        for (Message message : messages) {
            client.acceptMessage(message);
        }
    }

    public void unregister(Client client) {
        clients.remove(client);
    }

    public void acceptMessage(Message message) {
        messages.add(message);
        for (Client client : clients) {
            client.acceptMessage(message);
        }
    }

    public static void main(String[] args) {

    }
}
