/*Box Class
Mr. Jay
ICS4U1-02
Sarah Ali
March 2020*/

package com.company;

public class Box {
    private double w, h, l; //private instance variables for dimensions

    public Box(double width, double height, double length) { //constructor that creates box: takes in dimensions and assigns them to instance variables
        w = width;
        h = height;
        l = length;
    }

    public Box(double side) { //constructor that creates a cube
        w = side;
        h = side;
        l = side;
    }

    public Box(Box oldBox) { //copy constructor that creates box with identical dimensions to old box
        w = oldBox.width();
        h = oldBox.height();
        l = oldBox.length();
    }

    public void biggerBox(Box oldBox) { //method that assigns dimensions 25% bigger than old box
        w = oldBox.width() * 1.25;
        l = oldBox.length() * 1.25;
        h = oldBox.height() * 1.25;
    }

    public void smallerBox(Box oldBox) { //method that assigns dimensions 25% smaller than old box
        w = oldBox.width() * 0.75;
        l = oldBox.length() * 0.75;
        h = oldBox.height() * 0.75;
    }

    public boolean nests(Box outsideBox) { //method that returns boolean based on whether the box completely fits inside outside box without considering rotations
        return l < outsideBox.length() && w < outsideBox.width() && h < outsideBox.height();
    }

    public double volume() { //method that returns volume of box
        return w * h * l;
    }

    public double area() { //method that returns surface area of box
        return 2 * faceArea() + 2 * topArea() + 2 * sideArea();
    }

    private double faceArea() { //private method that returns area of face of box
        return l * h;
    }

    private double topArea() { //private method that returns area of top of box
        return l * w;
    }

    private double sideArea() { //private method that returns area of side of box
        return w * h;
    }

    public double length() { //access method for length of box
        return l;
    }

    public double height() { //access method for height of box
        return h;
    }

    public double width() { //access method for width of box
        return w;
    }
}
