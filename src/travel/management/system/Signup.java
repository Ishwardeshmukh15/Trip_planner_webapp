package travel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;
import static java.awt.Color.*;

@SuppressWarnings("serial")
public class Signup extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JTextField tfUserName;
    private JTextField tfName;
    private JTextField tfPassword;
    JButton create, back;

    public Signup() {
        setBounds(330, 150, 720, 400);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setBackground(white);
        contentPane.setLayout(null);

        // Username
        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setForeground(DARK_GRAY);
        lblUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblUsername.setBounds(100, 80, 100, 25);
        contentPane.add(lblUsername);

        tfUserName = new JTextField();
        tfUserName.setBounds(250, 80, 180, 25);
        tfUserName.setBorder(BorderFactory.createLineBorder(blue));
        contentPane.add(tfUserName);

        // Name
        JLabel lblName = new JLabel("Name:");
        lblName.setForeground(DARK_GRAY);
        lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblName.setBounds(100, 120, 100, 25);
        contentPane.add(lblName);

        tfName = new JTextField();
        tfName.setBounds(250, 120, 180, 25);
        tfName.setBorder(BorderFactory.createLineBorder(blue));
        contentPane.add(tfName);

        // Password
        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setForeground(DARK_GRAY);
        lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblPassword.setBounds(100, 160, 100, 25);
        contentPane.add(lblPassword);

        tfPassword = new JTextField();
        tfPassword.setBounds(250, 160, 180, 25);
        tfPassword.setBorder(BorderFactory.createLineBorder(blue));
        contentPane.add(tfPassword);

        // Create Button
        create = new JButton("Create");
        create.addActionListener(this);
        create.setFont(new Font("Tahoma", Font.BOLD, 13));
        create.setBounds(140, 220, 100, 30);
        create.setBackground(BLACK);
        create.setForeground(WHITE);
        contentPane.add(create);

        // Back Button
        back = new JButton("Back");
        back.addActionListener(this);
        back.setFont(new Font("Tahoma", Font.BOLD, 13));
        back.setBounds(260, 220, 100, 30);
        back.setBackground(BLACK);
        back.setForeground(WHITE);
        contentPane.add(back);

        // Image
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/signup.png"));
        Image img = icon.getImage().getScaledInstance(180, 180, Image.SCALE_DEFAULT);
        JLabel imgLabel = new JLabel(new ImageIcon(img));
        imgLabel.setBounds(480, 80, 180, 180);
        contentPane.add(imgLabel);

        // Bordered Panel
        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 0), 2),
                "Create Account", TitledBorder.LEADING, TitledBorder.TOP,
                null, new Color(34, 139, 34)));
        panel.setBounds(40, 30, 620, 280);
        panel.setBackground(white);
        panel.setLayout(null);
        contentPane.add(panel);

        // Bring all elements to front
        contentPane.setComponentZOrder(panel, contentPane.getComponentCount() - 1);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == create) {
            String username = tfUserName.getText();
            String name = tfName.getText();
            String password = tfPassword.getText();

            try {
                Conn c = new Conn();
                String query = "INSERT INTO account(username, name, password) VALUES('" +
                        username + "', '" + name + "', '" + password + "')";
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Account Created Successfully");
                setVisible(false);
                new login("");

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (ae.getSource() == back) {
            setVisible(false);
            new login("").setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Signup().setVisible(true);
    }
}
