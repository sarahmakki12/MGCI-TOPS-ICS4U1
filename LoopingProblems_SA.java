/*
Looping Problems
Mr. Jay
ICS4U1-02
Sarah Ali
Feb 2020
 */

package com.company;

import java.util.*;

public class LoopingProblems_SA {

    static Scanner in = new Scanner(System.in);

    public static void Exercise16_2() {
        int N;
        double sum = 0;

        System.out.println("Enter N"); //Ask for integer limit N
        N = in.nextInt();

        for (int i = 1; i <= N; i++) //Go through numbers i = 1, 2, 3,..., N
        {
            sum += 1.0 / i; //Add 1/i each time to sum
        }

        System.out.println("Sum is " + sum);
    }

    public static void Exercise17_2() {
        int n, sumSquares = 0, sumCubes = 0;

        System.out.println("Upper Limit: "); //Ask for upper limit
        n = in.nextInt();

        sumSquares = n * (n + 1) * (2 * n + 1) / 6; //Use formulas to calculate sum of squares and sum of cubes
        sumCubes = (int) (Math.pow(n, 2) * Math.pow(n + 1, 2) / 4);

        System.out.println("Using formulas: ");
        System.out.println("The sum of Squares is " + sumSquares);
        System.out.println("The sum of Cubes is " + sumCubes);

        sumSquares = 0; //Reset sums of squares and cubes
        sumCubes = 0;

        for (int i = 1; i <= n; i++) //Go through numbers i = 1, 2, 3,..., n (base numbers)
        {
            sumSquares += Math.pow(i, 2); //Add square of i to sum of squares
            sumCubes += Math.pow(i, 3); //Add cube of i to sum of cubes
        }

        System.out.println("Using loops: ");
        System.out.println("The sum of Squares is " + sumSquares);
        System.out.println("The sum of Cubes is " + sumCubes);
    }

    public static void Exercise18_3() {
        int lowerLimit, higherLimit, num, inRangeSum = 0, outRangeSum = 0;

        System.out.println("In-range Adder");
        System.out.println("Low end of range:"); //Ask for lower limit of range
        lowerLimit = in.nextInt();
        System.out.println("High end of range:"); //Ask for upper limit of range
        higherLimit = in.nextInt();

        do {
            System.out.println("Enter data:"); //Ask for integers to be added up
            num = in.nextInt();

            if (num >= lowerLimit && num <= higherLimit) {
                inRangeSum += num; //Add integer to sum of in range values if within range
            } else {
                outRangeSum += num; //Add integer to sum of out of range values if out of range
            }
        }
        while (num != 0); //End input when user enters 0

        System.out.println("Sum of in range values: " + inRangeSum);
        System.out.println("Sum of out of range values: " + outRangeSum);
    }

    public static void Exercise18_4() {
        int weight;

        do {
            System.out.println("Weight of Order:"); //Ask for weight of order
            weight = in.nextInt();

            if (weight <= 10 && weight > 0) {
                System.out.println("Shipping cost: $3.00\n"); //Shipping cost of $3.00 if weight is under 10 pounds
            } else if (weight > 10) {
                System.out.format("Shipping cost: $%.2f%n\n", 3 + 0.25 * (weight - 10)); //Shipping cost of $3.00 and $0.25 for every pound above 10 pounds
            }
        }
        while (weight != 0); //End input when user enters 0

        System.out.println("\nbye");
    }

    public static void Exercise19_1() {
        int month = 1;
        double monthlyPayment, monthlyInterest, balance, totalPayments = 0;

        System.out.println("Enter the beginning balance:"); //Ask for beginning balance
        balance = in.nextDouble();
        System.out.println("Enter the monthly interest: "); //Ask for monthly interest
        monthlyInterest = in.nextDouble();
        System.out.println("Enter the monthly payment:"); //Ask for monthly payment
        monthlyPayment = in.nextDouble();

        do {
            balance = balance + balance * monthlyInterest / 100 - monthlyPayment; //New balance obtained by adding interest on unpaid balance and subtracting monthly payment
            totalPayments += monthlyPayment; //Total payments obtained by adding monthly payment every month

            System.out.format("Month: %-9d", month);
            System.out.format("balance: %-15.2f", balance);
            System.out.println("\ttotal payments: " + totalPayments);

            month++; //Increase counter for next month
        }
        while (balance > monthlyPayment); //End payments when balance no longer exceeds monthly payment

        System.out.format("The final payment needed is $%.2f%n", balance); //Final payment needed is the remaining balance
    }

    public static void Exercise19_2() {
        int month = 0;
        double effectiveness = 100;

        do {
            effectiveness = 100 * Math.pow(0.96, month); //Decrease effectiveness by 4% every month

            System.out.format("month: %-9d", month);
            System.out.format("effectiveness: %.2f", effectiveness); //Round effectiveness to 2 decimal places

            if (effectiveness < 50) {
                System.out.println(" DISCARDED"); //Discard drug when effectiveness is below 50%
            } else {
                System.out.println();
            }

            month++; //Increase counter for next month
        }
        while (effectiveness > 50); //Discard drug when effectiveness is below 50%
    }

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("Enter a number to display a program:");
            System.out.println();
            System.out.println("1 - Exercise 16.2");
            System.out.println("2 - Exercise 17.2");
            System.out.println("3 - Exercise 18.3");
            System.out.println("4 - Exercise 18.4");
            System.out.println("5 - Exercise 19.1");
            System.out.println("6 - Exercise 19.2");
            System.out.println("Enter 0 to quit");
            choice = in.nextInt();
            System.out.println();

            if (choice == 1) {
                Exercise16_2();
            } else if (choice == 2) {
                Exercise17_2();
            } else if (choice == 3) {
                Exercise18_3();
            } else if (choice == 4) {
                Exercise18_4();
            } else if (choice == 5) {
                Exercise19_1();
            } else if (choice == 6) {
                Exercise19_2();
            }

            System.out.println();
            System.out.println("Press enter to continue.");
            in.nextLine();
            in.nextLine();
        }
        while (choice != 0);

        System.out.println("The program has ended");
    }
}
