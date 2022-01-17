/*String Methods
Mr. Jay
ICS4U1-02
Sarah Ali
Feb 2020*/

package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class StringMethods_SA {
    static Scanner in = new Scanner(System.in);
    static Random r = new Random();

    public static boolean palindrome(String sentence) { //checks if given string is a palindrome ignoring spaces, punctuation and capitalization and returns boolean
        StringBuffer s = new StringBuffer(sentence.toLowerCase()); //convert String to StringBuffer with all lower case letters

        for (int i = 0; i < s.length(); i++) { //check all characters for non-letters
            if (s.charAt(i) < 'a' || s.charAt(i) > 'z') { //remove characters that aren't letters
                s.replace(i, i + 1, "");
                i--; //go back in case there's a consecutive character to be removed
            }
        }

        return s.toString().contentEquals(s.reverse()); //check if the string is the same forwards and backwards
    }

    public static void Palindrome() { //Outputs whether entered string is a palindrome
        System.out.print("Enter a string: ");
        in.nextLine();
        String sentence = in.nextLine();

        if (palindrome(sentence)) { //checks if sentence is a palindrome and outputs result
            System.out.println(sentence + " is a palindrome");
        } else {
            System.out.println(sentence + " is NOT a palindrome");
        }
    }

    public static String shiftcode(String sentence, int shift) { //returns string with shifted letters
        StringBuffer s = new StringBuffer(sentence.toUpperCase()); //convert String to StringBuffer with all upper case letters

        for (int i = 0; i < s.length(); i++) { //goes through all characters
            char letter = s.charAt(i);

            if (letter >= 'A' && letter <= 'Z') { //if character is a letter
                letter += shift; //shifts letter by shift value
                if (letter > 'Z') { //wraps around to the end of the alphabet if at the end of the alphabet
                    letter = (char) ('A' + (letter - 'Z' - 1));
                }
                s.setCharAt(i, letter); //replaces letter with new shifted letter
            }
        }

        return s.toString(); //converts StringBuffer back to String
    }

    public static void ShiftCode() { //Outputs string with all letters shifted by shift value
        System.out.print("Enter a string: ");
        in.nextLine();
        String sentence = in.nextLine();
        System.out.print("Enter the shift: ");
        int shift = in.nextInt();

        System.out.println(sentence + " shifted by " + shift + " is " + shiftcode(sentence, shift)); //Outputs shifted sentence
    }

    public static String alphabet() { //returns string of shuffled alphabet
        char[] alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

        for (int i = 25; i > 0; i--) { //shuffles alphabet by randomly switching letters
            int j = r.nextInt(i + 1);
            char temp = alpha[i];
            alpha[i] = alpha[j];
            alpha[j] = temp;
        }

        return new String(alpha); //returns shuffled alphabet as a String
    }

    public static String cryptocode(String sentence, String alpha) { //Returns string encoded with shuffled alphabet
        StringBuffer s = new StringBuffer(sentence.toUpperCase()); //convert String to StringBuffer with all upper case letters
        String realAlpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        for (int i = 0; i < s.length(); i++) { //Goes through every character in the string
            if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') { //Checks if character is a letter
                char newLetter = alpha.charAt(realAlpha.indexOf(s.charAt(i))); //replaces letter with letter from scrambled alphabet
                s.setCharAt(i, newLetter); //replaces letter with encoded letter
            }
        }

        return s.toString(); //converts StringBuffer back to String
    }

    public static void CryptoCode() { //Outputs string encoded with scrambled alphabet
        System.out.print("Enter a string: ");
        in.nextLine();
        String sentence = in.nextLine();
        String alpha = alphabet(); //obtains scrambled alphabet

        System.out.println(sentence + " with scrambled alphabet " + alpha + " becomes " + cryptocode(sentence, alpha)); //Outputs encoded string using scrambled alphabet
    }

    public static String secretcode(Scanner sc) { //Decodes secret message in text file given scanner
        String key = sc.nextLine(); //Takes key phrase in first line

        String msg = "";
        while (sc.hasNextInt()) { //Reads all integers in file
            int code = sc.nextInt();
            msg += key.charAt(code); //Adds to message from key phrase using code integer
        }

        return msg;
    }

    public static void SecretCode() throws FileNotFoundException { //Outputs secret message in text file
        File text = new File("C:\\Users\\Public\\Documents/secretFile.txt"); //create File for text file
        Scanner sc = new Scanner(text); //create Scanner to read File

        System.out.println(secretcode(sc)); //Outputs secret message
    }

    public static void main(String[] args) throws FileNotFoundException {
        int choice;

        do {
            System.out.println("Enter a number to display a program:");
            System.out.println();
            System.out.println("1 - Palindrome");
            System.out.println("2 - Shift Code");
            System.out.println("3 - Crypto Code");
            System.out.println("4 - Secret Code");
            System.out.println("Enter 0 to quit");
            choice = in.nextInt();
            System.out.println();

            if (choice == 1) {
                Palindrome();
            } else if (choice == 2) {
                ShiftCode();
            } else if (choice == 3) {
                CryptoCode();
            } else if (choice == 4) {
                SecretCode();
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