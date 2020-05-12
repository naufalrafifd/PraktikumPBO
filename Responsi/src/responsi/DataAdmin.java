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
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import static responsi.Data.JDBC_DRIVER;

public class DataAdmin extends JFrame {
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
    
    JTable tabel;
    DefaultTableModel tabelModel;
    JScrollPane scrollPane;
    Object namaKolom[] = {"ID","Nama","Alamat","No Hp","Posisi","Gaji Pokok"};
    
    JButton btnShowPanel = new JButton("Show");
    JButton btnDeletePanel = new JButton("Delete");
    JButton btnUpdatePanel = new JButton("Update");

    
    public DataAdmin() {
    
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
        
        tabelModel = new DefaultTableModel (namaKolom,0);
        tabel = new JTable(tabelModel);
        scrollPane = new JScrollPane(tabel);
        
        add(scrollPane);
        scrollPane.setBounds(150,50,600,200);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        
        add(btnShowPanel);
        btnShowPanel.setBounds(400,300,100,50);
        add(btnUpdatePanel);
        btnUpdatePanel.setBounds(300,300,100,50);
        add(btnDeletePanel);
        btnDeletePanel.setBounds(500,300,100,50);
        
btnShowPanel.addActionListener((ActionEvent e) ->{
    if (this.getBanyakData() != 0) { 
            String dataAdmin[][] = this.readAdmin(); 
            tabel.setModel((new JTable(dataAdmin, namaKolom)).getModel());
          
        } else {
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }
});

tabel.addMouseListener(new MouseAdapter() {
           @Override
           public void mouseClicked(MouseEvent e){ 
               int baris = tabel.getSelectedRow();
               int kolom = tabel.getSelectedColumn(); 
               String dataterpilih = tabel.getValueAt(baris, 0).toString();
               btnDeletePanel.addActionListener((ActionEvent f) -> {
                  deleteAdmin(dataterpilih);
                  String dataAdmin[][] = readAdmin();
                tabel.setModel(new JTable(dataAdmin,namaKolom).getModel());
                });
               
           }
        }); 
    
    }
     

int getBanyakData() {
        int jmlData = 0;
        try{
            statement = koneksi.createStatement();
            String query = "SELECT * from `admin`";
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

String[][] readAdmin() {
        try{
            int jmlData = 0;
            String data[][]=new String[getBanyakData()][6];
            String query = "Select `id_pegawai`,`nama_a`,`alamat_a`,`hp_a`,`posisi_a`,`gaji_a` from `admin`";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                data[jmlData][0] = resultSet.getString("id_pegawai");
                data[jmlData][1] = resultSet.getString("nama_a");
                data[jmlData][2] = resultSet.getString("alamat_a");
                data[jmlData][3] = resultSet.getString("hp_a");
                data[jmlData][4] = resultSet.getString("posisi_a");
                data[jmlData][5] = resultSet.getString("gaji_a");
                jmlData++;
            }
            return data;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL error");
            return null;
        }
    }
void deleteAdmin(String id) {
        try{
            String query = "DELETE FROM `admin` WHERE `id_pegawai` = '"+id+"'";
            statement = koneksi.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "berhasil dihapus" );
        }catch(SQLException sql){
            System.out.println(sql.getMessage());
        }
    }
}