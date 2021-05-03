package Seminar5.Pain;

class MyNode {
    String value;
    MyNode next;
}

public class MyList {
    MyNode root;

    public void add(String value) {
        MyNode node = new MyNode();
        node.value = value;

        if (root == null) {
            root = node;
        } else {
            MyNode index = root;
            while (index.next != null) {
                index = index.next;
            }
            index.next = node;
        }
    }

    public String get(int index) {
        int i = 0;
        MyNode n = root;
        while (i != index) {
            n = n.next;
            i++;
        }
        return n.value;
    }
}
