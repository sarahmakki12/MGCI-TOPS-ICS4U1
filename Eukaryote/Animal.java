/*Animal Parent Class
Mr. Jay
ICS4U1-02
Sarah Ali
March 2020*/

package com.company;

public class Animal extends Eukaryote {
    protected String eats; //protected variable for diet
    protected int legs; //protected variable for number of legs
    protected boolean onLand; //protected variable for whether it lives on land

    public Animal () { //default constructor
        this("leaves", 4, true); //calls general constructor with default values
    }

    public Animal (String food, int leg, boolean land) { //general constructor
        eats = food;
        legs = leg;
        onLand = land;
        cellWall = "none";
        photosynthetic = false;
    }

    public void reproduce () { //inherited method from abstract parent Eukaryote for reproduction
        System.out.println("This animal has reproduced in a diploid-dominant life cycle.");
    }

    public String toString () { //method that overrides Eukaryote toString() method while also accessing the super method
        return "This animal eats " + eats + ", has " + legs + " legs, and " + (onLand ? "lives" : "does not live") + " on land.\n" + super.toString();
    }
}
