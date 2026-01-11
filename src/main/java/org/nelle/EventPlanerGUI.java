package org.nelle;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class EventPlanerGUI {

    private static final ArrayList<Event> events = new ArrayList<>();

    public static void main(String[] args) {
        initObjekte();
        javax.swing.SwingUtilities.invokeLater(EventPlanerGUI::createAndShowGUI);
    }

    private static void initObjekte() {
        //source: https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
        events.add(new Event("Welcome 2026", "Dinner & anschließend DJ ", "Kuba in Aalen", 1800, LocalDate.parse("2026-01-23", formatter)));
        events.add(new Event("Fasching After Work", "Kostümparty", "Foyer",1000, LocalDate.parse("2026-01-31", formatter)));
        events.add(new Event("Jubiläumsfeier", "10 Jahre", "Foyer",1200, LocalDate.parse("2026-04-10", formatter)));
        events.add(new Event("Office goes Beach", "Sommerparty mit Beachbar, + Begleitung", "Dachterasse",3000, LocalDate.parse("2026-07-31", formatter)));
    }

    //source: https://docs.oracle.com/javase/tutorial/uiswing/layout/gridbag.html
    private static void createAndShowGUI() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setPreferredSize(new Dimension(600, 350));

        //Event Name
        JLabel label1 = new JLabel("Name");
        GridBagConstraints label1Constraints = new GridBagConstraints();
        label1Constraints.fill = GridBagConstraints.HORIZONTAL;
        label1Constraints.insets = new Insets(30, 30, 0, 30);  // padding
        label1Constraints.gridx = 0;       //1 column
        label1Constraints.gridy = 0;       //1 row
        panel.add(label1, label1Constraints);

        JTextField textField1 = new JTextField();
        GridBagConstraints textField1Constraints = new GridBagConstraints();
        textField1Constraints.fill = GridBagConstraints.HORIZONTAL;
        textField1Constraints.insets = new Insets(30, 0, 0, 30);  // padding
        textField1Constraints.gridx = 1;       //2 column
        textField1Constraints.gridy = 0;       //1 row
        textField1Constraints.weightx = 1.0;
        panel.add(textField1, textField1Constraints);

        //Event Beschreibung
        JLabel label2 = new JLabel("Beschreibung");
        GridBagConstraints label2Constraints = new GridBagConstraints();
        label2Constraints.fill = GridBagConstraints.HORIZONTAL;
        label2Constraints.insets = new Insets(15, 30, 0, 30);
        label2Constraints.gridx = 0;
        label2Constraints.gridy = 1;
        panel.add(label2, label2Constraints);

        JTextField textField2 = new JTextField();
        GridBagConstraints textField2Constraints = new GridBagConstraints();
        textField2Constraints.fill = GridBagConstraints.HORIZONTAL;
        textField2Constraints.insets = new Insets(15, 0, 0, 30);
        textField2Constraints.gridx = 1;
        textField2Constraints.gridy = 1;
        textField2Constraints.weightx = 1.0;
        panel.add(textField2, textField2Constraints);

        //Event Location
        JLabel label3 = new JLabel("Location");
        GridBagConstraints label3Constraints = new GridBagConstraints();
        label3Constraints.fill = GridBagConstraints.HORIZONTAL;
        label3Constraints.insets = new Insets(15, 30, 0, 30);
        label3Constraints.gridx = 0;
        label3Constraints.gridy = 2;
        panel.add(label3, label3Constraints);

        JTextField textField3 = new JTextField();
        GridBagConstraints textField3Constraints = new GridBagConstraints();
        textField3Constraints.fill = GridBagConstraints.HORIZONTAL;
        textField3Constraints.insets = new Insets(15, 0, 0, 30);
        textField3Constraints.gridx = 1;
        textField3Constraints.gridy = 2;
        textField3Constraints.weightx = 1.0;
        panel.add(textField3, textField3Constraints);


        //Event Kosten
        JLabel label4 = new JLabel("Kosten (in €)");
        GridBagConstraints label4Constraints = new GridBagConstraints();
        label4Constraints.fill = GridBagConstraints.HORIZONTAL;
        label4Constraints.insets = new Insets(15, 30, 0, 30);
        label4Constraints.gridx = 0;
        label4Constraints.gridy = 3;
        panel.add(label4, label4Constraints);

        JTextField textField4 = new JTextField();
        GridBagConstraints textField4Constraints = new GridBagConstraints();
        textField4Constraints.fill = GridBagConstraints.HORIZONTAL;
        textField4Constraints.insets = new Insets(15, 0, 0, 30);
        textField4Constraints.gridx = 1;
        textField4Constraints.gridy = 3;
        textField4Constraints.weightx = 1.0;
        panel.add(textField4, textField4Constraints);

        //Event Datum
        JLabel label5 = new JLabel("Datum (YYYY-MM-DD)");
        GridBagConstraints label5Constraints = new GridBagConstraints();
        label5Constraints.fill = GridBagConstraints.HORIZONTAL;
        label5Constraints.insets = new Insets(15, 30, 0, 30);
        label5Constraints.gridx = 0;
        label5Constraints.gridy = 4;
        panel.add(label5, label5Constraints);

        JTextField textField5 = new JTextField();
        GridBagConstraints textField5Constraints = new GridBagConstraints();
        textField5Constraints.fill = GridBagConstraints.HORIZONTAL;
        textField5Constraints.insets = new Insets(15, 0, 0, 30);
        textField5Constraints.gridx = 1;
        textField5Constraints.gridy = 4;
        textField5Constraints.weightx = 1.0;
        panel.add(textField5, textField5Constraints);

        //save button
        JButton saveEventButton = new JButton("Speichern");
        GridBagConstraints saveEventButtonConstraints = new GridBagConstraints();
        saveEventButtonConstraints.fill = GridBagConstraints.HORIZONTAL;
        saveEventButtonConstraints.insets = new Insets(30, 30, 0, 30);
        saveEventButtonConstraints.gridx = 0;
        saveEventButtonConstraints.gridy = 5;
        saveEventButtonConstraints.gridwidth = 2;
        saveEventButton.addActionListener(e -> {
            String name = textField1.getText();
            String description = textField2.getText();
            String location = textField3.getText();
            int cost = 0;
            LocalDate datum = null;
            //capsulated exception
            try {
                cost = Integer.parseInt(textField4.getText());
                try {
                    DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
                    datum = LocalDate.parse(textField5.getText(), formatter);
                    events.add(new Event(name, description, location, cost, datum));
                    //reset text fields after successful execution of events.add();
                    textField1.setText("");
                    textField2.setText("");
                    textField3.setText("");
                    textField4.setText("");
                    textField5.setText("");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Das Eventdatum muss die Form YYYY-MM-DD aufweisen (z.B. 2025-12-24).", "Eingabefehler", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Die Eventkosten müssen als ganze Zahl angegebenwerden (volle € z.B. 1042).", "Eingabefehler", JOptionPane.ERROR_MESSAGE);
            }
        });
        panel.add(saveEventButton, saveEventButtonConstraints);

        //show all events Button
        JButton allEventButton = new JButton("Alle Events");
        GridBagConstraints allEventButtonConstraints = new GridBagConstraints();
        allEventButtonConstraints.fill = GridBagConstraints.HORIZONTAL;
        allEventButtonConstraints.insets = new Insets(15, 30, 0, 30);
        allEventButtonConstraints.gridx = 0;
        allEventButtonConstraints.gridy = 6;
        allEventButtonConstraints.gridwidth = 2;
        allEventButton.addActionListener(e -> {
            JFrame frame = new JFrame("Alle Events");
            frame.add(makeListPanel(false));
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
        panel.add(allEventButton, allEventButtonConstraints);

        //show future events Button
        JButton futureEventButton = new JButton("Nächste Events");
        GridBagConstraints futureEventButtonConstraints = new GridBagConstraints();
        futureEventButtonConstraints.fill = GridBagConstraints.HORIZONTAL;
        futureEventButtonConstraints.insets = new Insets(15, 30, 30, 30);
        futureEventButtonConstraints.gridx = 0;
        futureEventButtonConstraints.gridy = 7;
        futureEventButtonConstraints.gridwidth = 2;
        futureEventButton.addActionListener(e -> {
            JFrame frame = new JFrame("Nächste Events (30 Tage)");
            frame.add(makeListPanel(true));
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
        panel.add(futureEventButton, futureEventButtonConstraints);

        JFrame frame = new JFrame("Eventplaner");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    //source: https://docs.oracle.com/javase/tutorial/uiswing/components/table.html#sorting
    protected static JScrollPane makeListPanel(boolean timely) {
        //create table with header
        DefaultTableModel model = new DefaultTableModel(new String[]{"Name", "Beschreibung", "Location","Kosten", "Datum"}, 0);



        //if table presents only timely events check for timely events
        if (!timely) {
            for (Event event : events) {
                //add events to table
                model.addRow(new Object[]{event.getEventName(), event.getEventDescription(), event.getEventLocation(), event.getEventCost(), event.getEventDatum()});
            }
        } else {
            for (Event event : events) {
                if (event.getEventTimely()) {
                    //add events to table
                    model.addRow(new Object[]{event.getEventName(), event.getEventDescription(),event.getEventLocation(), event.getEventCost(), event.getEventDatum()});
                }
            }
        }

        //create table and sorter
        JTable table = new JTable(model);
        table.setAutoCreateRowSorter(true);

        return new JScrollPane(table);
    }

}
