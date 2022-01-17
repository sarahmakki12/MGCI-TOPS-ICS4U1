/*Fungi Class
Mr. Jay
ICS4U1-02
Sarah Ali
March 2020*/

package com.company;

public class Fungi extends Eukaryote{
    protected int mushrooms; //protected variable for number of mushrooms
    protected double area; //protected variable for area occupied by individual fungi

    public Fungi () { //default constructor
        this(0, 1); //calls general constructor with default values
    }

    public Fungi(int mush, double are) { //general constructor
        mushrooms = mush;
        area = are;
        cellWall = "chitin";
        photosynthetic = false;
    }

    public void reproduce () { //inherited method from abstract parent Eukaryote for reproduction
        System.out.println("This fungi has reproduced in a haploid-dominant life cycle.");
    }

    public String toString () { //method that overrides Eukaryote toString() method while also accessing the super method
        return "This fungi has " + mushrooms + " mushrooms and occupies " + area + " square meters of land.\n" + super.toString();
    }
}
