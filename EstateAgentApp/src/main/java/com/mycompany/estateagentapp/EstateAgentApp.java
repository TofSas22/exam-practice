package com.mycompany.estateagentapp;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;

/**
 * Main GUI window for the Estate Agent Report application.
 */
public class EstateAgentApp extends JFrame {

    // Q.2.1 - GUI components
    private final String[] locations = {"Cape Town", "Durban", "Pretoria"};
    private final JComboBox<String> cmbLocation = new JComboBox<>(locations);
    private final JTextField txtAgentName = new JTextField(12);
    private final JTextField txtPropertyPrice = new JTextField(12);
    private final JTextField txtCommission = new JTextField(12);
    private final JTextArea txtReport = new JTextArea(6, 28);

    // Business logic object
    private final EstateAgent estateAgent = new EstateAgent();

    public EstateAgentApp() {
        setTitle("Estate Agent Report");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        buildMenu();
        buildForm();

        pack();
        setLocationRelativeTo(null);
    }

    // Q.2.2 - Creates the File and Tools menus
    private void buildMenu() {
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> System.exit(0));   // Q.2.3
        fileMenu.add(exitItem);

        JMenu toolsMenu = new JMenu("Tools");
        JMenuItem processItem = new JMenuItem("Process Report");
        JMenuItem clearItem = new JMenuItem("Clear");
        JMenuItem saveItem = new JMenuItem("Save Report");
        processItem.addActionListener(e -> processReport()); // Q.2.4
        clearItem.addActionListener(e -> clearForm());        // Q.2.6
        saveItem.addActionListener(e -> saveReport());        // Q.2.5
        toolsMenu.add(processItem);
        toolsMenu.add(clearItem);
        toolsMenu.add(saveItem);

        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);
        setJMenuBar(menuBar);
    }

    // Q.2.1 - Creates the labels, combo box, text fields and text area
    private void buildForm() {
        // Top section: 5 rows x 2 columns (label on the left, input on the right)
        JPanel inputPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        inputPanel.add(new JLabel("AGENT LOCATION:"));
        inputPanel.add(cmbLocation);
        inputPanel.add(new JLabel("ESTATE AGENT NAME:"));
        inputPanel.add(txtAgentName);
        inputPanel.add(new JLabel("PROPERTY PRICE:"));
        inputPanel.add(txtPropertyPrice);
        inputPanel.add(new JLabel("COMMISSION PERCENTAGE:"));
        inputPanel.add(txtCommission);
        inputPanel.add(new JLabel("ESTATE AGENT REPORT:"));

        // Report area is read only
        txtReport.setEditable(false);

        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(txtReport), BorderLayout.CENTER);
    }

    // Q.2.4 - Captures the input, validates it and displays the report
    private void processReport() {
        String location = (String) cmbLocation.getSelectedItem();
        String agentName = txtAgentName.getText().trim();
        String priceText = txtPropertyPrice.getText().trim();
        String commissionText = txtCommission.getText().trim();

        double propertyPrice;
        double commissionPercentage;

        // Convert the text to numbers; letters will throw NumberFormatException
        try {
            propertyPrice = Double.parseDouble(priceText);
            commissionPercentage = Double.parseDouble(commissionText);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Please enter numbers for the property price and commission percentage.");
            return;
        }

        // Q.2.7 - Only valid data may be captured
        Data data = new Data(location, agentName, propertyPrice, commissionPercentage);
        if (!estateAgent.ValidateData(data)) {
            JOptionPane.showMessageDialog(this,
                    "Invalid data: location and name cannot be empty, and the property price "
                    + "and commission percentage must be greater than 0.");
            return;
        }

        double commission = estateAgent.CalculateCommission(priceText, commissionText);

        String report = "AGENT LOCATION: " + location + "\n"
                + "AGENT NAME: " + agentName + "\n"
                + "PROPERTY PRICE: R " + propertyPrice + "\n"
                + "COMMISSION PERCENTAGE: " + commissionPercentage + "%\n"
                + "CALCULATED COMMISSION: R " + commission;

        txtReport.setText(report);
    }

    // Q.2.5 - Writes the report in the text area to report.txt
    private void saveReport() {
        // Nothing to save if Process Report hasn't been run yet
        if (txtReport.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please process a report before saving.");
            return;
        }

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("report.txt"));

            writer.write("ESTATE AGENT REPORT");
            writer.newLine();
            writer.write("************************************");
            writer.newLine();
            writer.write(txtReport.getText());
            writer.newLine();
            writer.write("************************************");

            writer.close(); // Must close, otherwise the text may never reach the file
            JOptionPane.showMessageDialog(this, "Report saved to report.txt");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error saving report: " + ex.getMessage());
        }
    }

    // Q.2.6 - Resets the form to its default state
    private void clearForm() {
        cmbLocation.setSelectedIndex(0);
        txtAgentName.setText("");
        txtPropertyPrice.setText("");
        txtCommission.setText("");
        txtReport.setText("");
    }

    public static void main(String[] args) {
        // Start the GUI on the Swing event thread
        SwingUtilities.invokeLater(() -> new EstateAgentApp().setVisible(true));
    }
}