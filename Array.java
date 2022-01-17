/*Array Class
Mr. Jay
ICS4U1-02
Sarah Ali
April 2020*/

package com.company;

import java.io.*;
import java.util.*;

public class Array {
    private String array[]; //private array of names

    public Array() { //constructor that creates empty list
    }

    public Array(String file) throws FileNotFoundException { //constructor that fills array with names from file
        File text = new File(file); //create File for text file
        Scanner sc = new Scanner(text); //create Scanner to read File

        String names = "";
        while (sc.hasNextLine()) { //reads all names in file and add to string of names
            names += sc.nextLine() + "!";
        }

        array = names.split("!"); //set array equal to array of names from String
    }

    public Array(String[] arr) { //constructor that fills array with names from another array
        array = arr;
    }

    public void enter() { //method that reads in names from user using sentinel-controlled while loop
        Scanner sc = new Scanner(System.in);
        String name = "", names = "";

        System.out.println("Enter names (q to quit): ");
        while (!name.equals("q")) { //stops reading names when user enter "q" to quit
            name = sc.nextLine();
            names += name.equals("q") ? "" : name + "!"; //add name to string of names
        }

        array = names.split("!"); //set array equal to array of names from String
    }

    public void print() { //method that displays numbered list of names
        if (array.length > 0) { //list not empty
            int num = 1;
            for (String name : array) { //enhanced for loop for all names in array
                System.out.println(num + ". " + name);
                num++;
            }
        }
    }

    public Array search(char surname) { //method that searches for name by first letter of surname
        String names = "";

        for (String name : array) { //enhanced for loop searches all names in array
            if (name.charAt(0) == surname) { //checks if first letter of surname matches
                names += name + "!"; //adds name to string of names
            }
        }

        return new Array(names.split("!")); //set array equal to array of names from String
    }

    public Array search(String surname) {
        String names = "";

        for (String name : array) { //enhanced for loop searches all names in array
            if (name.substring(0, name.indexOf(',')).equals(surname)) { //checks if surnames match
                names += name + "!"; //adds name to string of names
            }
        }

        return new Array(names.split("!")); //set array equal to array of names from String
    }

    public void add(String name) { //method that adds name to end of list
        String[] temp = new String[array.length + 1]; //create new resized list

        for (int i = 0; i < array.length; i++) {
            temp[i] = array[i]; //fill temporary array with first terms from array
        }
        temp[array.length] = name; //adds name to end of list

        array = temp; //set array equal to new list
    }

    public void remove(int id) { //accepts position to be removed and resizes list to remove name
        id--; //adjust list number to index number

        String[] temp = new String[array.length - 1]; //create new resized list

        int num = 0;
        for (int i = 0; i < temp.length; i++) { //fills list with all names from old list except removed name
            if (num == id) {
                num++;
            }
            temp[i] = array[num];
            num++;
        }

        array = temp; //set array equal to new list
    }

    public void sort() { //puts the list in alphabetical order
        String temp;
        for (int x = 0; x < array.length - 1; x++) // sort first length-1 values
        {
            int lowPos = x; // assume first value is first alphabetically

            for (int y = x + 1; y < array.length; y++) // check rest of list
            {
                if (array[y].compareTo(array[lowPos]) < 0) // if you find an alphabetically higher name
                    lowPos = y; // keep track of lowest's position
            }

            temp = array[x]; // swap low value with value in its proper position
            array[x] = array[lowPos];
            array[lowPos] = temp;
        }
    }
}
