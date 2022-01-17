/*Line Class
Mr. Jay
ICS4U1-02
Sarah Ali
March 2020*/

package com.company;

import java.util.Scanner;

public class Line {
    private int A, B, C; //private instance variables for coefficients

    public Line(int a, int b, int c) { //constructor that creates line with given coefficients
        A = a;
        B = b;
        C = c;
    }

    public String toString() { //method that converts line to string so that 0 terms, 1 coefficients, - signs don't appear
        String eqn = "";
        eqn += A == 0 ? "" : (A == 1 ? "x " : (A == -1 ? "-x " : A + "x ")); //Adds x-term
        eqn += A != 0 && B != 0 ? (B > 0 ? "+ " : "- ") : (B < 0 ? "-" : ""); //Adds +/- sign before y-term
        eqn += B == 0 ? "" : (Math.abs(B) == 1 ? "y " : Math.abs(B) + "y "); //Adds y-term
        eqn += (A != 0 || B != 0) && C != 0 ? (C > 0 ? "+ " : "- ") : (C < 0 ? "-" : ""); //Adds +/- sign before constant
        eqn += C == 0 ? "" : Math.abs(C) + " "; //Adds constant
        return eqn + "= 0"; //Adds = 0 to end of equation
    }

    public void readLine(Scanner in) { //method that accepts Scanner object, reads a linear equation from the user until they enter a valid line, then reads coefficients from entered line
        boolean invalid = true;
        String legal = "xy+-=0123456789 ";

        System.out.print("Enter a linear equation: ");
        String line = in.nextLine();

        while (invalid) { //Continues prompting for equation until valid equation is entered
            invalid = false;

            for (int i = 0; i < line.length(); i++) { //Checks for any illegal characters in the equation
                if (!legal.contains(String.valueOf(line.charAt(i)))) {
                    invalid = true;
                }
            }

            if (invalid) { //Prompts for another equation if invalid
                System.out.print("Invalid equation. Try again: ");
                line = in.nextLine();
            }
        }

        //reads coefficients from line by catching failed attempts at reading certain coefficients
        if (line.contains("x")) {
            try {
                A = line.substring(0, line.indexOf("x")).equals("-") ? -1 : Integer.parseInt(line.substring(0, line.indexOf("x")));
            } catch (NumberFormatException e) {
                A = 1;
            }
            if (line.contains("y")) {
                try {
                    B = line.substring(line.indexOf("x") + 1, line.indexOf("y")).equals("-") ? -1 : Integer.parseInt(line.substring(line.indexOf("x") + 1, line.indexOf("y")));
                } catch (NumberFormatException e) {
                    B = 1;
                }
                try {
                    C = Integer.parseInt(line.substring(line.indexOf("y") + 1, line.indexOf("=")));
                } catch (NumberFormatException e) {
                    C = 0;
                }
            } else {
                B = 0;
                try {
                    C = Integer.parseInt(line.substring(line.indexOf("x") + 1, line.indexOf("=")));
                } catch (NumberFormatException e) {
                    C = 0;
                }
            }
        } else {
            A = 0;
            if (line.contains("y")) {
                try {
                    B = line.substring(0, line.indexOf("y")).equals("-") ? -1 : Integer.parseInt(line.substring(0, line.indexOf("y")));
                } catch (NumberFormatException e) {
                    B = 1;
                }
                try {
                    C = Integer.parseInt(line.substring(line.indexOf("y") + 1, line.indexOf("=")));
                } catch (NumberFormatException e) {
                    C = 0;
                }
            } else {
                B = 0;
                try {
                    C = Integer.parseInt(line.substring(0, line.indexOf("=")));
                } catch (NumberFormatException e) {
                    C = 0;
                }
            }
        }
    }

    public Point intersect(Line line) { //method that accepts Line object and return a Point object for the point of intersection with the invoking Line
        if (line.slope() == this.slope()) {
            return new Point(0); //returns nonexistent point if equations have the same slopes
        }

        double a1 = A, b1 = B, c1 = C, a2 = line.A, b2 = line.B, c2 = line.C;

        double x = (b2 * c1 - b1 * c2) / (a2 * b1 - a1 * b2); //Calculates coordinates of intersection
        double y = this.slope() * x + this.yint();

        return new Point(x, y);
    }

    public double xint() { //method that returns x-intercept of line
        return (double) -C / A;
    }

    public double yint() { //method that returns y-intercept of line
        return (double) -C / B;
    }

    public double slope() { //method that returns slope of line
        return (double) -A / B;
    }

    public boolean vertical() { //method that returns boolean for whether the line is vertical
        return B == 0 && A != 0;
    }

    public boolean horizontal() { //method that returns boolean for whether the line is horizontal
        return A == 0 && B != 0;
    }
}
