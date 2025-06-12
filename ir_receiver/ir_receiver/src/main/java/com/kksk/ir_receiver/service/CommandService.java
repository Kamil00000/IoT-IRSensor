package com.kksk.ir_receiver.service;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

@Service
public class CommandService {

    // Mapa klient → kolejka komend
    private final Map<String, Queue<String>> clientCommands = new ConcurrentHashMap<>();

    // Dodaje komendę do kolejki klienta
    public void addCommand(String clientId, String command) {
        clientCommands.computeIfAbsent(clientId, k -> new ConcurrentLinkedQueue<>()).add(command);
    }

    // Pobiera i usuwa pierwszą komendę z kolejki klienta
    public String getNextCommand(String clientId) {
        Queue<String> queue = clientCommands.get(clientId);
        if (queue == null || queue.isEmpty()) {
            return "none";
        }
        return queue.poll(); // usuwa i zwraca
    }
}
