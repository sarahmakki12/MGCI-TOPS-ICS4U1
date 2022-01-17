/*Box Driver Class
Mr. Jay
ICS4U1-02
Sarah Ali
March 2020*/

package com.company;

import java.util.Scanner;

public class BoxDriver_SA {
    static Scanner in = new Scanner(System.in);

    public static void stats(Box box) { //Method that prints out the dimensions, area, and volume of the box
        System.out.println("Width: " + box.width() + " Height: " + box.height() + " Length: " + box.length());
        System.out.println("Area: " + box.area() + " Volume: " + box.volume());
    }

    public static void main(String[] args) {
        System.out.println("Enter width, height, and length of the box: "); //Prompt user for dimensions of first box
        double width = in.nextDouble();
        double height = in.nextDouble();
        double length = in.nextDouble();
        System.out.println("Enter the side length of the cube: "); //Prompt user for dimensions of cube
        double side = in.nextDouble();

        Box prism = new Box(width, height, length); //create Box objects using 3 different constructors
        Box cube = new Box(side);
        Box copy = new Box(prism);

        System.out.println();
        System.out.println("-Rectangular Prism Box-");
        stats(prism);
        System.out.println("-Cube Box-");
        stats(cube);
        System.out.println("-Copy of Rectangular Prism Box-");
        stats(copy);

        Box big = new Box(prism); //create Box objects that are 25% bigger and 25% smaller than the prism box using methods biggerBox and smallerBox
        big.biggerBox(prism);
        Box small = new Box(prism);
        small.smallerBox(prism);

        System.out.println();
        System.out.println("-Bigger Rectangular Box-");
        stats(big);
        System.out.println("-Smaller Rectangular Box-");
        stats(small);

        System.out.println();
        if (prism.nests(big)) { //check if prism can fit inside bigger box
            System.out.println("The prism fits inside the bigger box");
        }
        if (!prism.nests(small)) { //check if prism can fit inside smaller box
            System.out.println("The prism does not fit inside the smaller box");
        }
    }

}
