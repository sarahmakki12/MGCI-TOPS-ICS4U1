/*Map Maker Class
Mr. Jay
ICS4U1-02
Sarah Ali
May 2020*/

package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class MapMaker extends JFrame implements ActionListener {

    //create/initialize components
    Map map = new Map(40, 30, 20, 20);

    JButton searchBtn = new JButton("Search");
    JButton saveBtn = new JButton("Save");
    JButton loadBtn = new JButton("Load");

    JComboBox<String> itemBox;

    JLabel itemCount = new JLabel("# of items:");

    JTextField searchResult = new JTextField(4);

    JFileChooser file = new JFileChooser("C:\\Users\\Public\\Documents");

    JPanel north = new JPanel();

    DrawArea board = new DrawArea(800, 600);

    //======================================================== constructor
    public MapMaker(String title) {
        super(title);
        setLayout(new BorderLayout());
        north.setLayout(new FlowLayout());

        //add items to itemBox
        String[] list = {"Space", "Wall", "Treasure", "Door", "Key", "Monster"};
        itemBox = new JComboBox<>(list);

        //add components
        north.add(searchBtn);
        north.add(itemCount);
        north.add(searchResult);
        north.add(saveBtn);
        north.add(loadBtn);
        north.add(itemBox);

        add(north, "North");
        add(board, "Center");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //add action listeners
        searchBtn.addActionListener(this);
        saveBtn.addActionListener(this);
        loadBtn.addActionListener(this);

        searchResult.setEditable(false);
    }

    public void actionPerformed(ActionEvent e) { //listener method for buttons
        switch (e.getActionCommand()) {
            case "Search": //search for number of given items
                itemCount.setText("# of " + itemBox.getSelectedItem() + "s: ");
                searchResult.setText(String.valueOf(map.search((String) Objects.requireNonNull(itemBox.getSelectedItem())))); // search for and count items
                break;
            case "Save": //save map data to file
                // get file from JFileChooser
                file.showSaveDialog(null);
                try {
                    map.save(file.getSelectedFile()); // save map
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
                break;
            case "Load": //load map data from file
                // get file from JFileChooser
                file.showSaveDialog(null);
                try {
                    map.load(file.getSelectedFile()); // load map
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
                break;
        }
        repaint();
    }

    class DrawArea extends JPanel implements MouseListener { //custom drawing area
        public DrawArea(int width, int height) {
            this.setPreferredSize(new Dimension(width, height)); // size
            addMouseListener(this);
        }

        public void paintComponent(Graphics g) {
            map.print(g);
        }

        // Must implement all methods from listener
        public void mousePressed(MouseEvent e) {
        }

        public void mouseReleased(MouseEvent e) {
        }

        public void mouseEntered(MouseEvent e) {
        }

        public void mouseExited(MouseEvent e) {
        }

        public void mouseClicked(MouseEvent e) { //allows user to add items to map by clicking
            System.out.println(e.getX() + ", " + e.getY());
            char value = ' ';
            switch ((String) Objects.requireNonNull(itemBox.getSelectedItem())) { //translate item to char
                case "Space":
                    value = ' ';
                    break;
                case "Wall":
                    value = 'W';
                    break;
                case "Treasure":
                    value = 'T';
                    break;
                case "Door":
                    value = 'D';
                    break;
                case "Key":
                    value = 'K';
                    break;
                case "Monster":
                    value = 'M';
                    break;
            }
            map.add(e.getX(), e.getY(), value); //adds item to map
            repaint();
        }
    }

    //======================================================== method main
    public static void main(String[] args) {
        MapMaker window = new MapMaker("Map Maker");
        window.setVisible(true);
        window.setSize(850, 700);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
    }
}

class Map {
    private final char[][] map;
    private final int width, height;

    public Map(int cols, int rows, int blockwidth, int blockheight) // set up default map
    {
        width = blockwidth;
        height = blockheight;
        map = new char[rows][cols]; // define 2-d array size

        for (int row = 0; row < rows; row++)
            for (int col = 0; col < cols; col++) {
                if (row == 0 || row == rows - 1 || col == 0 || col == cols - 1)
                    map[row][col] = 'W'; // put up a wall
                else
                    map[row][col] = ' '; // blank space
            }
        map[rows - 1][cols / 2] = 'D'; // make a door
        map[rows - 1][cols / 2 + 1] = 'D';
    }

    public void print(Graphics g)  // displays the map on the screen
    {
        for (int row = 0; row < map.length; row++)// number of rows
        {
            for (int col = 0; col < map[0].length; col++)// length of first row
            {
                if (map[row][col] == 'W') // wall
                    g.setColor(Color.black);
                else if (map[row][col] == 'D') // door
                    g.setColor(Color.red);
                else if (map[row][col] == 'M') // monster
                    g.setColor(Color.green);
                else if (map[row][col] == 'T') // treasure
                    g.setColor(Color.yellow);
                else if (map[row][col] == 'K') // key
                    g.setColor(Color.blue);
                else if (map[row][col] == ' ') // space will erase what was there
                    g.setColor(Color.white);
                g.fillRect(col * width, row * height, width, height); // draw block
            }
        }
    }

    public void add(int x, int y, char item) { //adds item to map
        if (y / height == 0) { //adds whole column of walls when top row is clicked
            for (int i = 0; i < map.length; i++) {
                map[i][x / width] = 'W';
            }
        } else if (x / width == 0) { //adds whole row of walls when left column is clicked
            Arrays.fill(map[y / height], 'W');
        } else {
            map[y / height][x / width] = item;
        }
    }

    public void save(File file) throws FileNotFoundException {
        PrintWriter out = new PrintWriter(file); //prints to given file

        for (char[] chars : map) { //loops through entire map
            for (char aChar : chars) {
                out.print(aChar); //enters item from map
            }
            out.println();
        }

        out.close(); //ends printing
    }

    public void load(File file) throws FileNotFoundException {
        //read data from input file
        Scanner sc = new Scanner(file);

        //fill map with data from file
        int rowNum = 0;
        while (sc.hasNextLine()) {
            String key = sc.nextLine();
            for (int i = 0; i < key.length(); i++) {
                try {
                    map[rowNum][i] = key.charAt(i);
                } catch (ArrayIndexOutOfBoundsException ignored) {
                }
            }
            rowNum++;
        }
    }

    public int search(String item) {
        char value = ' ';
        switch (item) { //translate item to char
            case "Space":
                value = ' ';
                break;
            case "Wall":
                value = 'W';
                break;
            case "Treasure":
                value = 'T';
                break;
            case "Door":
                value = 'D';
                break;
            case "Key":
                value = 'K';
                break;
            case "Monster":
                value = 'M';
                break;
        }

        int count = 0; //accumulator for number of items
        for (char[] chars : map) { //loop through entire map
            for (char aChar : chars) {
                if (aChar == value) {
                    count++; //increment accumulator for item found
                }
            }
        }
        return count;
    }
}
