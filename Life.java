/*Conway's Game of Life Class
Mr. Jay
ICS4U1-02
Sarah Ali
May 2020*/

package com.company;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.event.*;

public class Life extends JFrame implements ActionListener, ChangeListener {

    //create/initialize components
    static Colony colony = new Colony(0.5);
    static Timer t;

    JButton simulateBtn = new JButton("Simulate");
    JButton popBtn = new JButton("Populate");
    JButton eraBtn = new JButton("Eradicate");
    JButton loadBtn = new JButton("Load");
    JButton saveBtn = new JButton("Save");

    JComboBox<String> xPos;
    JComboBox<String> yPos;
    JComboBox<String> size;

    JLabel xLabel = new JLabel("x:");
    JLabel yLabel = new JLabel("y:");
    JLabel sizeLabel = new JLabel("size:");
    JLabel address = new JLabel("File Name: ");

    JTextField fileName = new JTextField(20);

    static JSlider speedSldr = new JSlider();

    JPanel population = new JPanel();
    JPanel files = new JPanel();
    JPanel north = new JPanel();

    DrawArea board = new DrawArea(500, 500);

    //======================================================== constructor
    public Life(String title) {
        super(title);
        setLayout(new BorderLayout());
        north.setLayout(new BorderLayout());
        population.setLayout(new FlowLayout());
        files.setLayout(new FlowLayout());

        //add values for x-position, y-position, and size
        String[] gridSize = new String[100];
        for (int i = 0; i < 100; i++) {
            gridSize[i] = String.valueOf(i);
        }
        xPos = new JComboBox<>(gridSize);
        yPos = new JComboBox<>(gridSize);
        size = new JComboBox<>(gridSize);

        //add components
        population.add(simulateBtn);
        population.add(speedSldr);
        population.add(popBtn);
        population.add(eraBtn);
        population.add(xLabel);
        population.add(xPos);
        population.add(yLabel);
        population.add(yPos);
        population.add(sizeLabel);
        population.add(size);

        files.add(address);
        files.add(fileName);
        files.add(loadBtn);
        files.add(saveBtn);

        north.add(population, "North");
        north.add(files, "South");

        add(north, "North");
        add(board, "South");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //add action and change listeners
        simulateBtn.addActionListener(this);
        popBtn.addActionListener(this);
        eraBtn.addActionListener(this);
        loadBtn.addActionListener(this);
        saveBtn.addActionListener(this);
        speedSldr.addChangeListener(this);
    }

    public void stateChanged(ChangeEvent e) {
        if (t != null) {
            t.setDelay(400 - 4 * speedSldr.getValue()); // 0 to 400 ms
        }
    }

    public void actionPerformed(ActionEvent e) { //listener method for buttons
        switch (e.getActionCommand()) {
            case "Simulate":
                Movement moveColony = new Movement(colony); // ActionListener
                t = new Timer(200, moveColony); // set up timer
                t.start(); // start simulation
                break;
            case "Populate": //populate area in certain location
                colony.populate(yPos.getSelectedIndex(), xPos.getSelectedIndex(), size.getSelectedIndex());
                break;
            case "Eradicate": //eradicate area in certain location
                colony.eradicate(yPos.getSelectedIndex(), xPos.getSelectedIndex(), size.getSelectedIndex());
                break;
            case "Load": //load colony data from file
                try {
                    colony.load(fileName.getText());
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
                break;
            case "Save": //save colony data to file
                try {
                    colony.save(fileName.getText());
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
                break;
        }
        repaint();
    }

    static class DrawArea extends JPanel { //custom drawing area
        public DrawArea(int width, int height) {
            this.setPreferredSize(new Dimension(width, height)); // size
        }

        public void paintComponent(Graphics g) {
            colony.show(g);
        }
    }

    class Movement implements ActionListener { //advances colony
        private final Colony colony;

        public Movement(Colony col) {
            colony = col;
        }

        public void actionPerformed(ActionEvent event) {
            colony.advance();
            repaint();
        }
    }

    //======================================================== method main
    public static void main(String[] args) {
        Life window = new Life("Life Simulation Demo");
        window.setVisible(true);
        window.setSize(700, 620);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
    }
}

class Colony {
    private boolean[][] grid;

    public Colony(double density) { //constructor for random colony with given density
        grid = new boolean[100][100];
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                grid[row][col] = Math.random() < density;
            }
        }
    }

    public void show(Graphics g) { //displays colony in drawing area
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col]) {// life
                    g.setColor(Color.black);
                } else {
                    g.setColor(Color.white);
                }
                g.fillRect(col * 5 + 2, row * 5 + 2, 5, 5); // draw life form
            }
        }
    }

    public boolean live(int row, int col) { //determines if an existing cell in the given location will live or die
        int alive = 0; //counter for number of living neighbours
        for (int i = row - 1; i <= row + 1; i++) { //checks for number of living neighbours
            for (int j = col - 1; j <= col + 1; j++) {
                try {
                    if (i != row && j != col && grid[i][j]) {
                        alive++;
                    }
                } catch (ArrayIndexOutOfBoundsException ignored) {
                }
            }
        }

        return alive == 3 || grid[row][col] && alive == 2; //returns status according to rules
    }

    public void advance() {
        boolean[][] nextGen = new boolean[grid.length][grid[0].length]; // create next generation of life forms
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                nextGen[row][col] = live(row, col); // determine life/death status
            }
        }
        grid = nextGen; // update life forms
    }

    public void populate(int row, int col, int size) { //populates given area
        for (int i = row - size; i <= row + size; i++) {
            for (int j = col - size; j <= col + size; j++) {
                if (Math.random() < 0.8) { //80% chance of success
                    try {
                        grid[i][j] = true;
                    } catch (ArrayIndexOutOfBoundsException ignored) {
                    }
                }
            }
        }
    }

    public void eradicate(int row, int col, int size) { //eradicates given area
        for (int i = row - size; i <= row + size; i++) {
            for (int j = col - size; j <= col + size; j++) {
                if (Math.random() < 0.8) { //80% chance of success
                    try {
                        grid[i][j] = false;
                    } catch (ArrayIndexOutOfBoundsException ignored) {
                    }
                }
            }
        }
    }

    public void save(String name) throws FileNotFoundException { //saves colony data to given file
        PrintWriter out = new PrintWriter("C:\\Users\\Public\\Documents/" + name + ".txt"); //prints to given file

        for (boolean[] booleans : grid) { //loops through entire colony
            for (boolean aBoolean : booleans) {
                out.print(aBoolean ? 1 + " " : 0 + " "); //enters 1 for living cells and 0 for dead cells
            }
            out.println();
        }

        out.close(); //ends printing
    }

    public void load(String name) throws FileNotFoundException { //loads colony data from given file
        //read data from input file
        File text = new File("C:\\Users\\Public\\Documents/" + name + ".txt");
        Scanner sc = new Scanner(text);

        //fill grid with data from file
        int rowNum = 0;
        while (sc.hasNextLine()) {
            String[] key = sc.nextLine().split(" ");
            for (int i = 0; i < key.length; i++) {
                try {
                    grid[rowNum][i] = Integer.parseInt(key[i]) == 1; //read 1 as a living cell, 0 (or any other number) as a dead cell
                } catch (ArrayIndexOutOfBoundsException ignored) {
                }
            }
            rowNum++;
        }
    }
}


