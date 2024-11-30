package Homework_from_28_11_2024;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTask {
    public static void main(String[] args) {
        Queue<String> clientsQueue = new LinkedList<>();
        clientsQueue.add("Клиент 1");
        clientsQueue.add("Клиент 2");
        clientsQueue.add("Клиент 3");
        clientsQueue.add("Клиент 4");
        
        clientsQueue.poll();
        clientsQueue.poll();
        
       System.out.println(clientsQueue);
    }
}

