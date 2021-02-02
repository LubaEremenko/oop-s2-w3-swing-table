package com.company;

import com.sun.jdi.connect.spi.Connection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;

public class UserLogin extends JFrame {


    private JTextField textField;
    private JPasswordField passwordField;
    private JPanel contentPane;
    private JButton btnNewButton;


    public static void main(String[] args) {
        // write your code here
        System.out.println("this is user login");

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UserLogin frame = new UserLogin();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


    }

    public UserLogin() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(450, 190, 1014, 597);
    setResizable(false);
    contentPane = new JPanel();
    setContentPane(contentPane);
    contentPane.setLayout(null);


        //login label
        JLabel lblNewLabel = new JLabel("Login here");
        lblNewLabel.setForeground(Color.BLUE);
        lblNewLabel.setFont(new Font("Times New Roman", Font.ITALIC, 46));
        lblNewLabel.setBounds(423, 13, 273, 93);
        contentPane.add(lblNewLabel);


        //username label
        JLabel lblUsername = new JLabel("Username");
        lblUsername.setForeground(Color.BLACK);
        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 32));
        lblUsername.setBounds(250, 166, 193, 52);
        contentPane.add(lblUsername);

        textField = new JTextField();
        textField.setFont(new Font("Tahoma", Font.ITALIC, 36));
        textField.setBounds(481, 170, 281, 68);
        textField.setColumns(1);
        contentPane.add(textField);

        //password label
        JLabel lblPassword = new JLabel("Password");
        lblPassword.setForeground(Color.BLACK);
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 31));
        lblPassword.setBounds(250, 286, 193, 52);
        contentPane.add(lblPassword);

        //password field
        passwordField = new JPasswordField();
        passwordField.setForeground(Color.green);
        passwordField.setFont(new Font("Times New Roman", Font.BOLD, 52));
        passwordField.setBounds(481, 286, 281, 68);
        contentPane.add(passwordField);


    //button
    btnNewButton = new JButton("Login");
    btnNewButton.setFont(new Font ("Tahoma", Font.BOLD, 26));
    btnNewButton.setBounds(545, 395, 162, 73);
    contentPane.add(btnNewButton);


    btnNewButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String userName = textField.getText();
            String password = passwordField.getText();
            System.out.println("Button is pressed: " + userName + ": " + password);

            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/titanicmanifest", "root", "Memory1979@");

                PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement("select name, password from student where name = ? and password = ?");
                preparedStatement.setString(1, userName);
                preparedStatement.setString(2, password);

                ResultSet rs = preparedStatement.executeQuery();
                if (rs.next()) {
                    System.out.println("Loggin in");
                    JOptionPane.showMessageDialog(btnNewButton, "successfully logged in");

                } else {
                    System.out.println("Not allowed to login");
                    JOptionPane.showMessageDialog(btnNewButton, "wrong username and password");

                }


            } catch (Exception e) {
                System.out.println(e);
            } finally {

            }

        }
    });


    }




}
