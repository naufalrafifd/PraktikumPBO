/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsi;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import static responsi.Gaji.JDBC_DRIVER;

class Data extends JFrame {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/responsi";
    static final String USER = "root";
    static final String PASS = "";
    
    Connection koneksi;
    Statement statement;
    
    JLabel menu = new JLabel("APLIKASI GAJIAN");
    JButton tombolHome = new JButton("HOME");
    JButton tombolGaji = new JButton("Gaji");
    JButton tombolData = new JButton("Data");
    JButton tombolPetunjuk = new JButton("Petunjuk");
    JButton tombolAdmin = new JButton("Admin");
    
    JTable tabel;
    DefaultTableModel tabelModel;
    JScrollPane scrollPane;
    Object namaKolom[] = {"ID","Nama","Posisi","Gaji Pokok","Jam Lembur","Tunjangan","Total Gaji"};
    
    JButton btnShowPanel = new JButton("Show");
    
    public Data() {
    
        try{
            Class.forName(JDBC_DRIVER);
            koneksi = (Connection) DriverManager.getConnection(DB_URL,USER,PASS);
            System.out.println("Koneksi Berhasil");
        }catch(ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Koneksi Gagal");
        }
        
        setTitle("BERANDA");
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
            Menu a = new Menu();
            dispose();
        });
        tombolGaji.addActionListener((ActionEvent e) -> {
            Gaji b = new Gaji();
            dispose();
        });
        tombolData.addActionListener((ActionEvent e) -> {
            Data c = new Data();
            dispose();
        });
        tombolPetunjuk.addActionListener((ActionEvent e) -> {
            Petunjuk d = new Petunjuk();
            dispose();
        });
        
        tombolAdmin.addActionListener((ActionEvent e) -> {
            Admin d = new Admin();
            dispose();
        });
        
        
        tabelModel = new DefaultTableModel (namaKolom,0);
        tabel = new JTable(tabelModel);
        scrollPane = new JScrollPane(tabel);
        
        add(scrollPane);
        scrollPane.setBounds(150,50,600,200);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        
        add(btnShowPanel);
        btnShowPanel.setBounds(400,300,100,50);
        
btnShowPanel.addActionListener((ActionEvent e) ->{
    if (this.getBanyakData() != 0) { 
            String dataPegawai[][] = this.readPegawai(); 
            tabel.setModel((new JTable(dataPegawai, namaKolom)).getModel());
          
        } else {
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }
});
    
    
    }
     

int getBanyakData() {
        int jmlData = 0;
        try{
            statement = koneksi.createStatement();
            String query = "SELECT * from `pegawai`";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                jmlData++;
            }
            return jmlData;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL error");
            return 0;
        }
    }

String[][] readPegawai() {
        try{
            int jmlData = 0;
            String data[][]=new String[getBanyakData()][7];
            String query = "Select `id_pegawai`,`nama_p`,`posisi_p`,`gaji_p`,`jam`,`tunjangan`,`total` from `pegawai`";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                data[jmlData][0] = resultSet.getString("id_pegawai");
                data[jmlData][1] = resultSet.getString("nama_p");
                data[jmlData][2] = resultSet.getString("posisi_p");
                data[jmlData][3] = resultSet.getString("gaji_p");
                data[jmlData][4] = resultSet.getString("jam");
                data[jmlData][5] = resultSet.getString("tunjangan");
                data[jmlData][6] = resultSet.getString("total");
                jmlData++;
            }
            return data;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL error");
            return null;
        }
    }
    }
