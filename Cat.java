/*Cat Subclass
Mr. Jay
ICS4U1-02
Sarah Ali
March 2020*/

package com.company;

public class Cat extends Animal implements Pet, Hunter {
    private String colour; //private instance variable for colour
    private int lives; //private instance variable for number of lives

    public Cat () { //default constructor
        super("milk", 4, true); //calls super constructor with default values
        colour = "gray"; //sets default values
        lives = 9;
    }

    public Cat (String col, int liv) { //general constructor
        super("milk", 4, true); //calls super constructor with default values
        colour = col; //sets values
        lives = liv;
    }

    public Cat (String food, String col, int liv) { //another general constructor
        super(food, 4, true); //calls super constructor with values
        colour = col; //sets values
        lives = liv;
    }

    public void Feed () { //implements method and uses constant definition from Pet interface
        System.out.println("You feed " + name + " " + eats + ".");
    }

    public void Gifts () { //implements method from Hunter interface and uses constant definition from Pet and Hunter interface
        System.out.println(name + " has brought you " + kills + " dead animals.");
    }

    public String toString () { ////method that overrides Animal toString() method while also accessing the super method
        return "This cat is " + colour + " and has " + lives + " lives left.\n" + super.toString();
    }
}
