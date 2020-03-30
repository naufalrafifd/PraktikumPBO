
package loginform;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class LoginForm {

   
    public static void main(String[] args) {
GUI g = new GUI();        

    }
    
}
class GUI extends JFrame {
    String pass="admin";
   final JTextField fuser = new JTextField(10);
   final JPasswordField fpass = new JPasswordField(10);

   JLabel luser = new JLabel(" Username ");
   JLabel lpass = new JLabel(" Password ");
   JButton btnOk = new JButton("Login");
   JButton btnCancel = new JButton("Cancel");

public GUI() {
    
setTitle("LOGIN");
	setDefaultCloseOperation(3);
	setSize(350,250);
        setLocation(600,300);
setLayout(null);
	add(luser);
	add(fuser);
        add(lpass);
	add(fpass);
        add(btnOk);
        add(btnCancel);
luser.setBounds(20,30,120,20);
fuser.setBounds(140,30,150,20);
lpass.setBounds(20,80,120,20);
fpass.setBounds(140,80,150,20);
btnOk.setBounds(160,130,100,20);
btnOk.setBackground(new java.awt.Color(52, 255, 55));
btnCancel.setBounds(40,130,100,20);
btnCancel.setBackground(new java.awt.Color(255, 52, 52));

        
btnOk.addActionListener((ActionEvent e) -> {
    if(fuser.getText().equalsIgnoreCase("admin") && pass.equalsIgnoreCase(fpass.getText()))
    {
        Datadiri bio = new Datadiri();
        bio.setVisible(true);
        dispose();}
    else 
    {
        JOptionPane.showMessageDialog(null, "username dan password harusnya admin soalnya belum masuk database");
    }
    
});
        setVisible(true);
}
}
