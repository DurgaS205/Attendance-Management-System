import javax.swing.*;
import java.awt.*;

public class DASHBOARD {
    private JFrame frame;

    public DASHBOARD() {
        frame = new JFrame("Dashboard - Java");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(3, 2, 10, 10));

        // Create Buttons
        JButton attendanceButton = new JButton("Attendance");
        JButton profileButton = new JButton("Profile");
        JButton studentButton = new JButton("Students");
        JButton logoutButton = new JButton("Logout");

        // Add Actions to Buttons
        attendanceButton.addActionListener(e -> openAttendance());
        profileButton.addActionListener(e -> openProfile());
        studentButton.addActionListener(e -> openStudentMarks());
        logoutButton.addActionListener(e -> logout());

        // Add Buttons to Frame
        frame.add(attendanceButton);
        frame.add(profileButton);
        frame.add(studentButton);
        frame.add(logoutButton);

        frame.setVisible(true);
    }

    private void openAttendance() {
        frame.dispose(); // Close Dashboard
        new ATTENDANCE(); // Open Attendance window
    }

    private void openProfile() {
        frame.dispose(); // Close Dashboard
        new TEACHERPROFILE(); // Open Teacher Profile window
    }

    private void openStudentMarks() {
        frame.dispose(); // Close Dashboard
        new STUDENTMARKS(); // Open Student Marks window
    }

    private void logout() {
        int choice = JOptionPane.showConfirmDialog(frame, "Are you sure you want to logout?", "Logout", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            frame.dispose(); // Close Dashboard window
            new LOGIN(); // Open Login window
        }
    }

    // Main method to run the class
    public static void main(String[] args) {
        new DASHBOARD();
    }
}
