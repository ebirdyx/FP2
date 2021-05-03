package seminar2.TokenizingMedium;

import java.util.Scanner;

public class TelephoneNo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // input a telephone number as a string in the form (555) 555-5555B
        System.out.print("Enter a telephone number as '(XXX) XXX-XXXX': ");
        String inputNumber = scanner.nextLine();
        System.out.println();

        int startIndex = 1;
        int endIndex = 4 ;

        String firstToken[] = inputNumber.split(" ");
        String areaCode = firstToken[0].substring(startIndex, endIndex);             // extract the area code as a token
        System.out.println("Area code: " + areaCode);

        String secondToken[] = firstToken[1].split("-");
        String firstThree = secondToken[0];                       // extract the first three digits of the phone number as a token
        String lastFour = secondToken[1];                         // extract the last four digits of the phone number as a token

        // concat 7 digits of the phone no into 1 string
        String sevenDigits = firstThree + lastFour;

        // concat the area code and 7 digits of the phone no into 1 string
        String fullNumber = areaCode + " " + sevenDigits;

        System.out.println("Phone number: " + sevenDigits);
        System.out.println("Full Phone number: " + fullNumber);
    }
}
