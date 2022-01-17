package com.company;

import java.util.*;

public class MethodsReviewSet1_SA {
    static Scanner in = new Scanner(System.in);
    static Random r = new Random();

    public static double areaCircle(double radius) {
        return Math.pow(radius, 2) * Math.PI; //returns area of circle using radius and formula area = pi * radius^2
    }

    public static boolean odd(int num) {
        return num % 2 != 0; //returns true if number is odd, false if even
    }

    public static String monthName(int monthNum) {
        String[] month = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

        if (monthNum >= 1 && monthNum <= 12) {
            return month[monthNum - 1]; //returns month from array using month number
        } else {
            return "Invalid"; //returns "Invalid" if number is not in range of months
        }
    }

    public static int daysInMonth(int monthNum) {
        int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if (monthNum >= 1 && monthNum <= 12) {
            return monthDays[monthNum - 1]; //returns number of days in month from array using month number
        } else {
            return 0; //returns 0 if number is not in range of months
        }
    }

    public static int random(int min, int max) {
        return r.nextInt(max - min + 1) + min; //returns random number in given range min-max inclusive
    }

    public static char flip() {
        int result = random(0, 1); //calls random () method to obtain result of flip (random number 0 or 1)

        if (result == 0) {
            return 'H'; //returns heads if result is 0
        } else {
            return 'T'; //return tail if result is 1
        }
    }

    public static char randomLetter() {
        return (char) random(65, 90); //return random capital letter from A to Z (ascii values 65-90) by calling random() method
    }

    public static void CircleArea() {
        int radius;

        System.out.print("Enter radius of circle: "); //Ask for radius of circle
        radius = in.nextInt();

        if (odd(radius)) { //calls odd() method to determine if radius is odd or even and output result
            System.out.println("The radius is odd");
        } else {
            System.out.println("The radius is even");
        }

        System.out.format("Area = %.1f square units %n", areaCircle(radius)); //calls areaCircle() method to calculate area and output with 1 decimal place
    }

    public static void MonthDays() {
        System.out.format("%-15sDays%n", "Month");

        for (int i = 1; i <= 12; i++) { //use loop to output all months and days for 12 months
            System.out.format("%-15s" + daysInMonth(i) + "%n", monthName(i)); //calls monthName() and daysInMonth() methods to output formatted month and corresponding days
        }
    }

    public static void RandomFlipsAndLetters() {
        char flip = 'T';
        int tailsCount = 0;

        System.out.print("10 coins flips: ");
        for (int i = 0; i < 10; i++) { //use loop to output 10 random coin flips
            flip = flip(); //calls flip() method to generate random coin flip result
            if (flip == 'T') {
                tailsCount++; //increase number of tails results when flipping tails

            }
            System.out.print(flip);
        }
        System.out.println(" " + tailsCount + "0% tails"); //output percentage of tails results using tails counter

        System.out.print("\nFive random 4-letter combos: ");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(randomLetter()); //use nested loops and calls randomLetter() method to output 5 random 4-letter combos
            }
            System.out.print(" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("Methods Menu");
            System.out.println("Enter a number to display a program:");
            System.out.println("\n1. Circle Area");
            System.out.println("2. Month Days");
            System.out.println("3. Random Flips and Letters");
            System.out.println("Enter 0 to quit");
            choice = in.nextInt();
            System.out.println();

            if (choice == 1) {
                CircleArea();
            } else if (choice == 2) {
                MonthDays();
            } else if (choice == 3) {
                RandomFlipsAndLetters();
            }

            System.out.println("\nPress enter to continue.");
            in.nextLine();
            in.nextLine();
        }
        while (choice != 0);

        System.out.println("The program has ended");
    }
}
