import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class ATTENDANCE {
    private JFrame frame;
    private JTable table;
    private DefaultTableModel model;
    private int currentWeekIndex = 0;
    private JButton prevButton, nextButton, addStudentButton, editButton, saveButton, backButton;
    private String[] columnNames;
    private static final String FILE_NAME = "attendance_data.txt";
    
    private String[][] students = {
        {"1", "Alice Johnson"}, {"2", "Bob Smith"}, {"3", "Charlie Brown"}, {"4", "David Wilson"}, {"5", "Emma Davis"},
        {"6", "Fiona Taylor"}, {"7", "George Anderson"}, {"8", "Hannah White"}, {"9", "Ian Moore"}, {"10", "Jack Lee"},
        {"11", "Kelly Adams"}, {"12", "Liam Thomas"}, {"13", "Mia Harris"}, {"14", "Noah Martin"}, {"15", "Olivia Clark"},
        {"16", "Peter Lewis"}, {"17", "Quinn Walker"}, {"18", "Ryan Hall"}, {"19", "Sophia Allen"}, {"20", "Tom Young"},
        {"21", "Uma King"}, {"22", "Victor Scott"}, {"23", "Wendy Green"}, {"24", "Xander Baker"}, {"25", "Yara Nelson"},
        {"26", "Zane Carter"}, {"27", "Abby Wright"}, {"28", "Blake Mitchell"}, {"29", "Clara Perez"}, {"30", "Dylan Edwards"},
        {"31", "Eleanor Collins"}, {"32", "Felix Stewart"}, {"33", "Grace Rodriguez"}, {"34", "Henry Cox"}, {"35", "Isla Evans"},
        {"36", "James Murphy"}, {"37", "Katie Bell"}, {"38", "Leo Reed"}, {"39", "Madison Cook"}, {"40", "Nathan Bailey"},
        {"41", "Olive Howard"}, {"42", "Paul Griffin"}, {"43", "Quincy Russell"}, {"44", "Rachel Sanders"}, {"45", "Sam Foster"},
        {"46", "Tina Ramirez"}, {"47", "Umar Diaz"}, {"48", "Victor Bennett"}, {"49", "William Morris"}, {"50", "Zoe Parker"}
    };

    public ATTENDANCE() {
        frame = new JFrame("Attendance - Java");
        frame.setSize(1000, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        columnNames = generateColumnHeaders();
        model = new DefaultTableModel(columnNames, 0);
        table = new JTable(model);

        table.setDefaultRenderer(Object.class, new AttendanceRenderer());
        JScrollPane scrollPane = new JScrollPane(table);

        addStudentButton = new JButton("Add Student");
       
        editButton = new JButton("Edit");
        saveButton = new JButton("Save");
        prevButton = new JButton("Previous");
        nextButton = new JButton("Next");
        backButton = new JButton("Back");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addStudentButton);
       
        buttonPanel.add(editButton);
        buttonPanel.add(saveButton);
        buttonPanel.add(prevButton);
        buttonPanel.add(nextButton);
        buttonPanel.add(backButton);

        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        loadAttendanceData();

        addStudentButton.addActionListener(e -> addStudent());
       
        editButton.addActionListener(e -> editAttendance());
        saveButton.addActionListener(e -> saveAttendance());
        prevButton.addActionListener(e -> changeWeek(-1));
        nextButton.addActionListener(e -> changeWeek(1));
        backButton.addActionListener(e -> goBackToDashboard());

        frame.setVisible(true);
    }

    private String[] generateColumnHeaders() {
        String[] headers = new String[8];
        headers[0] = "Sl No.";
        headers[1] = "Student Name";

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM EEE");
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, 1 + (currentWeekIndex * 7));

        int colIndex = 2;
        while (colIndex < 7) {
            int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
            if (dayOfWeek != Calendar.SATURDAY && dayOfWeek != Calendar.SUNDAY) {
                headers[colIndex++] = sdf.format(cal.getTime());
            }
            cal.add(Calendar.DATE, 1);
        }
        headers[7] = "Percentage";
        return headers;
    }

    private void loadAttendanceData() {
        model.setRowCount(0);
        Random rand = new Random();
        File file = new File(FILE_NAME);

        try {
            if (file.exists()) {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String line;
                while ((line = reader.readLine()) != null) {
                    model.addRow(line.split(","));
                }
                reader.close();
            } else {
                for (String[] student : students) {
                    String[] rowData = new String[columnNames.length];
                    rowData[0] = student[0];
                    rowData[1] = student[1];

                    int presentDays = 0;
                    for (int i = 2; i < columnNames.length - 1; i++) {
                        rowData[i] = rand.nextBoolean() ? "X" : "A";
                        if (rowData[i].equals("X")) presentDays++;
                    }
                    rowData[columnNames.length - 1] = String.format("%.2f%%", (presentDays / 5.0) * 100);
                    model.addRow(rowData);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveAttendance() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME));
            for (int i = 0; i < model.getRowCount(); i++) {
                for (int j = 0; j < model.getColumnCount(); j++) {
                    writer.write(model.getValueAt(i, j) + (j == model.getColumnCount() - 1 ? "" : ","));
                }
                writer.newLine();
            }
            writer.close();
            JOptionPane.showMessageDialog(frame, "Attendance saved successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addStudent() {
        String name = JOptionPane.showInputDialog(frame, "Enter Student Name:");
        if (name != null && !name.trim().isEmpty()) {
            String slNo = String.valueOf(model.getRowCount() + 1);
            model.addRow(new String[]{slNo, name, "X", "X", "X", "X", "X", "100%"});
        }
    }

   
    private void editAttendance() {
        int row = table.getSelectedRow();
        int col = table.getSelectedColumn();
        if (row > -1 && col > 1 && col < columnNames.length - 1) {
            String status = JOptionPane.showInputDialog(frame, "Enter Attendance (X/A):");
            if (status != null && (status.equalsIgnoreCase("X") || status.equalsIgnoreCase("A"))) {
                model.setValueAt(status.toUpperCase(), row, col);
                updatePercentage(row);
            }
        }
    }

    private void updatePercentage(int row) {
        int presentDays = 0;
        for (int i = 2; i < columnNames.length - 1; i++) {
            if (model.getValueAt(row, i).equals("X")) presentDays++;
        }
        model.setValueAt(String.format("%.2f%%", (presentDays / 5.0) * 100), row, columnNames.length - 1);
    }

    private void changeWeek(int direction) {
        currentWeekIndex += direction;
        columnNames = generateColumnHeaders();
        model.setColumnIdentifiers(columnNames);
        loadAttendanceData();
    }

    private void goBackToDashboard() {
        frame.dispose();
        new DASHBOARD();
    }

    private static class AttendanceRenderer extends DefaultTableCellRenderer {
        public void setValue(Object value) {
            if ("A".equals(value)) setForeground(Color.RED);
            else setForeground(Color.BLACK);
            super.setValue(value);
        }
    }

    public static void main(String[] args) {
        new ATTENDANCE();
    }
}
