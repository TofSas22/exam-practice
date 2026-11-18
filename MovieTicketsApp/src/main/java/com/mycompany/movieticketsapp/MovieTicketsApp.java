package com.mycompany.movieticketsapp;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;

/**
 * Main GUI window for the Movie Tickets application.
 */
public class MovieTicketsApp extends JFrame {

    // Q.2.1 - GUI components
    private final String[] movies = {"Napoleon", "Oppenheimer", "Damsel"};
    private final JComboBox<String> cmbMovie = new JComboBox<>(movies);
    private final JTextField txtNumberOfTickets = new JTextField(10);
    private final JTextField txtTicketPrice = new JTextField(10);
    private final JTextArea txtReport = new JTextArea(6, 25);

    // Business logic object
    private final MovieTickets movieTickets = new MovieTickets();

    public MovieTicketsApp() {
        setTitle("MOVIE TICKETS");
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
        JMenuItem processItem = new JMenuItem("Process");
        JMenuItem clearItem = new JMenuItem("Clear");
        processItem.addActionListener(e -> processTickets()); // Q.2.4
        clearItem.addActionListener(e -> clearForm());        // Q.2.6
        toolsMenu.add(processItem);
        toolsMenu.add(clearItem);

        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);
        setJMenuBar(menuBar);
    }

    // Q.2.1 - Creates the labels, combo box, text fields and text area
    private void buildForm() {
        // Top section: 4 rows x 2 columns (label on the left, input on the right)
        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        inputPanel.add(new JLabel("MOVIE:"));
        inputPanel.add(cmbMovie);
        inputPanel.add(new JLabel("NUMBER OF TICKETS:"));
        inputPanel.add(txtNumberOfTickets);
        inputPanel.add(new JLabel("TICKET PRICE:"));
        inputPanel.add(txtTicketPrice);
        inputPanel.add(new JLabel("TICKET REPORT:"));

        // Report area is read only
        txtReport.setEditable(false);

        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(txtReport), BorderLayout.CENTER);
    }

    // Q.2.4 - Captures the input, validates it and displays the report
    private void processTickets() {
        String movieName = (String) cmbMovie.getSelectedItem();
        int numberOfTickets;
        double ticketPrice;

        // Convert the text to numbers; letters will throw NumberFormatException
        try {
            numberOfTickets = Integer.parseInt(txtNumberOfTickets.getText().trim());
            ticketPrice = Double.parseDouble(txtTicketPrice.getText().trim());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Please enter numbers for the number of tickets and ticket price.");
            return;
        }

        // Q.2.7 - Only valid data may be captured
        MovieTicketData data = new MovieTicketData(movieName, numberOfTickets, ticketPrice);
        if (!movieTickets.ValidateData(data)) {
            JOptionPane.showMessageDialog(this,
                    "Invalid data: a movie must be selected, and the number of tickets "
                    + "and ticket price must be greater than 0.");
            return;
        }

        double totalPrice = movieTickets.CalculateTotalTicketPrice(numberOfTickets, ticketPrice);

        String report = "MOVIE NAME: " + movieName + "\n"
                + "MOVIE TICKET PRICE: R " + ticketPrice + "\n"
                + "NUMBER OF TICKETS: " + numberOfTickets + "\n"
                + "TOTAL TICKET PRICE: R " + totalPrice;

        txtReport.setText(report);

        // Q.2.5 - Save the report once it has been generated
        saveReport(report);
    }

    // Q.2.5 - Writes the report to report.txt
    private void saveReport(String report) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("report.txt"));

            writer.write("MOVIE TICKET REPORT");
            writer.newLine();
            writer.write("************************************");
            writer.newLine();
            writer.write(report);
            writer.newLine();
            writer.write("************************************");

            writer.close(); // Must close, otherwise the text may never reach the file
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error saving report: " + ex.getMessage());
        }
    }

    // Q.2.6 - Resets the form to its default state
    private void clearForm() {
        cmbMovie.setSelectedIndex(0);
        txtNumberOfTickets.setText("");
        txtTicketPrice.setText("");
        txtReport.setText("");
    }

    public static void main(String[] args) {
        // Start the GUI on the Swing event thread
        SwingUtilities.invokeLater(() -> new MovieTicketsApp().setVisible(true));
    }
}