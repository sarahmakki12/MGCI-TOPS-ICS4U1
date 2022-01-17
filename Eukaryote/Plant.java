/*Plants Class
Mr. Jay
ICS4U1-02
Sarah Ali
March 2020*/

package com.company;

public class Plant extends Eukaryote{
    protected boolean woody; //protected variable for whether stem is woody or herbaceous
    protected String clade; //protected variable for clade of plant species

    public Plant () { //default constructor
        this(false, "bryophytes"); //calls general constructor with default values
    }

    public Plant(boolean wood, String clad) { //general constructor
        woody = wood;
        clade = clad;
        cellWall = "cellulose";
        photosynthetic = true;
    }

    public void reproduce () { //inherited method from abstract parent Eukaryote for reproduction
        System.out.println("This plant has reproduced in an alternation of generations life cycle.");
    }

    public String toString () { //method that overrides Eukaryote toString() method while also accessing the super method
        return "This plant is" + (woody ? "" : " not") + " woody and is in the " + clade + " clade.\n" + super.toString();
    }
}
