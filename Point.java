/*Point Class
Mr. Jay
ICS4U1-02
Sarah Ali
March 2020*/

package com.company;

public class Point {
    private double x, y, o = 1; //private instance variables for coordinates

    public Point(double xcord, double ycord) { //constructor that creates point with given coordinates
        x = xcord;
        y = ycord;
    }

    public Point(int obj) { //constructor that creates nonexistent point
        o = obj;
    }

    public String toString() { //method that converts Point object to String
        return o == 0 ? "DNE" : "(" + x + ", " + y + ")";
    }
}
