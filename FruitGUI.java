/*Fruit GUI
Mr. Jay
ICS4U1-02
Sarah Ali
April 2020*/

package com.company;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class FruitGUI extends JFrame implements ChangeListener {
    //data variables
    static int appNum = 20;
    static int oraNum = 20;
    static int banNum = 20;
    static int kiwiNum = 20;
    static int blueNum = 20;
    static int graNum = 20;

    //create/initialize components
    JLabel appLab = new JLabel("Apple");
    JLabel oraLab = new JLabel("Orange");
    JLabel banLab = new JLabel("Banana");
    JLabel kiwiLab = new JLabel("Kiwi");
    JLabel blueLab = new JLabel("Blueberry");
    JLabel graLab = new JLabel("Grapes");

    fruitSlider apple = new fruitSlider();
    fruitSlider orange = new fruitSlider();
    fruitSlider banana = new fruitSlider();
    fruitSlider kiwi = new fruitSlider();
    fruitSlider blueberry = new fruitSlider();
    fruitSlider grapes = new fruitSlider();

    JPanel appPan = new JPanel();
    JPanel oraPan = new JPanel();
    JPanel banPan = new JPanel();
    JPanel kiwiPan = new JPanel();
    JPanel bluePan = new JPanel();
    JPanel graPan = new JPanel();
    JPanel input = new JPanel();

    Graph graph = new Graph();

    public FruitGUI(String title) { //constructor
        super(title);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS)); //create box layout
        input.setLayout(new BoxLayout(input, BoxLayout.Y_AXIS));

        //add components
        appPan.add(appLab);
        appPan.add(apple);
        oraPan.add(oraLab);
        oraPan.add(orange);
        banPan.add(banLab);
        banPan.add(banana);
        kiwiPan.add(kiwiLab);
        kiwiPan.add(kiwi);
        bluePan.add(blueLab);
        bluePan.add(blueberry);
        graPan.add(graLab);
        graPan.add(grapes);
        input.add(appPan);
        input.add(oraPan);
        input.add(banPan);
        input.add(kiwiPan);
        input.add(bluePan);
        input.add(graPan);

        add(input);
        add(graph);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //add listeners and set names
        apple.addChangeListener(this);
        apple.setName("apple");
        orange.addChangeListener(this);
        orange.setName("orange");
        banana.addChangeListener(this);
        banana.setName("banana");
        kiwi.addChangeListener(this);
        kiwi.setName("kiwi");
        blueberry.addChangeListener(this);
        blueberry.setName("blueberry");
        grapes.addChangeListener(this);
        grapes.setName("grapes");
    }

    public void stateChanged(ChangeEvent evt) { //listener method for sliders
        JSlider source = (JSlider) evt.getSource(); //get info from component
        if (!source.getValueIsAdjusting()) { //change data values for sliders
            switch (source.getName()) {
                case "apple":
                    appNum = source.getValue();
                    break;
                case "orange":
                    oraNum = source.getValue();
                    break;
                case "banana":
                    banNum = source.getValue();
                    break;
                case "kiwi":
                    kiwiNum = source.getValue();
                    break;
                case "blueberry":
                    blueNum = source.getValue();
                    break;
                case "grapes":
                    graNum = source.getValue();
                    break;
            }
            repaint(); //repaint to apply paintComponent method
        }
    }

    static class fruitSlider extends JSlider { //slider class
        public fruitSlider() {
            super(JSlider.HORIZONTAL, 0, 40, 20);
            setPreferredSize(new Dimension(200, 50));
            setMajorTickSpacing(5);
            setPaintTicks(true);
            setPaintLabels(true);
            setSnapToTicks(true);
        }
    }

    static class Graph extends JPanel { //custom graphics panel
        public Graph() { //constructor
        }

        public void paintComponent (Graphics g) { //class method that uses Graphics to draw graph
            g.setFont(new Font("SansSerif", Font.BOLD, 20));
            g.drawString("Nicest Fruit", 50, 20);

            g.setFont(new Font("SansSerif", Font.PLAIN, 15));
            g.drawString("40", 0, 50);
            g.drawString("35", 0, 70);
            g.drawString("30", 0, 90);
            g.drawString("25", 0, 110);
            g.drawString("20", 0, 130);
            g.drawString("15", 0, 150);
            g.drawString("10", 0, 170);
            g.drawString("5", 0, 190);
            g.drawString("0", 0, 210);

            g.drawLine(20, 35, 20, 210);
            g.drawLine(20, 210, 200, 210);

            g.setColor(Color.RED);
            g.fillRect(30, 50 + (160 - appNum*4), 20, appNum*4); //bars are drawn using data from sliders
            g.setColor(Color.ORANGE);
            g.fillRect(60, 50 + (160 - oraNum*4), 20, oraNum*4);
            g.setColor(Color.YELLOW);
            g.fillRect(90, 50 + (160 - banNum*4), 20, banNum*4);
            g.setColor(Color.GREEN);
            g.fillRect(120, 50 + (160 - kiwiNum*4), 20, kiwiNum*4);
            g.setColor(Color.BLUE);
            g.fillRect(150, 50 + (160 - blueNum*4), 20, blueNum*4);
            g.setColor(Color.MAGENTA);
            g.fillRect(180, 50 + (160 - graNum*4), 20, graNum*4);

            g.setFont(new Font("SanSerif", Font.PLAIN, 7));
            g.setColor(Color.BLACK);
            g.drawString("Apple", 30, 220);
            g.drawString("Orange", 60, 220);
            g.drawString("Banana", 90, 220);
            g.drawString("Kiwi", 120, 220);
            g.drawString("Blueberry", 140, 220);
            g.drawString("Grapes", 180, 220);
        }
    }

    public static void main(String[] args) {
        FruitGUI frame = new FruitGUI("Nicest Fruit");
        frame.setVisible(true);
        frame.setSize(700, 400);
        frame.setResizable(false);
    }
}