package Lists;


public class SinglyLinkedListT<T> {
//    Inner Class
    private static class Node<T> {
        private T element;
        private Node<T> next;
//      Constructors
        public Node(T e, Node<T> n) {
            element = e;
            next = n;
        }
//      Getters and Setters
        public T getElement() {
            return element;
        }
        public Node<T> getNext() {
            return next;
        }
        public void setNext(Node<T> n) {
            next = n;
        }
    }
//    Node
    private Node<T> head = null;
    private Node<T> tail = null;
    private int size = 0;
    //    Getters
//      isEmpty Edge Cass
    public int size() {
        return size;
    }
//    Methods
        public void SingleLinkedList() {}
    public boolean isEmpty() {
        return size == 0;
    }
//      Get First Element
    public T first() {
        if (isEmpty()) {
            return null;
        }
        return head.getElement();
    }
//      Get Last Element
    public T last() {
        if (isEmpty()) {
            return null;
        }
        return tail.getElement();
    }
//      Add To Head
    public void addFirst(T e) {
        head = new Node<>(e, head);
        if (size == 0) {
            tail = head;
        }
        size++;
        System.out.println("Added head node with " + head.getElement() + " element");
    }
//      Add To Tail
    public void addLast(T e) {
        Node<T> node = new Node<>(e, null);
            if (size == 0) {
                head = node;
            } else {
                tail.setNext(node);
            }
            tail = node;
            size++;

            System.out.println("Added tail node with " + tail.getElement() + " element");
    }
//      Remove Head Node
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T node = head.getElement();
        head = head.getNext();

        size--;
        if (isEmpty()) {
            tail = null;
        }
        System.out.println("Removed head node with " + node + " element");

        return node;
    }
//      Reverse List
    public void reverseList() {
        if (size <= 1) {
        } else if (size == 2) {
            tail.setNext(head);
            head = tail;
            tail = head.getNext();
            tail.setNext(null);
        } else {
            Node<T> current = head;
            Node<T> currentNext = head.getNext();
            Node<T> currentNextNext = currentNext.getNext();
            tail = head;
            while (currentNext != null) {
                currentNext.setNext(current);
                current = currentNext;
                currentNext = currentNextNext;
                if (currentNextNext != null) {
                    currentNextNext = currentNextNext.getNext();
                }
            }
            tail.setNext(null);
            head = current;
        }
    }
//    Main Method
    public static void main(String[] args) {
        SinglyLinkedListT singleLinkedString = new SinglyLinkedListT<String>();
        SinglyLinkedListT singleLinkedInt = new SinglyLinkedListT<Integer>();

        singleLinkedString.addFirst("A");
        singleLinkedString.addFirst("B");
        singleLinkedString.addFirst("C");
        singleLinkedString.addFirst("D");
        singleLinkedString.addFirst("E");
        singleLinkedString.addFirst("F");
        singleLinkedString.addLast("G");

        while (!singleLinkedString.isEmpty()) {
            singleLinkedString.removeFirst();
        }

        singleLinkedInt.addFirst(1);
        singleLinkedInt.addFirst(2);
        singleLinkedInt.addFirst(3);
        singleLinkedInt.addFirst(4);
        singleLinkedInt.addFirst(5);
        singleLinkedInt.addLast(6);

        while (!singleLinkedInt.isEmpty()) {
            singleLinkedInt.removeFirst();
        }
    }
}
