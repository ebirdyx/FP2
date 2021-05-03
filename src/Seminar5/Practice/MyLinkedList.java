package Seminar5.Practice;

public class MyLinkedList {

    Node root;   //1st node
    int size;

    public void insert(String value) {
        Node node = new Node();
        node.value = value;
        node.next = null;

        if (root == null) {
            root = node;
        } else {
            Node n = root;
            while (n.next != null) {
                n = n.next;
            }
            n.next = node;
        }
        size++;
    }

    public int size() {
        return size;
    }

    public void print() {
        Node node = root;

        while (node.next != null) {
            System.out.println(node.value);
            node = node.next;
        }
        System.out.println(node.value); //last value

    }

    public void insertAtStart(String data) {
        Node node = new Node();
        node.value = data;
        node.next = null;
        node.next = root;

        root = node;
        size ++;
    }

    public void insertAt(int index, String value) {
        Node node = new Node();

        node.value = value;
        node.next = null;

        Node n = root;
        for (int i = 0; i < index; i++) {
            n = n.next;
        }
        node.next = n.next;
        n.next = node;
        size++;
    }
}
