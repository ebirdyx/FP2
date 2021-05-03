package Seminar5.Pain;

public class Main {
    public static void main(String[] args) {
        MyList list = new MyList();
        list.add("zero");
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("four");
        list.add("four");

        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(3));
        System.out.println(list.get(4));
        System.out.println(list.get(5));

    }
}
