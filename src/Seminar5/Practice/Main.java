package Seminar5.Practice;

public class Main {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();

        list.insert("one");
        list.insert("two");
        list.insert("three");

        list.insertAtStart("ten");
        list.insertAt(3,"booo");

        System.out.println("Size of linkedList: " + list.size());
        list.print();

    }
}
