/*String Problems GUI
Mr. Jay
ICS4U1-02
Sarah Ali
April 2020*/

package com.company;

import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class StringProblemsGUI extends JFrame implements ActionListener {
    //create/initialize components
    JLabel alphaLab = new JLabel("Scrambled alphabet:");

    JTextField pal = new JTextField(15);
    JTextField shi = new JTextField(15);
    JTextField code = new JTextField(15);
    JTextField newAlpha = new JTextField(20);

    JButton palBut = new JButton("Palindrome?");
    JButton shiBut = new JButton("Shift");
    JButton codeBut = new JButton("Encode");

    String[] shiftValues = "0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25".split(", ");
    JComboBox shiftValue = new JComboBox(shiftValues);

    JPanel palindrome = new JPanel();
    JPanel shift = new JPanel();
    JPanel encode = new JPanel();
    JPanel alpha = new JPanel();
    JPanel codeIn = new JPanel();

    StringProblemsGUI(String title) { //constructor
        super(title);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS)); //use boy layout for frame and encode
        encode.setLayout(new BoxLayout(encode, BoxLayout.Y_AXIS));

        //add components
        palindrome.add(pal);
        palindrome.add(palBut);
        shift.add(shi);
        shift.add(shiBut);
        shift.add(shiftValue);
        codeIn.add(code);
        codeIn.add(codeBut);
        alpha.add(alphaLab);
        alpha.add(newAlpha);
        encode.add(codeIn); //nested panels
        encode.add(alpha);

        add(palindrome);
        add(shift);
        add(encode);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //add listeners and set commands
        palBut.addActionListener(this);
        palBut.setActionCommand("pal");
        shiBut.addActionListener(this);
        shiBut.setActionCommand("shi");
        codeBut.addActionListener(this);
        codeBut.setActionCommand("code");

        newAlpha.setEditable(false);
    }

    public void actionPerformed(ActionEvent evt) { //listener method for buttons
        switch (evt.getActionCommand()) { //apply methods based on values from components
            case "pal":
                pal.setText(palindrome(pal.getText())); //change text field in response to events
                break;
            case "shi":
                shi.setText(shiftcode(shi.getText(), Integer.parseInt((String) shiftValue.getSelectedItem())));
                break;
            case "code":
                String alpha = alphabet();
                newAlpha.setText(alpha);
                code.setText(cryptocode(code.getText(), alpha));
                break;
        }
    }

    public static String palindrome(String sentence) { //checks if given string is a palindrome ignoring spaces, punctuation and capitalization and returns boolean
        StringBuffer s = new StringBuffer(sentence.toLowerCase()); //convert String to StringBuffer with all lower case letters

        for (int i = 0; i < s.length(); i++) { //check all characters for non-letters
            if (s.charAt(i) < 'a' || s.charAt(i) > 'z') { //remove characters that aren't letters
                s.replace(i, i + 1, "");
                i--; //go back in case there's a consecutive character to be removed
            }
        }

        if (s.toString().contentEquals(s.reverse())) { //check if the string is the same forwards and backwards
            return "true";
        }
        return "false";
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

    public static String alphabet() { //returns string of shuffled alphabet
        char[] alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        Random r = new Random();

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

    public static void main(String[] args) {
        StringProblemsGUI frame = new StringProblemsGUI("String Problems");
        frame.setVisible(true);
        frame.setSize(500, 200);
        frame.setResizable(false);
    }
}
