
package loginform;

import java.awt.event.ActionEvent;
import javax.swing.*;


public class Output extends JFrame{
  String nama, jenkel,agama,hobby; 
    JLabel lnama = new JLabel(" Nama Lengkap :");
    JLabel lkel = new JLabel(" Jenis Kelamin :");
    JLabel lagama = new JLabel(" Agama :");
    JLabel lhobi = new JLabel(" Hobby  :");
    JLabel hasilNama= new JLabel();
    JLabel hasilKel= new JLabel();
    JLabel hasilAgama= new JLabel();
    JLabel hasilHobi= new JLabel();
    JButton btnSelesai = new JButton("SELESAI");
    public Output(String nama,String jenkel, String agama, String hobby){
        setTitle("Output");
	setDefaultCloseOperation(3);
	setSize(350,250);
        setLocation(600,300);

        this.nama= nama;
        this.jenkel=jenkel;
        this.agama=agama;
        this.hobby=hobby;
        hasilNama.setText(nama);
        hasilKel.setText(jenkel);    
        hasilAgama.setText(agama); 
        hasilHobi.setText(hobby);
        
        setLayout(null);
        add(lnama);
        add(lkel);
        add(lagama);
        add(lhobi);
        add(hasilNama);
        add(hasilKel);
        add(hasilAgama);
        add(hasilHobi);
        add(btnSelesai);
        lnama.setBounds(10,10,120,20);
	lkel.setBounds(10,35,120,20);
        lagama.setBounds(10,60,120,20);
        lhobi.setBounds(10,90,120,20);
        hasilNama.setBounds(110,10,120,20);
	hasilKel.setBounds(110,35,120,20);
        hasilAgama.setBounds(110,60,120,20);
        hasilHobi.setBounds(110,90,120,20);
        btnSelesai.setBounds(100,130,120,20);
        btnSelesai.setBackground(new java.awt.Color(52, 170, 255));
        btnSelesai.addActionListener((ActionEvent e) -> {
            dispose();
        });
        setVisible(true);

    }
}
