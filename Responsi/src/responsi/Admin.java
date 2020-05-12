/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsi;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Lenovo
 */
public class Admin extends JFrame {
    String pass="admin";
    final JTextField fuser = new JTextField(10);
    final JPasswordField fpass = new JPasswordField(10);

    JLabel luser = new JLabel(" Username ");
    JLabel lpass = new JLabel(" Password ");
   
    JLabel user = new JLabel(" user : admin ");
    JLabel cpass = new JLabel(" pass : admin ");
   
    JButton btnLogin = new JButton("Login");

    public Admin() {
    
        setTitle("LOGIN");
        setDefaultCloseOperation(3);
        setSize(350,200);
        setLocation(500,275);
        setLayout(null);
        this.getContentPane().setBackground(Color.WHITE);
        
        add(luser);
        add(fuser);
        add(lpass);
        add(fpass);
        add(user);
        add(cpass);
        add(btnLogin);

        luser.setBounds(10,10,120,20);
        fuser.setBounds(140,10,150,20);
        lpass.setBounds(10,30,120,20);
        fpass.setBounds(140,30,150,20);
        user.setBounds(10,60,120,20);
        user.setFont(new Font("Monospaced",Font.CENTER_BASELINE, 10));
        cpass.setBounds(10,80,120,20);
        cpass.setFont(new Font("Monospaced",Font.CENTER_BASELINE, 10));
        btnLogin.setBounds(130,100,100,20);
    
        btnLogin.addActionListener((ActionEvent e) -> {
        if(fuser.getText().equalsIgnoreCase("admin") && pass.equalsIgnoreCase(fpass.getText()))
        {
            AdminHome x = new AdminHome();
            dispose();}
        else 
        {
            JOptionPane.showMessageDialog(null, "Username atau password Salah");
        }
        });
        setVisible(true);
    }
    
}
