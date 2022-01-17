/*Array Class Driver
Mr. Jay
ICS4U1-02
Sarah Ali
April 2020*/

package com.company;

import java.io.*;
import java.util.*;

public class ArrayDriver_SA {
    static Scanner in = new Scanner(System.in);
    static Array list = new Array();

    public static void Initialize() throws FileNotFoundException {
        int choice;

        System.out.println("How do you want to enter the names:");
        System.out.println();
        System.out.println("1 - By Text File");
        System.out.println("2 - Manual Entry");
        choice = in.nextInt();
        System.out.println();

        if (choice == 1) {
            System.out.println("Enter the full url of the text file: ");
            in.nextLine();
            String text = in.nextLine();
            list = new Array(text);
        } else if (choice == 2) {
            in.nextLine();
            list.enter();
        }
    }

    public static void Add() {
        System.out.print("Enter the name you wish to add: ");
        in.nextLine();
        String name = in.nextLine();
        list.add(name);
        list.print();
    }

    public static void Remove() {
        System.out.print("Enter the number you wish to remove from the list: ");
        int item = in.nextInt();
        list.remove(item);
        list.print();
    }

    public static void Search() {
        System.out.print("Enter the surname or the first letter of the surname: ");
        in.nextLine();
        String search = in.nextLine();

        Array searchedList = search.length() == 1 ? list.search(search.charAt(0)) : list.search(search);
        searchedList.print();
    }

    public static void main(String[] args) throws FileNotFoundException {
        int choice;

        Initialize();
        System.out.println();

        do {
            System.out.println("Enter a number to manipulate the list:");
            System.out.println();
            System.out.println("1 - Re-enter names");
            System.out.println("2 - Sort names");
            System.out.println("3 - Add a name");
            System.out.println("4 - Remove a name");
            System.out.println("5 - Search for names by surname");
            System.out.println("6 - View list of names");
            System.out.println("Enter 0 to quit");
            choice = in.nextInt();
            System.out.println();

            if (choice == 1) {
                Initialize();
            } else if (choice == 2) {
                list.sort();
                list.print();
            } else if (choice == 3) {
                Add();
            } else if (choice == 4) {
                Remove();
            } else if (choice == 5) {
                Search();
            } else if (choice == 6) {
                list.print();
            }

            System.out.println();
            System.out.println("Press enter to continue.");
            in.nextLine();
            in.nextLine();
        }
        while (choice != 0);

        System.out.println("The program has ended");
    }
}
