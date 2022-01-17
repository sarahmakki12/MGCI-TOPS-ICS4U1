package com.company;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class MyFrame extends JFrame implements ActionListener, ChangeListener {

    MyFrame(String title) {
        super(title);
        setLayout(new FlowLayout());

        JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);
        slider.setMajorTickSpacing(10);
        slider.setMinorTickSpacing(5);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setSnapToTicks(false);
        slider.setPreferredSize(new Dimension(200, 50));
        add(slider);
        slider.addChangeListener((ChangeListener) this);
        slider.setName("slider");
        slider.setInverted(true);

        /*

        JPanel panel = new JPanel();
        panel.add(label);
        JPanel biggerPanel = new JPanel();
        biggerPanel.setLayout(new BoxLayout(biggerPanel, BoxLayout.Y_AXIS));
        biggerPanel.add(panel);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        add(biggerPanel);

        setTitle("Calories from Fat");
        setLayout(new FlowLayout());
        add(heading);
        add(fatLabel);
        add(inFat);
        add(calLabel);
        add(inCal);
        add(perLabel);
        add(outPer);
        outPer.setEditable(false);
        add(doit);
        doit.addActionListener(this);

        inFahr.addActionListener(this);
        outCel.setEditable(false);
        add(heading);
        add(inLabel);
        add(outLabel);
        add(inFahr);
        add(outCel);

        add(new JLabel("Enter your name: "));
        text = new JTextField(10);
        add(text);
        text.addActionListener(this);
        add(new JLabel("You're: "));
        copy = new JTextField(10);
        add(copy);
        copy.setEditable(false);

        JButton red = new JButton("Red");
        add(red);
        red.addActionListener(this);
        red.setActionCommand("Red");
        JButton green = new JButton("Green");
        add(green);
        green.addActionListener(this);
        green.setActionCommand("Green");*/

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent evt) {
        /*if (evt.getActionCommand().equals("Red")) {
            getContentPane().setBackground(Color.red);
        } else {
            getContentPane().setBackground(Color.green);
        }
        repaint();

        copyText();
        repaint();

        String userIn = inFahr.getText();
        try {
            fahrTemp = Integer.parseInt(userIn);
            celsTemp = convert(fahrTemp);
            outCel.setText(celsTemp + "");
        } catch (NumberFormatException ex) {
            outCel.setText("Re-enter F");
        }
        repaint();

        fatGrams = Double.parseDouble(inFat.getText());
        calories = Double.parseDouble(inCal.getText());
        calcPercent();
        outPer.setText(new DecimalFormat("#0.0##").format(percent)); //or.setText(percent+"")
        repaint();*/
    }

    public void stateChanged(ChangeEvent evt) {
        JSlider source = (JSlider) evt.getSource();
        if (!source.getValueIsAdjusting()) {
            String name = source.getName();
            int value = source.getValue();
            int max = source.getMaximum();
            int min = source.getMinimum();
        }
    }

    /*void copyText() {
        copy.setText(text.getText());
    }*/

    public static void main(String[] args) {
        MyFrame frame = new MyFrame("F to C");
        frame.setVisible(true);
        frame.setSize(300, 150);
        frame.setResizable(true);
    }
}