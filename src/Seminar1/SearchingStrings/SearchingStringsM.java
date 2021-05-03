package Seminar1.SearchingStrings;

import java.util.Locale;

import static java.lang.String.format;

public class SearchingStringsM {

    public static void findNoOfOccurrences() {
        // string comes from user input
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter a line of text: ");
//        String userInputText = scanner.nextLine();

        //given string
        String s = "today is a good day";

        int count = 0;
        int index = -1;              // i start from -1 to search first index

        while (true) {
            index = s.toLowerCase(Locale.ROOT).indexOf("a", index + 1);
            if (index == -1) {
                break;
            } else {
                count += 1;
            }
        }

        System.out.println("The string 'a' was found " + count + " times ");

        // Output: The string 'a' was found 3 times.
    }

    public static int findNoOfOccurrencesExtend(String s , char searchChar) {

        int count = 0;
        int index = -1;              // i start from -1 to search first index

        while (true) {
            index = s.toLowerCase(Locale.ROOT).indexOf(searchChar, index + 1);
            if (index == -1) {
                break;
            } else {
                count += 1;
            }
        }

        return count;
        // Output: The string 'a' was found 3 times.
    }

    public static void findNoOfOccurrencesPerChar() {

        String s = "anog .Aano";
        s = s.toLowerCase(Locale.ROOT);
        s = s.replaceAll("\\W", "");  //remove any non char
        s = s.replaceAll("  ", "");   //remove any space

        System.out.println("Letter | No of Occurrences");   //tabular format
        System.out.println("------------------------------");

        int countOfOccurrence[] = new int[200];
        char ch[] = new char[s.length()];

        for (int i = 0; i < s.length(); i++)            // Init count array index
            countOfOccurrence[s.charAt(i)]++;

        for (int i = 0; i < s.length(); i++) {
            ch[i] = s.charAt(i);

            int find = 0;
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == ch[j])        // If any matches found
                    find++;
            }

            if (find == 1)
                System.out.format(format("%5s | %3d\n", s.charAt(i), countOfOccurrence[s.charAt(i)]));

        }
    }

    public static void findNoOfOccurrencesPerChar2() {

        String s = "ano .Aano";

        System.out.println("Letter | No of Occurrences");   //tabular format
        System.out.println("------------------------------");

        int countOfOccurrence[] = new int[26];
        char ch[] = new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',};

        for (int i = 0; i < ch.length; i++) {
           int count = findNoOfOccurrencesExtend(s,ch[i]);
           countOfOccurrence[i] = count;
        }

        for (int i = 0; i < ch.length; i++) {
            System.out.format(format("%5s | %3d\n", ch[i], countOfOccurrence[i]));
        }

    }


    public static void combineLettersToWords() {
        String s = "bathe";

        System.out.println("All possible three letter combinations are :");

        for (int first = 0; first < 5; first++) {
            for (int second = 0; second < 5; second++) {
                if (second == first)                      // if exp in loop is false we go to stm below loop
                    continue;                                 //if true we continue and go test exp again
                for (int third = 0; third < 5; third++) {
                    if (first == third || second == third)
                        continue;
                    System.out.print(String.valueOf(             // f0 s1 th2 >> bat
                            s.charAt(first))                     // f0 s1 th3 >> bah  >>f0 s2 th1
                            + s.charAt(second)
                            + s.charAt(third) + "\n");


                }
            }
        }
    }

    public static void main(String[] args) {
        // findNoOfOccurrences();
        //findNoOfOccurrencesPerChar();
        //combineLettersToWords();
        findNoOfOccurrencesPerChar2();
    }
}
