/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsi;

/**
 *
 * @author Lenovo
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class PetunjukAdmin extends JFrame {
    JLabel menu = new JLabel("APLIKASI GAJIAN (ADMIN)");
    JButton tombolHome = new JButton("HOME");
    JButton tombolGaji = new JButton("Tambah");
    JButton tombolData = new JButton("Data");
    JButton tombolPetunjuk = new JButton("Petunjuk");
    JButton tombolAdmin = new JButton("Karyawan");
    
    JLabel home = new JLabel ("<html>Klik Tombol Tambah untuk Menambah data anda<br/>Klik tombol data untuk melihat data sudah masuk atau belum</html", SwingConstants.CENTER);
    
    public PetunjukAdmin() {
    
        setTitle("BERANDA ADMIN");
        setDefaultCloseOperation(3);
        setSize(800,600);
        setLocation(300,75);
        setLayout(null);
        setVisible(true);
        this.getContentPane().setBackground(Color.WHITE);
        
        add(menu);
        add(tombolHome);
        add(tombolGaji);
        add(tombolData);
        add(tombolPetunjuk);
        add(tombolAdmin);
        menu.setBounds(20,10,200,20);
        menu.setFont(new Font("",Font.CENTER_BASELINE, 15));
        tombolHome.setBounds(20,50,120,40);
        tombolGaji.setBounds(20,100,120,40);
        tombolData.setBounds(20,150,120,40);
        tombolPetunjuk.setBounds(20,200,120,40);
        tombolAdmin.setBounds(20,400,120,40);
        tombolHome.addActionListener((ActionEvent e) -> {
            AdminHome a = new AdminHome();
            dispose();
        });
        tombolGaji.addActionListener((ActionEvent e) -> {
            Tambah b = new Tambah();
            dispose();
        });
        tombolData.addActionListener((ActionEvent e) -> {
            DataAdmin c = new DataAdmin();
            dispose();
        });
        tombolPetunjuk.addActionListener((ActionEvent e) -> {
            PetunjukAdmin d = new PetunjukAdmin();
            dispose();
        });
        
        tombolAdmin.addActionListener((ActionEvent e) -> {
            Menu d = new Menu();
            dispose();
        });
        
        add(home);
        home.setBounds(300,100,400,200);
        home.setFont(new Font("",Font.CENTER_BASELINE, 15));
        
    }
    
}

