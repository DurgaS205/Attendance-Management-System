import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class STUDENTMARKS {
    private JFrame frame;
    private JTable table;
    private DefaultTableModel model;
    private JButton backButton;

    private String[] columnNames = {"Sl No.", "Student Name", "1st Int", "Grade", "2nd Int", "Grade", "Final", "Grade"};
    private String[][] students = {
        {"1", "Alice Johnson", "85", "A", "78", "B", "92", "A*"},
        {"2", "Bob Smith", "76", "B", "80", "A", "88", "A"},
        {"3", "Charlie Brown", "90", "A*", "85", "A", "95", "A*"},
        {"4", "David Wilson", "65", "C", "70", "B", "75", "B"},
        {"5", "Emma Davis", "50", "D", "55", "D", "60", "C"},
        {"6", "Fiona Taylor", "95", "A*", "89", "A", "96", "A*"},
        {"7", "George Anderson", "88", "A", "76", "B", "84", "A"},
        {"8", "Hannah White", "45", "F", "50", "D", "55", "D"},
        {"9", "Ian Moore", "78", "B", "72", "B", "80", "A"},
        {"10", "Jack Lee", "85", "A", "82", "A", "90", "A*"},
        {"11", "Kelly Adams", "92", "A*", "91", "A*", "94", "A*"},
        {"12", "Liam Thomas", "55", "D", "60", "C", "65", "C"},
        {"13", "Mia Harris", "70", "B", "75", "B", "80", "A"},
        {"14", "Noah Martin", "80", "A", "85", "A", "90", "A*"},
        {"15", "Olivia Clark", "68", "C", "70", "B", "72", "B"},
        {"16", "Peter Lewis", "74", "B", "78", "B", "80", "A"},
        {"17", "Quinn Walker", "60", "C", "65", "C", "70", "B"},
        {"18", "Ryan Hall", "82", "A", "80", "A", "88", "A"},
        {"19", "Sophia Allen", "91", "A*", "93", "A*", "95", "A*"},
        {"20", "Tom Young", "75", "B", "78", "B", "82", "A"},
        {"21", "Uma King", "80", "A", "82", "A", "85", "A"},
        {"22", "Victor Scott", "67", "C", "70", "B", "72", "B"},
        {"23", "Wendy Green", "55", "D", "60", "C", "65", "C"},
        {"24", "Xander Baker", "79", "B", "85", "A", "88", "A"},
        {"25", "Yara Nelson", "90", "A*", "92", "A*", "95", "A*"},
        {"26", "Zane Carter", "72", "B", "75", "B", "78", "B"},
        {"27", "Abby Wright", "65", "C", "68", "C", "70", "B"},
        {"28", "Blake Mitchell", "88", "A", "85", "A", "90", "A*"},
        {"29", "Clara Perez", "55", "D", "60", "C", "65", "C"},
        {"30", "Dylan Edwards", "92", "A*", "95", "A*", "98", "A*"},
        {"31", "Eleanor Collins", "50", "D", "55", "D", "60", "C"},
        {"32", "Felix Stewart", "85", "A", "87", "A", "90", "A*"},
        {"33", "Grace Rodriguez", "77", "B", "80", "A", "83", "A"},
        {"34", "Henry Cox", "66", "C", "70", "B", "72", "B"},
        {"35", "Isla Evans", "95", "A*", "92", "A*", "97", "A*"},
        {"36", "James Murphy", "59", "D", "60", "C", "62", "C"},
        {"37", "Katie Bell", "78", "B", "80", "A", "85", "A"},
        {"38", "Leo Reed", "82", "A", "85", "A", "88", "A"},
        {"39", "Madison Cook", "75", "B", "78", "B", "80", "A"},
        {"40", "Nathan Bailey", "91", "A*", "93", "A*", "96", "A*"},
        {"41", "Olive Howard", "55", "D", "60", "C", "65", "C"},
        {"42", "Paul Griffin", "88", "A", "85", "A", "90", "A*"},
        {"43", "Quincy Russell", "70", "B", "72", "B", "75", "B"},
        {"44", "Rachel Sanders", "60", "C", "65", "C", "70", "B"},
        {"45", "Sam Foster", "50", "D", "55", "D", "60", "C"},
        {"46", "Tina Ramirez", "92", "A*", "95", "A*", "98", "A*"},
        {"47", "Umar Diaz", "74", "B", "78", "B", "80", "A"},
        {"48", "Victor Bennett", "66", "C", "70", "B", "72", "B"},
        {"49", "William Morris", "85", "A", "88", "A", "90", "A*"},
        {"50", "Zoe Parker", "91", "A*", "93", "A*", "96", "A*"}
    };

    public STUDENTMARKS() {
        frame = new JFrame("ABC Engineering College - Student Marks");
        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        model = new DefaultTableModel(students, columnNames);
        table = new JTable(model);
        frame.add(new JScrollPane(table), BorderLayout.CENTER);

        backButton = new JButton("Back");
        backButton.addActionListener(e -> goBack());
        frame.add(backButton, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private void goBack() {
        frame.dispose();
        new DASHBOARD();  // Ensure Dashboard class exists
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(STUDENTMARKS::new);
    }
}
