package Seminar4;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

public class Main {

    public static void insertElementsInSortedOrder() {

        Random random = new Random();                            // Creating an object of random class
        LinkedList<Integer> object = new LinkedList<>();
        int bound = 101;

        for (int i = 0; i < 25; i++) {
            int value = random.nextInt(bound); // generates a random number 0-100 & insert value in LinkedList
            object.add(value);
        }
        System.out.println("Generated random numbers before sorting: " + object);
        Collections.sort(object); // sort LinkedList

        System.out.print("LinkedList elements after sorting : ");
        for (int i = 0; i < object.size(); i++)
            System.out.print(object.get(i) + " ");

        int sum = 0;
        for (int i = 0; i < object.size(); i++) // find sum of el of the LinkedList
            sum += object.get(i);
        System.out.println("\nSum: " + sum);

        double average = (sum / 25.0); // find average of el of the LinkedList
        System.out.println("Average: " + average);
    }

    public static void main(String args[]) {
        insertElementsInSortedOrder();
    }
}
