package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLOutput;

public class SuperHeroes extends JPanel {
    private static boolean DEBUG = true;


    public static void main(String[] args) {
	// write your code here

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });

    }

    public SuperHeroes() {
        super(new GridLayout(5, 5));

        String[] columnNames = {"Real Name", "Super Hero Name", "Speed", "Power", "Tier"};

        Object[][] data = {
                {"Ivan", "Ant-Man", 350, "run", 80 },
                {"Mary", "Asterix", 250, "jump", 70 },
                {"Sue", "Aquaman", 150, "fight", 60 },
                {"Bob", "Batgirl", 50, "flight", 50 },
                {"Robert", "Batman", 20, "sleep", 40 },
        };

        final JTable table = new JTable(data, columnNames);
        table.setPreferredScrollableViewportSize(new Dimension(700, 120));
        table.setFillsViewportHeight(true);

        if (DEBUG) {
            table.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);
                    System.out.println("Mistake");
                }
            });


        }
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);

    }

    private static void createAndShowGUI() {
        if (DEBUG) {
            System.out.println("Hi!");

        }

        JFrame frame = new JFrame("SuperHeroes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        SuperHeroes newContentPane = new SuperHeroes();
        newContentPane.setOpaque(true);
        frame.setContentPane(newContentPane);


        frame.pack();
        frame.setVisible(true);
    }

    private void printDebugData(JTable table) {
        System.out.println("Mouse is clicked - i am happy");

        int numRows = table.getRowCount();
        int numColumns = table.getColumnCount();

        javax.swing.table.TableModel model = table.getModel();
        System.out.println("value of table data: ");

        for (int i = 0; i < numRows; i++) {
            System.out.println("     row " + i + ": ");
            for (int j = 0; j <numColumns ; j++) {
                System.out.println("           " + model.getValueAt(i, j));

            }
            System.out.println();
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~");
    }

}
