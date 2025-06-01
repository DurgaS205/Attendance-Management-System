import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LOGIN {
    private JFrame frame;
    private JTextField userText;
    private JPasswordField passText;

    public LOGIN() {
        // Create frame
        frame = new JFrame("ABC College of Engineering");
        frame.setSize(400, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Background Image
        ImageIcon backgroundIcon = new ImageIcon("img1.jpg");
        JLabel background = new JLabel(backgroundIcon);
        background.setBounds(0, 0, 400, 250);
        frame.setContentPane(background);

        // Transparent panel on top
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setOpaque(false);
        panel.setBounds(0, 0, 400, 250);

        // Title label
        JLabel titleLabel = new JLabel("ABC College of Engineering", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titleLabel.setBounds(50, 10, 300, 30);
        panel.add(titleLabel);

        // Username Label and Text Field
        JLabel userLabel = new JLabel("USERNAME:");
        userLabel.setBounds(50, 60, 100, 25);
        panel.add(userLabel);

        userText = new JTextField();
        userText.setBounds(150, 60, 150, 25);
        panel.add(userText);

        // Password Label and Password Field
        JLabel passLabel = new JLabel("PASSWORD:");
        passLabel.setBounds(50, 100, 100, 25);
        panel.add(passLabel);

        passText = new JPasswordField();
        passText.setBounds(150, 100, 150, 25);
        panel.add(passText);

        // Login Button
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(150, 140, 100, 30);
        panel.add(loginButton);

        // Login button action
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = userText.getText();
                String password = new String(passText.getPassword());

                if (username.equals("JavaLab") && password.equals("123456")) {
                    JOptionPane.showMessageDialog(frame, "Login Successful!");
                    frame.dispose(); // Close login window
                    new DASHBOARD(); // Directly open dashboard
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid Username or Password!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        frame.add(panel);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new LOGIN();
    }
}
