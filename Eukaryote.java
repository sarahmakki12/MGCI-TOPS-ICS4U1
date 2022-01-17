/*Eukaryote Abstract Class
Mr. Jay
ICS4U1-02
Sarah Ali
March 2020*/

package com.company;

abstract class Eukaryote {
    String cellWall; //variable for material of cell walls
    boolean photosynthetic; //variable for whether its photosynthetic

    public abstract void reproduce (); //abstract reproduction method

    public String toString() { //method that overrides Object toString() method
        return "It has " + (cellWall.equals("none") ? "no" : cellWall) + " cell walls and it is" + (photosynthetic ? "" : " not") + " photosynthetic.";
    }
}
