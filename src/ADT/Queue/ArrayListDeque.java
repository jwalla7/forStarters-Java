package ADT.Queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class ArrayListDeque {
//    Inner Class
    private static class Queue {
        static int[] arr;
        static int size;
        static int rear;

//    Constructor
        Queue(int size) {
            this.size = size;
            arr = new int[size];
            rear = -1;
        }

//    Methods
//      isEmpty
        public static boolean isEmpty () {
            return rear == -1;
        }
//      isFull
        public static boolean isFull() {
            return rear == size - 1;
        }

//      Add To Back
        public static void enqueue (int data) {
            if (isFull()) {
                System.out.println("Full Queue");
                return;
            }
            rear++;
            arr[rear] = data;
        }
//      Remove from Front
        public static int dequeue () {
                if (isEmpty()) {
                    System.out.println("Empty Queue");
                    return -1;
                }
                int front = arr[0];
                for (int i = 0; i < rear; i++) {
                    arr[i] = arr[i + 1];
                }
                rear--;
                return front;
        }
//      Peek At Front
        public static int peek () {
                if (isEmpty()) {
                    System.out.println("Empty Queue");
                    return -1;
                }
                return arr[0];

        }
//     Display Queue
        public void display () {
            for (int i = 0; i < size; i++) {
                System.out.print(arr[i] + " <- ");
            }
            System.out.println("Tail");
            System.out.println(" ");
        }
    }

//  Main Method
    public static void main(String[] args) {
//        Create Queue
        Queue queue = new Queue(4);
        Deque deque = new ArrayDeque();

//        Add To Back
        queue.enqueue(1);
        queue.display();
        queue.enqueue(2);
        queue.display();
        queue.enqueue(3);
        queue.display();

//        Remove from Front
        while (!queue.isEmpty()) {
            System.out.println("  <-Removed: " + queue.peek());
            queue.dequeue();

            queue.display();

        }
    }
}
