package com.mycompany.productsalesapp;

import java.awt.Component;
import java.awt.Dimension;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import javax.swing.*;

/**
 * Main GUI window for the Product Sales Application.
 */
public class ProductSalesApp extends JFrame {

    // GUI components
    private final JTextArea txtReport = new JTextArea(6, 20);
    private final JLabel lblYearsProcessed = new JLabel("Years Processed: ");

    // Business logic object
    private final ProductSales productSales = new ProductSales();

    public ProductSalesApp() {
        setTitle("Product Sales Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buildMenu();
        buildForm();
        pack();
        setLocationRelativeTo(null);
    }

    // Q.2.3 - Creates the File and Tools menus
    private void buildMenu() {
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> System.exit(0));
        fileMenu.add(exitItem);

        JMenu toolsMenu = new JMenu("Tools");
        JMenuItem loadItem = new JMenuItem("Load Product Data");
        JMenuItem saveItem = new JMenuItem("Save Product Data");
        JMenuItem clearItem = new JMenuItem("Clear");

        // Menu items reuse the same methods as the buttons (no duplicate code)
        loadItem.addActionListener(e -> loadProductData());
        saveItem.addActionListener(e -> saveProductData());
        clearItem.addActionListener(e -> clearData());

        toolsMenu.add(loadItem);
        toolsMenu.add(saveItem);
        toolsMenu.add(clearItem);

        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);
        setJMenuBar(menuBar);
    }

    // Q.2.1 - Creates the buttons, text area and label
    private void buildForm() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        JButton btnLoad = new JButton("Load Product Data");
        JButton btnSave = new JButton("Save Product Data");
        btnLoad.addActionListener(e -> loadProductData());
        btnSave.addActionListener(e -> saveProductData());

        // Make the buttons stretch to the same width
        Dimension buttonSize = new Dimension(Integer.MAX_VALUE, 30);
        btnLoad.setMaximumSize(buttonSize);
        btnSave.setMaximumSize(buttonSize);

        txtReport.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(txtReport);

        btnLoad.setAlignmentX(Component.LEFT_ALIGNMENT);
        btnSave.setAlignmentX(Component.LEFT_ALIGNMENT);
        scrollPane.setAlignmentX(Component.LEFT_ALIGNMENT);
        lblYearsProcessed.setAlignmentX(Component.LEFT_ALIGNMENT);

        panel.add(btnLoad);
        panel.add(Box.createVerticalStrut(8));
        panel.add(btnSave);
        panel.add(Box.createVerticalStrut(8));
        panel.add(scrollPane);
        panel.add(Box.createVerticalStrut(8));
        panel.add(lblYearsProcessed);

        add(panel);
    }

    // Q.2.2 - Loads data from memory, calculates and displays the report
    private void loadProductData() {
        String report = "Total Sales: " + productSales.GetTotalSales() + "\n"
                + "Average Sales: " + Math.round(productSales.GetAverageSales()) + "\n"
                + "Sales over limit: " + productSales.GetSalesOverLimit() + "\n"
                + "Sales under limit: " + productSales.GetSalesUnderLimit();

        txtReport.setText(report);
        lblYearsProcessed.setText("Years Processed: " + productSales.GetProductsProcessed());
    }

    // Q.2.2 - Saves the text area contents to data.txt
    private void saveProductData() {
        try {
            // FileWriter opens (or creates) the file; BufferedWriter writes to it efficiently
            BufferedWriter writer = new BufferedWriter(new FileWriter("data.txt"));

            writer.write("DATA LOG");
            writer.newLine();
            writer.write("**********************************");
            writer.newLine();
            writer.write(txtReport.getText());
            writer.newLine();
            writer.write("**********************************");

            writer.close(); // Must close, otherwise the text may never reach the file
            JOptionPane.showMessageDialog(this, "Product data saved to data.txt");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error saving file: " + ex.getMessage());
        }
    }

    // Q.2.3 - Clears the text area and the years processed label
    private void clearData() {
        txtReport.setText("");
        lblYearsProcessed.setText("Years Processed: ");
    }

    public static void main(String[] args) {
        // Start the GUI on the Swing event thread
        SwingUtilities.invokeLater(() -> new ProductSalesApp().setVisible(true));
    }
}
