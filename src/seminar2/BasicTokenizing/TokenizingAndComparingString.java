package seminar2.BasicTokenizing;

import java.util.Scanner;
import java.util.StringTokenizer;

public class TokenizingAndComparingString {

    public static void tokenizeFirstLetter() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String line = scanner.nextLine();

        //tokenizing according to space
        StringTokenizer tokenizer = new StringTokenizer(line, " ");
        System.out.print("Words that begin with b: ");

        while (tokenizer.hasMoreTokens()) {          //hasMoreTokens bool true if the string has at least one token
            String word = tokenizer.nextToken();     // return nextToken

            if (word.startsWith("b"))               //if index 0 is b >> charAt(0)
                System.out.println(word);
        }
    }

    public static void tokenizeEndingLetters() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String line = scanner.nextLine();

        //tokenizing according to space
        StringTokenizer tokenizer = new StringTokenizer(line, " ");
        System.out.println("Words that end with ED: ");

        while (tokenizer.hasMoreTokens()) {          //hasMoreTokens bool true if the string has at least one token
            String word = tokenizer.nextToken();     // return nextToken

            if (word.endsWith("ed"))
                System.out.println(word);
        }
    }

    public static void reverseSentence() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String line = scanner.nextLine();

        String token[] = line.split(" ");
        System.out.println("Reverse sentence: ");

        for (int i = token.length - 1; i >= 0; i--) {    // for loop to reverse
            System.out.print(token[i] + " ");
        }
    }

    public static void main(String[] args) {

        // tokenizeFirstLetter();
        // tokenizeEndingLetters();
        //reverseSentence();

    }
}
