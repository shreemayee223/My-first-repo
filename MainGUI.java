/*import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import mypackage.Billcalculator;
import mypackage.consumer;
import mypackage.DBHandler;

public class MainGUI extends JFrame {

    private JTextField nameField, idField, unitsField;
    private JTextArea outputArea;

    public MainGUI() {
        // Frame setup
        setTitle("Electricity Bill Management System");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Input Panel
        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        
        inputPanel.add(new JLabel("Consumer Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Consumer ID:"));
        idField = new JTextField();
        inputPanel.add(idField);

        inputPanel.add(new JLabel("Units Consumed:"));
        unitsField = new JTextField();
        inputPanel.add(unitsField);

        // Buttons
        JButton generateBtn = new JButton("Generate Bill");
        JButton viewBtn = new JButton("View Saved Bills");
        JButton exitBtn = new JButton("Exit");

        inputPanel.add(generateBtn);
        inputPanel.add(viewBtn);

        // Output Area
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(exitBtn, BorderLayout.SOUTH);

        // Button Actions
        generateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateBill();
            }
        });

        viewBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewBills();
            }
        });

        exitBtn.addActionListener(e -> System.exit(0));
    }

    private void generateBill() {
        try {
            String name = nameField.getText();
            int id = Integer.parseInt(idField.getText());
            double units = Double.parseDouble(unitsField.getText());

            double billAmount = Billcalculator.calculateBill(units);
            consumer c = new consumer(name, id, units, billAmount);

            // Display on screen
            outputArea.setText("Generated Bill:\n");
            outputArea.append("Name: " + name + "\n");
            outputArea.append("ID: " + id + "\n");
            outputArea.append("Units: " + units + "\n");
            outputArea.append("Bill Amount: ₹" + billAmount + "\n");

            // Save to DB
            DBHandler.saveToDB(c);

            JOptionPane.showMessageDialog(this, "Bill saved successfully!");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "⚠ Invalid input. Try again.");
        }
    }

    private void viewBills() {
        outputArea.setText("--- Saved Bills ---\n");
        List<consumer> consumers = DBHandler.readFromDB();
        for (consumer c : consumers) {
            outputArea.append(
                "Name: " + c.getName() +
                ", ID: " + c.getId() +
                ", Units: " + c.getUnits() +
                ", Bill: ₹" + c.getBillAmount() + "\n"
            );
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MainGUI().setVisible(true);
        });
    }
}*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import mypackage.Billcalculator;
import mypackage.Consumer; // Changed from 'consumer' to 'Consumer'
import mypackage.DBHandler;

public class MainGUI extends JFrame {

    private JTextField nameField, idField, unitsField;
    private JTextArea outputArea;

    public MainGUI() {
        setTitle("Electricity Bill Management System");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 10, 10));

        inputPanel.add(new JLabel("Consumer Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Consumer ID:"));
        idField = new JTextField();
        inputPanel.add(idField);

        inputPanel.add(new JLabel("Units Consumed:"));
        unitsField = new JTextField();
        inputPanel.add(unitsField);

        JButton generateBtn = new JButton("Generate Bill");
        JButton viewBtn = new JButton("View Saved Bills");
        JButton exitBtn = new JButton("Exit");

        inputPanel.add(generateBtn);
        inputPanel.add(viewBtn);

        outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(exitBtn, BorderLayout.SOUTH);

        generateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateBill();
            }
        });

        viewBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewBills();
            }
        });

        exitBtn.addActionListener(e -> System.exit(0));
    }

    private void generateBill() {
        try {
            String name = nameField.getText();
            int id = Integer.parseInt(idField.getText());
            double units = Double.parseDouble(unitsField.getText());

            double billAmount = Billcalculator.calculateBill(units);
        consumer c = new consumer(name, id, units, billAmount); // Changed from 'consumer' to 'Consumer'

            outputArea.setText("Generated Bill:\n");
            outputArea.append("Name: " + name + "\n");
            outputArea.append("ID: " + id + "\n");
            outputArea.append("Units: " + units + "\n");
            outputArea.append(String.format("Bill Amount: ₹%.2f\n", billAmount));

            DBHandler.saveToDB(c);

            JOptionPane.showMessageDialog(this, "Bill saved successfully!");

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "⚠ Invalid number format. Please enter valid numbers for ID and Units.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "⚠ Invalid input. Try again.");
        }
    }

    private void viewBills() {
        outputArea.setText("--- Saved Bills ---\n");
        List<Consumer> consumers = DBHandler.readFromDB(); // Changed from 'consumer' to 'Consumer'
        for (Consumer c : consumers) {
            outputArea.append(
                "Name: " + c.getName() +
                ", ID: " + c.getId() +
                ", Units: " + c.getUnits() +
                String.format(", Bill: ₹%.2f\n", c.getBillAmount())
            );
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MainGUI().setVisible(true);
        });
    }
}