package Lists;


public class SingleLinkedList {
    private Node head;
    private Node tail;
    private int size;

    //    Inner Class
    private class Node {
        private int value;
        private Node next;
        // Constructor
        public Node(int value) {
            this.value = value;
        }
        // Constructor
        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

    }
    //    Constructor
    public SingleLinkedList() {
        this.size = 0;
    }
//    METHODS


    //    Insert Node At Head Method
    public void insertHeadPosition(int val) {
        //        Create Node
        Node node = new Node(val);
        //        Create Head Node
        node.next = head;
        head = node;
        //        Edge Case (if LinkedList is null)
        if (tail == null) {
            tail = head;
        }
        //        Increase Size of LinkedList
        size += 1;
    }
    //    Insert Node At Tail Method
    public void insertTailPosition(int val) {
        // If List is empty
        if (tail == null) {
            insertHeadPosition(val);
            return;
        }
        Node node = new Node(val);
        tail.next = node;
        tail = node;
        size++;
    }
    //    Insert Target At Index Method
    public void insertTargetPosition(int val, int index) {
        if (index == 0) {
            insertHeadPosition(val);
            return;
        }
        if (index == size) {
            insertTailPosition(val);
            return;
        }
        Node current = head;
        for (int i = 1; i < index; i++) {
            current = current.next;
        }
        Node node = new Node(val, current.next);
        current.next = node;

        size++;
    }


    //    Delete Node At Head Method
    public int deleteHeadPosition() {
        int val = head.value;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return val;
    }
    //    Delete Node At Tail Method
    public int deleteLastPosition() {
        if (size <= 1) {
            return deleteHeadPosition();
        }
        Node secondLast = get(size - 2);
        int val = tail.value;
        tail = secondLast;
        tail.next = null;
        return val;
    }
    //    Get Target By Index
    public Node get(int index) {
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }
    //    Get Target By Value
    public Node find(int value) {
        Node node = head;
        while (node != null) {
            if (node.value == value) {
                return node;
            }
            node = node.next;
        }
        return null;
    }
//    Delete at Index
    public int deleteTargetPositions(int index) {
        if (index == 0) {
            return deleteLastPosition();
        }
        if (index == size - 1) {
            return deleteLastPosition();
        }
        Node prev = get(index - 1);
        int val = prev.next.value;
        prev.next = prev.next.next;

        return val;
    }
//    Display LinkedList Nodes
    public void displayNodes() {
        Node current = head;
        while (current != null) {
            System.out.print(current.value + " -> ");
            current = current.next;
        }
        System.out.println("NULL");
    }


//     Main
    public static void main(String[] args) {
//        Create LinkedList
        SingleLinkedList singleLink = new SingleLinkedList();
//        Insert Nodes
        singleLink.insertHeadPosition(21);
        singleLink.insertHeadPosition(13);
        singleLink.insertHeadPosition(8);
        singleLink.insertHeadPosition(5);
        singleLink.insertHeadPosition(3);
        singleLink.insertTailPosition(34);
        singleLink.insertTailPosition(89);
        singleLink.insertTargetPosition(55, 6);

//      Print Nodes
        singleLink.displayNodes();
        System.out.println(singleLink.deleteHeadPosition() + " Now Deleted ");
        System.out.println(singleLink.deleteTargetPositions(4) + " Now Deleted ");
        singleLink.displayNodes();


    }
}