package Seminar4;

import java.util.Scanner;

public class StandardDeviationS {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter N: ");   //ask user for value of n
        int n = scanner.nextInt();

        double arr[] = new double[n];
        System.out.print("Enter the numbers: ");
        for (int i = 0; i < n; i++)
        {
            arr[i] = scanner.nextDouble();  //inputting n values in array arr
        }

        double sum = 0.0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }

        double avg = sum / n;        //avg calculated
        double standardDeviation = 0;
        for (int i = 0; i < n; i++) {
            standardDeviation += Math.pow(arr[i] - avg, 2); //Subtracting from avg and squaring
        }

        double s = Math.sqrt(standardDeviation / n);        //dividing by n and then taking square root

        System.out.println("Standard Deviation(s) = " + s);
    }
}
