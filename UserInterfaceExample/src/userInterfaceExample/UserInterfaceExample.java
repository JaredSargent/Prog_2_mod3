package userInterfaceExample;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.*;
import java.util.*;

public class UserInterfaceExample {

    private static JTextArea textArea;

    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("User Interface Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Create a menu bar
        JMenuBar menuBar = new JMenuBar();

        // Create menu
        JMenu menu = new JMenu("Options");

        // Create menu items
        JMenuItem item1 = new JMenuItem("Display Date and Time");
        JMenuItem item2 = new JMenuItem("Write to File");
        JMenuItem item3 = new JMenuItem("Change Background Color");
        JMenuItem item4 = new JMenuItem("Exit");

        // Add menu items to the menu
        menu.add(item1);
        menu.add(item2);
        menu.add(item3);
        menu.add(item4);

        // Add menu to the menu bar
        menuBar.add(menu);

        // Set the menu bar for the frame
        frame.setJMenuBar(menuBar);

        // Create text area to display information
        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setOpaque(false); // Make text area transparent
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setOpaque(false); // Make scroll pane transparent
        scrollPane.getViewport().setOpaque(false); // Make viewport transparent
        frame.add(scrollPane, BorderLayout.CENTER);

        // Action for Display Date and Time
        item1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date date = new Date();
                textArea.setText("Current Date and Time: " + formatter.format(date));
            }
        });

        // Action for Write to File
        item2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter("log.txt", true));
                    writer.write(textArea.getText());
                    writer.newLine();
                    writer.close();
                    textArea.append("\nContent written to log.txt");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        // Action for Change Background Color
        item3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Random rand = new Random();
                // Generate a random hue between 0.083 (30°) and 0.167 (60°) for orange shades
                float hue = 0.083f + (rand.nextFloat() * (0.167f - 0.083f));
                Color randomOrange = Color.getHSBColor(hue, 1.0f, 1.0f); // Max saturation and brightness
                frame.getContentPane().setBackground(randomOrange);
                frame.repaint(); // Ensure the UI updates
                textArea.setText("Background color changed to orange (hue: " + (hue * 360) + "°)");
            }
        });

        // Action for Exit
        item4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Set frame to visible
        frame.setVisible(true);
    }
}