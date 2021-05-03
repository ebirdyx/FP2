package seminar2.StudentData;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //Prompt for the full name in a loop until user provided valid full name
        while (true) {
            System.out.print("Enter full name: ");
            String fullName = scanner.nextLine();

            //Creating pattern to match full name format 'Firstname SecondName Lastname'
            //full name should contain only alphabets && each name starts with Capital letter.

            String namePattern = "^[A-Z][a-z]*\\s[A-Z][a-z]*\\s[A-Z][a-z]*";

            if (fullName.matches(namePattern)) {                    // check if pattern match with input provided by user
                System.out.println(fullName + " validated");        // if yes then show success msg and break(terminate) >> while loop
                                                                    // or show error msg loop will continue in this case.
                break;
            } else {
                System.out.println(fullName + " is invalid. Try again");
            }
        }

        //Prompt for cellphone No in a loop until user provides valid input
        while (true) {
            System.out.print("Enter cellphone number: ");
            String cellphoneNo = scanner.nextLine();

            String cellphoneNoPattern = "^(\\\\d{3}[- .]?){2}\\\\d{4}$";      // Creating regular expression pattern to match format 'dd-mm-yyyy'

            if (cellphoneNo.matches(cellphoneNoPattern)) {
                System.out.println(cellphoneNo + " is validated");
                break;
            } else {
                System.out.println("cellphone number is invalid. Try again");
            }
        }

        while (true) {
            System.out.print("Enter address address: ");
            String address = scanner.nextLine();

            //Creating regular expression to match patter in the form 'something@something.com'

            String emailPattern = "\\d+\\s+([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+)";  //^[a-zA-Z0-9]+@[a-zA-Z0-9]+\.[a-zA-Z0-9]+$ adress format

            if (address.matches(emailPattern)) {
                System.out.println(address + " is validated");
                break;
            } else {
                System.out.println("address is invalid. Try again");
            }
        }


        // prompt for salary in a loop until user provides valid input.
        while (true) {
            System.out.print("Enter salary : ");
            String salary = scanner.nextLine();

            /*
            Creating regular expression to match pattern
            in the form 'd.dd' where d is a digit (0 to 9).
            The following Regular Expression either matches
            number from 0.00 to 3.99 or number 4.00
            (here symbol '|' is used for or
            operation in regular expression)
             */
            String salaryPattern = "([0-9]\\.[0-9]{2})|([530]\\.[290]{2})";

            if (salary.matches(salaryPattern)) {
                System.out.println(salary + " is validated");
                break;
            } else {
                System.out.println(" salary is invalid. Try again");
            }
        }
    }

}
