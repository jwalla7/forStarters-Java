package Lists;

public class SinglyLinkedListRE {
    public static void main(String[] args) {
        SinglyLinkedListRE numLinks = new SinglyLinkedListRE();

        numLinks.addToFront(5);
        numLinks.addToFront(4);
        numLinks.addToFront(3);
        numLinks.addToFront(2);
        numLinks.addToFront(1);
        numLinks.addToFront(0);
        numLinks.toString();
        System.out.println();

        numLinks.removeFromFront();
        numLinks.toString();
        System.out.println();

        numLinks.removeFromBack();
        numLinks.toString();
        System.out.println();

        numLinks.addToBack(4);
        numLinks.toString();
        System.out.println();

        numLinks.removeDuplicates();
        numLinks.toString();
        System.out.println();
    }


    public static class Node {
        private int data;
        private Node next;
//        Full Constructor
        private Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
//        Overloaded Constructor, adds flexibility in creating instances of a Node
        private Node(int data) {
            this(data, null);
        }
    }

    private Node head;

    public void addToFront (int data) {
//        Create Node
        Node newNode = new Node(data);
//        newNode's next reference point to same Node reference point as head
        newNode.next = head;
//        redirect head reference point to newNode
        head = newNode;
    }

    public void addToBack(int data) {
        if (head == null) { // List is empty
            head = new Node(data);
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node(data);
        }
    }

    public void removeFromFront () {
        head = head.next;
    }
    public void removeFromBack () {
        if (head == null) {
            throw new IllegalArgumentException("List is null");
        } else if (head.next == null) { // if list is of size 1
            head = null; // Makes list empty
        } else {
            Node current = head;
            while (current.next.next != null) {
                current = current.next;
            }
            current.next = null;
        }
    }
// Public method that calls Private recursive methode
    public void removeDuplicates() {
        head = rRemove(head);
    }
//    Recursive method is Private so the Head Node is not accessible
//    Only removes duplicates from ordered linked lists
    private Node rRemove(Node curr) {
        if (curr == null) {
            return null;
        }
        curr.next = rRemove(curr.next);
        if (curr.next != null && curr.data == curr.next.data) {
            return curr.next;
        }
        return curr;
    }
//      Display List
    @Override
    public String toString() {
        String answer = "";
        Node current = head;
//      Once current equals end/null
        while (current != null) {
            System.out.print(current.data + "  ");
            answer += current + "";
            current = current.next;
        }
        return answer;
    }
}
