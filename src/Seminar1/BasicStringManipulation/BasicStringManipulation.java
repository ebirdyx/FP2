package Seminar1.BasicStringManipulation;

import java.util.Locale;
import java.util.Scanner;

public class BasicStringManipulation {


    public static void compareString() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter first string: ");
        String s1 = scanner.nextLine();
        System.out.println("Enter second string: ");
        String s2 = scanner.nextLine();

        //.equals
        if (s1.length() > s2.length())
            System.out.println("First string " + s1 + " is greater than the second string. ");
        else if (s1.length() < s2.length())
            System.out.println("First string " + s1 + " is less than the second string. ");
        else
            System.out.println("S1 equal to S2");
    }

    //use .regionMatches method > ignore case sensitive
    public static void compareStringPortions() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first string: ");
        String s1 = scanner.nextLine();
        System.out.println("Enter second string: ");
        String s2 = scanner.nextLine();

        final boolean ignoreCase = true;
        final int offset = 0;
        final int otherStringOffset = 0;
        final int noOfCharToCompare = 5;

        if (s1.regionMatches(ignoreCase, offset, s2, otherStringOffset, noOfCharToCompare))
            System.out.println("First 5 char of s1 and s2 match.");
        else
            System.out.println("First 5 char of s1 and s2 don't match.");
    }

    public static void displayUpLowCase() {
        System.out.println("Enter text: ");
        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();
        System.out.println(s.toLowerCase(Locale.ROOT));
        System.out.println(s.toUpperCase(Locale.ROOT));
    }


    public static void main(String[] args) {

        //displayUpLowCase();
        //compareString();
        //compareStringPortions();
    }

}
