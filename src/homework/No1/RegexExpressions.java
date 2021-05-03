package homework.No1;

import java.util.Scanner;

public class RegexExpressions {

    //3 words that can can contain letters and digits
    public static boolean validateProductName(String productName) {
        return productName.matches("[a-zA-Z0-9]*\\s[a-zA-Z0-9]*\\s[a-zA-Z0-9]*");   //([a-zA-Z0-9]*\\s){3}   "(\\w*\\s){3}"
    }

    // date format : dd-mm-yyyy and year should be yyyy>2020
    public static boolean validateProductExpirationDate(String productExpireDate) {
        return productExpireDate.matches("([0-2][0-9]||3[0-1])-(0[0-9]||1[0-2])-20[2-9][1-9]$");
    }

    // 9digit code ,123-123-123 and first digit cant be 0
    public static boolean validateProductId(String productId) {
        return productId.matches("[1-9]{3}-\\d{3}-\\d{3}");
    }

    //    10.000 < price > 0  format: 100$ with dollar sign in the end
    public static boolean validateProductPrice(String productPrice) {
        return productPrice.matches("^(?:[1-9][0-9]{3}|[1-9][0-9]{2}|[1-9][0-9]|[1-9])$");
    }

    public static String getUserInput(String s) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(s);
        return scanner.nextLine();
    }

    public static void checkInput(boolean value) {
        if (!value) {
            System.out.println("Invalid input ");
        } else {
            System.out.println("Valid input ");
        }
    }

    public static void main(String[] args) {

        String nameInput = getUserInput("Enter product name: ");
        checkInput(validateProductName(nameInput));

        String expireDateInput = getUserInput("Enter product expiration date: ");
        checkInput(validateProductExpirationDate(expireDateInput));

        String idInput = getUserInput("Enter product id: ");
        checkInput(validateProductId(idInput));

        String priceInput = getUserInput("Enter product price: ");
        checkInput(validateProductPrice(priceInput));
    }
}
