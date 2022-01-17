/*Deck GUI
Mr. Jay
ICS4U1-02
Sarah Ali
April 2020*/

package com.company;

import java.awt.*;
import javax.imageio.*;
import java.io.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

class DeckGUI extends JFrame implements ActionListener {
    //create/initialize components
    static Deck deck = new Deck();

    JButton shuffleBtn = new JButton("Shuffle");
    JButton sortRankBtn = new JButton("Sort Rank");
    JButton sortSuitBtn = new JButton("Sort Suit");
    JButton dealBtn = new JButton("Deal");
    JButton addBtn = new JButton("Add");
    JButton searchBtn = new JButton("Search");

    JComboBox positions;
    String[] suits = {"S", "H", "C", "D"};
    JComboBox suit = new JComboBox(suits);
    String[] ranks = "2 3 4 5 6 7 8 9 10 J Q K A".split(" ");
    JComboBox rank = new JComboBox(ranks);

    JLabel searchResults = new JLabel("Search Results:");

    JTextField results = new JTextField(40);

    JPanel north = new JPanel();
    JPanel center = new JPanel();

    DrawArea board = new DrawArea(600, 400);

    public DeckGUI(String title) { //constructor
        super(title);
        setLayout(new BorderLayout());
        north.setLayout(new FlowLayout());

        //add positions 1-52 to combo box
        String[] posns = new String[deck.size()];
        for (int i = 1; i <= deck.size(); i++) {
            posns[i - 1] = String.valueOf(i);
        }
        positions = new JComboBox(posns);

        //add components
        north.add(shuffleBtn);
        north.add(sortRankBtn);
        north.add(sortSuitBtn);
        north.add(dealBtn);
        north.add(positions);
        north.add(addBtn);
        north.add(searchBtn);
        north.add(suit);
        north.add(rank);

        center.add(searchResults);
        center.add(results);

        add(north, "North"); // Input area
        add(center, "Center");
        add(board, "South"); // Deck display area

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //add action listeners
        shuffleBtn.addActionListener(this);
        sortRankBtn.addActionListener(this);
        sortSuitBtn.addActionListener(this);
        dealBtn.addActionListener(this);
        addBtn.addActionListener(this);
        searchBtn.addActionListener(this);

        results.setEditable(false);
    }

    public void actionPerformed(ActionEvent e) { //listener method for buttons
        switch (e.getActionCommand()) { //apply methods based on action command
            case "Shuffle":
                deck.shuffle(); // shuffle deck
                break;
            case "Sort Rank":
                deck.quickSort(0, deck.size() - 1); // sort deck by rank
                break;
            case "Sort Suit":
                deck.selectionSort(); //sort deck by suit and rank
                break;
            case "Deal":
                deck.deal(positions.getSelectedIndex()); //deal selected card and remove from deck
                break;
            case "Add":
                deck.add(rank.getSelectedIndex(), suit.getSelectedIndex()); //add chosen card
                break;
            case "Search":
                results.setText(deck.search(rank.getSelectedIndex(), suit.getSelectedIndex())); //search for all positions of chosen card
                break;
        }
        repaint(); // do after each action taken to update deck
    }

    static class DrawArea extends JPanel { //custom drawing area
        public DrawArea(int width, int height) {
            this.setPreferredSize(new Dimension(width, height)); // size
        }

        public void paintComponent(Graphics g) {
            deck.show(g);
        }
    }

    public static void main(String[] args) {
        DeckGUI window = new DeckGUI("Deck Demo");
        window.setVisible(true);
        window.setSize(650, 500);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
    }
}

class Card {
    int rank, suit;
    private Image image;
    private final boolean faceup;
    private static Image cardback; // shared image for back of card

    public Card() { //Card constructor for face down card
        faceup = false;

        try {
            cardback = ImageIO.read(new File("C:\\Users\\sarah\\Downloads\\Deck Demo\\cards/b.gif")); // load file into Image object
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }

    public Card(int cardNum)  // Creates card from 0-51
    {
        rank = cardNum % 13;
        suit = cardNum / 13;
        faceup = true;

        image = null;
        try {
            image = ImageIO.read(new File("C:\\Users\\sarah\\Downloads\\Deck Demo\\cards/" + (cardNum + 1) + ".gif")); // load file into Image object
            cardback = ImageIO.read(new File("C:\\Users\\sarah\\Downloads\\Deck Demo\\cards/b.gif")); // load file into Image object
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }

    public void show(Graphics g, int x, int y)  // draws card face up or face down
    {
        if (faceup)
            g.drawImage(image, x, y, null);
        else
            g.drawImage(cardback, x, y, null);

    }
}

class Deck {
    private final ArrayList<Card> deck;
    Card dealed = new Card();

    public Deck() { //constructor for deck
        deck = new ArrayList<>();
        for (int x = 0; x < 52; x++)  // for each card in standard deck
        {
            deck.add(new Card(x)); // create card
        }
    }

    public void show(Graphics g)  // draws card face up or face down
    {
        for (int c = 0; c < deck.size(); c++) {
            deck.get(c).show(g, c % 13 * 20 + 175, c / 13 * 50 + 20);
        }
        dealed.show(g, 75, 20); //shows dealed card in corner
    }

    public void shuffle() { //shuffles cards by randomly switching cards
        Random r = new Random();
        for (int i = deck.size() - 1; i > 0; i--) {
            int j = r.nextInt(i + 1);
            Card temp = deck.get(i);
            deck.set(i, deck.get(j));
            deck.set(j, temp);
        }
    }

    public void quickSort(int low, int high) { //sorts cards by rank disregarding suit using quick sort algorithm
        if (low < high) {
            //place pivot in correct location
            int pivot = partition(low, high);

            //sort elements before and after pivot point
            quickSort(low, pivot - 1);
            quickSort(pivot + 1, high);
        }
    }

    public int partition(int low, int high) { //partition method for quicksort algorithm
        int pivot = deck.get(high).rank;
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (deck.get(j).rank < pivot) {
                i++;

                //swaps card if smaller than pivot point
                Card temp = deck.get(i);
                deck.set(i, deck.get(j));
                deck.set(j, temp);
            }
        }

        //places pivot point (last card) in correct position
        Card temp = deck.get(i + 1);
        deck.set(i + 1, deck.get(high));
        deck.set(high, temp);

        return i + 1;
    }

    public void selectionSort() { //sorts cards by rank and suit using selection sort algorithm
        int n = deck.size();
        for (int i = 0; i < n - 1; i++) { //move boundary of unsorted array
            int min = i;
            for (int j = i + 1; j < n; j++) { //find smallest card rank
                if (deck.get(j).suit < deck.get(min).suit || (deck.get(j).suit == deck.get(min).suit && deck.get(j).rank < deck.get(min).rank)) {
                    min = j;
                }
            }

            //swap smallest card rank with first index in unsorted array
            Card temp = deck.get(min);
            deck.set(min, deck.get(i));
            deck.set(i, temp);
        }
    }

    public void deal(int posn) { //deals card and removes it from deck
        if (posn < deck.size()) {
            dealed = deck.get(posn);
            deck.remove(posn);
        }
    }

    public void add(int rank, int suit) { //adds card to deck
        if (deck.size() < 52) {
            deck.add(new Card(rank + suit * 13));
        }
    }

    public String search(int rank, int suit) { //searches for all positions of card in deck
        ArrayList<Integer> found = new ArrayList<>();
        for (int i = 0; i < deck.size(); i++) {
            if (deck.get(i).rank == rank && deck.get(i).suit == suit) {
                found.add(i + 1); //adds position of cards to list of positions if cards match
            }
        }

        String results = "";
        for (Integer integer : found) {
            results += integer + " "; //converts array of integer positions to string of results
        }

        return results;
    }

    public int size() { //access method for deck size
        return deck.size();
    }
}