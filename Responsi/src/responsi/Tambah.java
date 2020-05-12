/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsi;

/**
 *
 * @author ASUS
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;

public class Tambah extends JFrame {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/responsi";
    static final String USER = "root";
    static final String PASS = "";
    
    Connection koneksi;
    Statement statement;
    
    JLabel menu = new JLabel("APLIKASI GAJIAN (ADMIN)");
    JButton tombolHome = new JButton("HOME");
    JButton tombolGaji = new JButton("Tambah");
    JButton tombolData = new JButton("Data");
    JButton tombolPetunjuk = new JButton("Petunjuk");
    JButton tombolAdmin = new JButton("Karyawan");
    
    JLabel lid= new JLabel("Id Pegawai");
    JTextField tfid = new JTextField();
    JLabel lNamaP = new JLabel("Nama");
    JTextField tfNamaP = new JTextField();
    JLabel lPosisi = new JLabel("Posisi ");
    JTextField tfPosisi = new JTextField();
    JLabel lAlamat = new JLabel("Alamat");
    JTextField tfAlamat = new JTextField();
    JLabel lHp = new JLabel("No HP");
    JTextField tfHp = new JTextField();
    JLabel lGaji = new JLabel("Gaji Pokok");
    JTextField tfGaji = new JTextField();
    
    JButton btnCreatePanel = new JButton("Simpan");
    
    public Tambah() {
        try{
            Class.forName(JDBC_DRIVER);
            koneksi = (Connection) DriverManager.getConnection(DB_URL,USER,PASS);
            System.out.println("Koneksi Berhasil");
        }catch(ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Koneksi Gagal");
        } 
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
        
        add(lid);
        lid.setBounds(200, 50, 120, 20);
        add(tfid);
        tfid.setBounds(300, 50, 120, 20);
        add(lNamaP);
        lNamaP.setBounds(200, 70, 120, 20);
        add(tfNamaP);
        tfNamaP.setBounds(300, 70, 120, 20);
        add(lPosisi);
        lPosisi.setBounds(200, 90, 120, 20);
        add(tfPosisi);
        tfPosisi.setBounds(300, 90, 120, 20);
        add(lAlamat);
        lAlamat.setBounds(200, 110, 120, 20);
        add(tfAlamat);
        tfAlamat.setBounds(300, 110, 120, 20);
        add(lHp);
        lHp.setBounds(200, 130, 120, 20);
        add(tfHp);
        tfHp.setBounds(300, 130, 120, 20);
        add(lGaji);
        lGaji.setBounds(200, 150, 120, 20);
        add(tfGaji);
        tfGaji.setBounds(300, 150, 120, 20);
        
        add(btnCreatePanel);
        btnCreatePanel.setBounds(400,370,100,50);
        

tfid.addActionListener((ActionEvent e) -> {
    String id = tfid.getText();
    try {
        String query = "SELECT * FROM `pegawai` WHERE `id_pegawai` = '" + id + "'";
        statement = koneksi.createStatement();
        ResultSet resultSet = statement.executeQuery(query); 
        while (resultSet.next()) { 
            tfNamaP.setText(resultSet.getString("Nama_P"));
            tfAlamat.setText(resultSet.getString("Alamat_P")); 
            tfHp.setText(resultSet.getString("Hp_P")); 
            tfPosisi.setText(resultSet.getString("Posisi_P")); 
            tfGaji.setText(resultSet.getString("Total")); 
        }
    } catch (SQLException sql) {
        System.out.println(sql.getMessage());
    }
       });
        
btnCreatePanel.addActionListener((ActionEvent e) -> {
            if (tfid.getText().equals("") ) {
                JOptionPane.showMessageDialog(null, "Field tidak boleh kosong");
            } else {
                String id = tfid.getText();
                String nama = tfNamaP.getText();
                String alamat = tfAlamat.getText();
                String hp = tfHp.getText();
                String posisi = tfPosisi.getText();
                String gaji = tfGaji.getText();
                
                
                this.insertAdmin(id, nama, alamat, hp, posisi, gaji);
  
            }
        });


    }
public void insertAdmin(String id, String nama, String alamat, String hp, String posisi, String gaji) {

        try{
        String query = "INSERT INTO `admin`(`id_pegawai`, `nama_a`, `alamat_a`, `hp_a`, `posisi_a`, `gaji_a`) VALUES ('"+id+"','"+nama+"', '"+alamat+"','"+hp+"','"+posisi+"','"+gaji+"')";
        statement = (Statement) koneksi.createStatement();
        statement.executeUpdate(query);
        System.out.println("Berhasil Ditambahkan");
        JOptionPane.showMessageDialog(null,"DATA TERISI");
        }catch(Exception sql){
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
        
    }

    
}
