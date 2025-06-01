import javax.swing.*;
import java.awt.*;

public class TEACHERPROFILE {
    private JFrame frame;
    private JTextField nameField, qualificationField, designationField, subjectField, dobField, dojField;
    private JButton editButton, saveButton, backButton;

    public TEACHERPROFILE() {
        frame = new JFrame("Teacher Profile");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JLabel collegeLabel = new JLabel("ABC Engineering College", JLabel.CENTER);
        collegeLabel.setFont(new Font("Arial", Font.BOLD, 16));
        frame.add(collegeLabel, BorderLayout.NORTH);

        JPanel panel = new JPanel(new GridLayout(7, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panel.add(new JLabel("Name:"));
        nameField = new JTextField("Dr. Rajesh Sharma");
        nameField.setEditable(false);
        panel.add(nameField);

        panel.add(new JLabel("Qualification:"));
        qualificationField = new JTextField("Ph.D. in Computer Science");
        qualificationField.setEditable(false);
        panel.add(qualificationField);

        panel.add(new JLabel("Designation:"));
        designationField = new JTextField("Professor");
        designationField.setEditable(false);
        panel.add(designationField);

        panel.add(new JLabel("Subject:"));
        subjectField = new JTextField("Data Structures");
        subjectField.setEditable(false);
        panel.add(subjectField);

        panel.add(new JLabel("Date of Birth:"));
        dobField = new JTextField("10/05/1980");
        dobField.setEditable(false);
        panel.add(dobField);

        panel.add(new JLabel("Date of Joining:"));
        dojField = new JTextField("15/07/2010");
        dojField.setEditable(false);
        panel.add(dojField);

        frame.add(panel, BorderLayout.CENTER);

        // Buttons Panel
        JPanel buttonPanel = new JPanel();
        editButton = new JButton("Edit");
        saveButton = new JButton("Save");
        saveButton.setVisible(false); // Initially hidden
        backButton = new JButton("Back");

        buttonPanel.add(editButton);
        buttonPanel.add(saveButton);
        buttonPanel.add(backButton);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Edit button action
        editButton.addActionListener(e -> toggleEditMode());

        // Save button action
        saveButton.addActionListener(e -> saveChanges());

        // Back button action
        backButton.addActionListener(e -> {
            frame.dispose();
            new DASHBOARD();
        });

        frame.setVisible(true);
    }

    private void toggleEditMode() {
        boolean isEditable = !nameField.isEditable();
        nameField.setEditable(isEditable);
        qualificationField.setEditable(isEditable);
        designationField.setEditable(isEditable);
        subjectField.setEditable(isEditable);
        dobField.setEditable(isEditable);
        dojField.setEditable(isEditable);

        editButton.setVisible(!isEditable); // Hide Edit button
        saveButton.setVisible(isEditable); // Show Save button
    }

    private void saveChanges() {
        // Disable editing after saving
        nameField.setEditable(false);
        qualificationField.setEditable(false);
        designationField.setEditable(false);
        subjectField.setEditable(false);
        dobField.setEditable(false);
        dojField.setEditable(false);

        editButton.setVisible(true); // Show Edit button
        saveButton.setVisible(false); // Hide Save button

        JOptionPane.showMessageDialog(frame, "Changes saved successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        new TEACHERPROFILE();
    }
}