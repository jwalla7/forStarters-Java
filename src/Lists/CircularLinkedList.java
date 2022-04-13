package Lists;

public class CircularLinkedList {
    //    Class Members
    private Node head;
    private Node tail;

    //    Constructor
    public CircularLinkedList() {
        this.head = null;
        this.tail = null;
    }

    // Inner Class
    private class Node {
        Node next;
        int value;

        public Node(int value) {
            this.value = value;
        }
    }
//    METHODS
    //    Insert Target At Head
    public void insertHeadPosition(int value) {
        Node node = new Node(value);
        if (head == null) {
            head = node;
            tail = node;
            return;
        }

        tail.next = node;
        node.next = head;
        tail = node;
    }
    //    Insert Target At Tail
    //    Insert Target At Tail without Size
    //    Insert Target At Index
    //    Insert Target Before Value
    //    Insert Target After Value

    //    Find Target By Index
    //    Find Target By Value

    //    Delete Target By Value
    public void deleteTargetByValue(int val) {
        Node node = head;
        if (node == null) {
            return;
        }
        if (node.value == val) {
            head = head.next;
            tail.next = head;
        }
        do {
            Node nextNode = node.next;
            if (nextNode.value == val) {
                node.next = nextNode.next;
                break;
            }
            node = node.next;
        } while (node != head);
    }

//    Display Method
    public void display() {
        Node node = head;
        if (head != null) {
            do {
                System.out.print(node.value + " ->  HEAD");
                node = node.next;
            } while (node != head);
        }
    }




    public static void main(String[] args) {
        CircularLinkedList circleLink = new CircularLinkedList();

        circleLink.insertHeadPosition(0);
        circleLink.insertHeadPosition(1);
        circleLink.insertHeadPosition(2);
        circleLink.insertHeadPosition(3);
        circleLink.insertHeadPosition(5);

        circleLink.deleteTargetByValue(5);

        circleLink.display();
    }

}

