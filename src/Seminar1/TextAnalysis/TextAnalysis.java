package Seminar1.TextAnalysis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class TextAnalysis {

    public static void getPartsOccurence(){
        Scanner scanner = new Scanner( System.in );
        System.out.println( "Please enter a line of text: " );   //be to three be two three be
        String userInput = scanner.nextLine();

        userInput = userInput.toLowerCase();
        userInput = userInput.replaceAll( "\\W", " " );     // strip out any non words.
        userInput = userInput.replaceAll( "  ", " " );      // strip out any double spaces
        //   created from stripping out non words
        //   in the first place!
        String[] tokens = userInput.split( " " );
        System.out.println( userInput );

        ArrayList< String > items = new ArrayList< String >();

        items.addAll( Arrays.asList(tokens) );

        int count = 0;

        for( int i = 0; i < items.size(); i++ )
        {
            System.out.printf( "%s: ", items.get( i ) );   // prints parts string
            for( int j = 0; j < items.size(); j++ )
            {
                if( items.get( i ).equals( items.get( j ) ) )
                    count++;
                if( items.get( i ).equals( items.get( j ) ) && count > 1 )
                    items.remove( j );                      // after having counted at least
            }                                               // one, remove duplicates from List
            System.out.printf( "%d\n", count );         //sout no of parts
            count = 0;
        }
    }

    public static void getOccurrencePerAlphabetChar(){
        Scanner scanner = new Scanner( System.in );
        System.out.println( "Please enter a line of text: " );
        String userInput = scanner.nextLine().toLowerCase(Locale.ROOT);

        StringBuffer r = new StringBuffer();

        int[] alphabetFind = new int[26];
        char ch[] = new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',};

        for (int i = 0; i< userInput.length(); i++){
            if (Character.isAlphabetic(userInput.charAt(i))) {
                alphabetFind[(int)userInput.charAt(i) - 'a']++;   // checks if user input is a letter than incrm
            }
//            r = r.append(userInput.charAt(i));
        }


        System.out.println("Char  ||  Occurrence");
        System.out.println("------------------------------");
        for (int i = 0; i < 26; i++)
            System.out.println(ch[i] + alphabetFind[i]);
    }

    public static void main(String[] args) {

      //  getPartsOccurence();
      getOccurrencePerAlphabetChar();


    }
}
