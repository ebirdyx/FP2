package Seminar4;

import java.util.Arrays;

public class ArrList {
    public static void workWithArrays() {
        //Initialize an ArrayList with asList()
        java.util.ArrayList<Character> grades = new java.util.ArrayList<>(Arrays.asList('a', 'b', 'c', 'd', 'f', 'b', 'c', 'd'));

        java.util.ArrayList<Character> list2 = new java.util.ArrayList<>();
        printList(grades);

        copyUniqueElements(grades, list2);
        printList(list2);
    }

    public static void printList(java.util.ArrayList<Character> list) {
        System.out.print("List: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }

    public static void copyUniqueElements(java.util.ArrayList<Character> src, java.util.ArrayList<Character> dest) {
        for (int i = 0; i < src.size(); i++) {

            char c = src.get(i);
            if (dest.contains(c))   //check if array contains c char
                continue;
            dest.add(c);
        }
    }

    public static void main(String[] args) {
        workWithArrays();
    }
}
