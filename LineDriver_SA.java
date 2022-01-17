/*Line Class Driver
Mr. Jay
ICS4U1-02
Sarah Ali
March 2020*/

package com.company;

import java.util.Scanner;

public class LineDriver_SA {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("LINE 1");
        Line line1 = new Line(0, 0, 0);
        line1.readLine(in);
        System.out.println("The equation is: " + line1);
        System.out.println("The x-intercept is " + line1.xint());
        System.out.println("The y-intercept is " + line1.yint());
        System.out.println("The slope is " + line1.slope());
        System.out.println("The line is vertical: " + line1.vertical());
        System.out.println("The line is horizontal: " + line1.horizontal());

        System.out.println("\nLINE 2");
        Line line2 = new Line(0, 0, 0);
        line2.readLine(in);
        System.out.println("The equation is: " + line2);
        System.out.println("The x-intercept is " + line2.xint());
        System.out.println("The y-intercept is " + line2.yint());
        System.out.println("The slope is " + line2.slope());
        System.out.println("The line is vertical: " + line2.vertical());
        System.out.println("The line is horizontal: " + line2.horizontal());

        System.out.println("\nINTERSECTION");
        Point point = line1.intersect(line2);
        System.out.println("Intersection point: " + point);
    }
}
