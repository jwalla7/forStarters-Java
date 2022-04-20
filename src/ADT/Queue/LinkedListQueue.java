package ADT.Queue;

import java.util.LinkedList;
import java.util.Queue;

public class LinkedListQueue {
    public static void main(String[] args) {
//        Initiate Queue
        Queue<String> stack = new LinkedList<>();
//        Add Queues to Stack
        stack.add("Jeremiah");
        stack.add("Jamal");
        stack.add("James");
        stack.add("Jabari");
//        Print Queues - FIFO (first in, first out)
        for (String queue : stack) {
            System.out.println(queue);
        }
    }
}
