/*Inheritance Demonstration
Mr. Jay
ICS4U1-02
Sarah Ali
March 2020*/

package com.company;

public class InheritanceDemo_SA {
    public static void main (String[] args) {
        Eukaryote organism = new Plant(); //Polymorphism with Eukaryote abstract class
        organism.reproduce();

        organism = new Animal();
        organism.reproduce();

        organism = new Fungi();
        organism.reproduce();

        organism = new Cat();
        organism.reproduce();

        Object obj = new Cat(); //Polymorphism with Object class
        ((Cat)obj).reproduce(); //Type casting

        System.out.println();

        Pet pet = new Cat("kibble", "black", 9); //Interface pet used as data type
        pet.Feed();
        System.out.println(((Cat)pet).toString());

        System.out.println();

        //demonstrating different classes

        Fungi breadMold = new Fungi();
        Fungi puffBall = new Fungi(3, 4.5);
        System.out.println("Puff Ball: " + puffBall);

        System.out.println();

        Plant moss = new Plant();
        Plant pine = new Plant(true, "gymnosperms");
        System.out.println("Pine: " + pine);

        System.out.println();

        Animal deer = new Animal();
        Animal orca = new Animal ("penguins", 0, false);
        System.out.println("Orca: " + orca);

        System.out.println();

        Cat fluffy = new Cat();
        Cat chat = new Cat ("white", 5);
        Cat kitty = new Cat("meat", "yellow", 3);
        System.out.println("Cat: " + kitty);
        //demonstrating interface methods with cat
        kitty.Feed();
        kitty.Gifts();
    }
}
