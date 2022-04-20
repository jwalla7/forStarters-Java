package ADT.Queue;

import java.util.LinkedList;
import java.util.Queue;

public class PriorityQueue {
    public static void main(String[] args) {
//        Initiate Queues
        Queue<Integer> stackInt = new LinkedList<>();
        Queue<String> stackStr = new LinkedList<>();
//        Add Queues to Stack
        stackInt.add(1);
        stackInt.add(2);
        stackInt.add(3);
        stackInt.add(4);

        stackStr.add("Jeremiah");
        stackStr.add("Jamal");
        stackStr.add("James");
        stackStr.add("Jabari");

//        Print Queues - FIFO (first in, first out)
        for (int queue : stackInt) {
            System.out.println(queue);
        }
        for (String queue : stackStr ) {
            System.out.println(queue);
        }
//        Print Priority Queue -
        processAlphabetically(stackStr);
    }

    public static void processAlphabetically(Queue<String> queue) {
//        Initiate Priority Queue
        Queue<String> alphabeticalQueue = new java.util.PriorityQueue<>();

        for (String name : alphabeticalQueue) {
            alphabeticalQueue.offer(name);
        }

        while (alphabeticalQueue.peek() != null) {
            String headElement = alphabeticalQueue.remove();
            System.out.println("Processing: " + headElement);
        }
    }
}
