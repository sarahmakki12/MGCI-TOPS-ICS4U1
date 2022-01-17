/*Recursive Methods
Mr. Jay
ICS4U1-02
Sarah Ali
Feb 2020*/

package com.company;

import java.util.*;

public class RecursiveMethods_SA {
    static Scanner in = new Scanner(System.in);

    public static boolean prime(int N) { //boolean method that tests if N is prime
        return prime(N, N / 2); //tests for divisibility by numbers less than or equal to N/2
    }

    public static boolean prime(int N, int D) { //checks for divisibility of N to determine if it's prime
        if (D == 1) {
            return true; //N is prime if D reaches 1 because N has no factors except for N and 1
        } else if (N % D == 0) {
            return false; //if N is divisble by any number except for N and 1 it is not prime
        }
        return prime(N, D - 1); //check for next possible factor
    }

    public static int perrin(int N) { //returns Nth term in the Perrin sequence using recursion
        if (N == 0) { //return set values for the first 3 terms (N < 3) of the sequence
            return 3;
        } else if (N == 1) {
            return 0;
        } else if (N == 2) {
            return 2;
        } else {
            return perrin(N - 2) + perrin(N - 3); //find Nth term if N > 2 using definition of Perrin sequence
        }
    }

    public static int perrinNoRecursion(int N) { //returns Nth term in the Perrin sequence without using recursion
        int a = 3, b = 0, c = 2, term = 0;

        if (N == 0) { //return set values for the first 3 terms (N < 3) of the sequence
            return 3;
        } else if (N == 1) {
            return 0;
        } else if (N == 2) {
            return 2;
        } else {
            while (N > 2) { //keep adding term - 2 and term - 3 until you reach desired term N
                term = a + b; //adds a = term - 3 and b = term - 2
                a = b; //moves up values
                b = c;
                c = term;

                N--; //decreases counter
            }
        }

        return term;
    }

    public static void PrimeNumber() { //Outputs whether entered integer is prime or not
        System.out.print("Enter an integer: ");
        int N = in.nextInt();
        if (prime(N)) { //Outputs if N is prime or not
            System.out.println("Integer " + N + " is prime");
        } else {
            System.out.println("Integer " + N + " is not prime");
        }
    }

    public static void PerrinSequence() { //Outputs Nth term in Perrin Sequence using recursion
        System.out.print("Enter an integer: ");
        int N = in.nextInt();
        System.out.println("Term #" + N + " of the Perrin sequence is " + perrin(N));
    }

    public static void PerrinSequenceNoRecursion() { //Outputs Nth term in Perrin Sequence without using recursion
        System.out.print("Enter an integer: ");
        int N = in.nextInt();
        System.out.println("Term #" + N + " of the Perrin sequence is " + perrinNoRecursion(N));
    }

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("Enter a number to display a program:");
            System.out.println();
            System.out.println("1 - Prime Number");
            System.out.println("2 - Perrin Sequence (recursion)");
            System.out.println("3 - Perrin Sequence (no recursion)");
            System.out.println("Enter 0 to quit");
            choice = in.nextInt();
            System.out.println();

            if (choice == 1) {
                PrimeNumber();
            } else if (choice == 2) {
                PerrinSequence();
            } else if (choice == 3) {
                PerrinSequenceNoRecursion();
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