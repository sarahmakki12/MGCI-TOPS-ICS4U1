package com.company;
import java.util.*;

public class Gr10Review {

    static Scanner in = new Scanner (System.in);

    public static void AreaOfACircle ()
    {
        System.out.print("Input the radius: ");
        int radius = in.nextInt(); //input for radius

        System.out.print("The radius is: " + radius + " "); //output radius
        System.out.println("The area is: " + (radius * radius * Math.PI)); //output area
    }

    public static void CentsToDollars ()
    {
        System.out.println("Input the cents: ");
        int cents = in.nextInt(); //input cents

        int dollars = cents/100; //calculate dollars
        int leftover = cents%100; //calculate leftover cents

        System.out.println("That is " + dollars + " dollars and " + leftover + " cents."); //output dollars and cents
    }

    public static void CorrectChange ()
    {
        System.out.println("Input the cents: ");
        int cents = in.nextInt();

        int dollars = cents/100;
        cents = cents%100;

        int quarters = cents/25;
        cents = cents%25;

        int dimes = cents/10;
        cents = cents%10;

        int nickels = cents/5;
        cents = cents%5;

        System.out.println("Your change is " + dollars + " dollars, " + quarters + " quarters, " + dimes + " dimes, " + nickels + " nickels, and " + cents + " cents.");
    }

    public static void OhmsLaw ()
    {
        System.out.print("Enter the voltage: ");
        int V = in.nextInt();
        System.out.print("Enter the resistance: ");
        int R = in.nextInt();

        float I = (float) ((V + 0.0)/R);

        System.out.println("The electrical current is " + I + " A.");
    }

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("Enter a number to display a program:");
            System.out.println();
            System.out.println("1 - Area of a Circle");
            System.out.println("2 - Cents to Dollars");
            System.out.println("3 - Correct Change");
            System.out.println("4 - Ohm's Law");
            System.out.println("Enter 0 to quit");
            choice = in.nextInt();

            if (choice == 1) {
                AreaOfACircle();
            } else if (choice == 2) {
                CentsToDollars();
            } else if (choice == 3) {
                CorrectChange();
            } else if (choice == 4) {
                OhmsLaw();
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
