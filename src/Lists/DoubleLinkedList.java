package Lists;


public class DoubleLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public DoubleLinkedList() {
        this.size = size;
    }

    private class Node {
        private Node next;
        private Node prev;
        private int value;

        public Node(Node next, Node prev, int value) {
            this.next = next;
            this.prev = prev;
            this.value = value;
        }

        public Node(int value) {
            this.value = value;
        }

    }


//    METHODS

    //    Insert Target At Head
    public void insertHeadPosition(int val) {
        // Create Node
        Node node = new Node(val);
        //  Set Node At Head
        node.next = head;
        node.prev = null;
        //  Edge Case
        if (head != null) {
            head.prev = node;
        }
        head = node;
    }

    //    Insert Target At Tail
    public void insertTailPosition(int val) {
        // Edge Case
        if (tail == null) {
            insertHeadPosition(val);
            return;
        }
        //  Create Node
        Node node = new Node(val);
        //  Set Node At Tail
        node.next = tail;
        tail = node;
        // Increase Size of LinkedList
        size++;
    }
    //    Insert At Tail without Size
    public void insertLastPositionNoSize(int val) {
        Node node = new Node(val);
        Node tail = head;

        node.next = null;

        if (head == null) {
            node.prev = null;
            head = node;
            return;
        }

        while (tail.next != null) {
            tail = tail.next;
        }

        tail.next = node;
        node.prev = tail;
    }

    //    Insert Target By Index
    //    Insert Before Target By Value
    public void insertBeforeTargetPosition(int target, int val) {
        Node after = getByValue(target);


    }
    //    Insert After Target By Value
    public void insertAfterTargetPosition(int target, int val) {
        Node before = getByValue(target);

        if (before == null) {
            System.out.println("target is null");
            return;
        }
        Node node = new Node(val);
        node.next = before.next;
        before.next = node;
        node.prev = before;

        if (node.next != null) {
            node.next.prev = node;
        }
    }
    //    Delete Target At Head
    //    Delete Target At Tail
    //    Delete Target By Index


    //    Find Target By Value
    public Node getByValue(int value) {
        //  Set Pointer
        Node node = head;
        while (node != null) {
            if (node.value == value) {
                return node;
            }
            node = node.next;
        }
        return null;
    }
    //    Find Target By Index
    public Node getByIndex(int index) {
        //  Set Pointer
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }



    //    Display Method
    public void display() {
        Node currentNode = head;
        Node lastNode = null;

        while (currentNode != null) {
            System.out.print(currentNode.value + " -> ");
            lastNode = currentNode;
            currentNode = currentNode.next;
        }
        System.out.println("END NULL ");
        //    Display In Reverse
        System.out.println("Print in Reverse");
        while (lastNode != null) {
            System.out.print(lastNode.value + " -> ");
            lastNode = lastNode.prev;
        }
        System.out.println("START NULL ");
    }





    public static void main(String[] args) {
        DoubleLinkedList doubleLink = new DoubleLinkedList();


        doubleLink.insertHeadPosition(13);
        doubleLink.insertHeadPosition(8);
        doubleLink.insertHeadPosition(5);
        doubleLink.insertHeadPosition(3);
        doubleLink.insertHeadPosition(2);
        doubleLink.insertHeadPosition(1);

        doubleLink.insertLastPositionNoSize(21);

        doubleLink.insertAfterTargetPosition(21, 55);

        System.out.println("Get by index 3: " + doubleLink.getByIndex(3).value);


        doubleLink.display();
    }

}
