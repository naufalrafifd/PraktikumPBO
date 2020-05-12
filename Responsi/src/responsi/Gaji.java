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
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

class Gaji extends JFrame {
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
    
    JLabel lid= new JLabel("Id Pegawai");
    JTextField tfid = new JTextField();
    JLabel lNamaP = new JLabel("Nama");
    JTextField tfNamaP = new JTextField();
    JLabel lPosisi = new JLabel("Posisi ");
    String[] namaPosisi =
            {"Diretor","Manajer","Programmer","Marketing","Supervisor"};
    JComboBox cmbPosisi = new JComboBox(namaPosisi);
    JLabel lAlamat = new JLabel("Alamat");
    JTextField tfAlamat = new JTextField();
    JLabel lHp = new JLabel("No HP");
    JTextField tfHp = new JTextField();
    JLabel lGaji = new JLabel("Gaji Pokok");
    JTextField tfGaji = new JTextField();
    JLabel lJam = new JLabel("Jam Lebur");
    JTextField tfJam = new JTextField();
    JLabel lTunjangan = new JLabel("Tunjangan");
    JTextField tfTunjangan = new JTextField();
    JLabel lPajak = new JLabel("Pajak");
    JTextField tfPajak = new JTextField();
    JLabel lTotal = new JLabel("Total Gaji");
    JTextField tfTotal = new JTextField();
    
    JButton btnRefershPanel = new JButton("Refesh");
    JButton btnCreatePanel = new JButton("Simpan");
    
    public Gaji() {
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
        add(cmbPosisi);
        cmbPosisi.setBounds(300, 90, 120, 20);
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
        add(lJam);
        lJam.setBounds(200, 170, 120, 20);
        add(tfJam);
        tfJam.setBounds(300, 170, 120, 20);
        add(lTunjangan);
        lTunjangan.setBounds(200, 190, 120, 20);
        add(tfTunjangan);
        tfTunjangan.setBounds(300, 190, 120, 20);
        add(lPajak);
        lPajak.setBounds(200, 210, 120, 20);
        add(tfPajak);
        tfPajak.setBounds(300, 210, 120, 20);
        add(lTotal);
        lTotal.setBounds(200, 230, 120, 20);
        add(tfTotal);
        tfTotal.setBounds(300, 230, 120, 20);
        
        add(btnRefershPanel);
        btnRefershPanel.setBounds(400,300,100,50);
        add(btnCreatePanel);
        btnCreatePanel.setBounds(400,370,100,50);
        
       btnCreatePanel.addActionListener((ActionEvent e) -> {
            if (tfid.getText().equals("") ) {
                JOptionPane.showMessageDialog(null, "Field tidak boleh kosong");
            } else {
                String id = tfid.getText();
                String nama = tfNamaP.getText();
                String posisi = (String) cmbPosisi.getSelectedItem();
                String alamat = tfAlamat.getText();
                String hp = tfHp.getText();
                String gaji = tfGaji.getText();
                String jam = tfJam.getText();
                long tunjangan = Long.parseLong(tfTunjangan.getText());
                long pajak = Long.parseLong(tfPajak.getText());
                long total = Long.parseLong(tfTotal.getText());
                
                this.insertPegawai(id, nama, posisi, alamat, hp, gaji, jam, tunjangan, pajak, total);
  
            }
        });
       
       
btnRefershPanel.addActionListener((ActionEvent e) -> {
          tfid.setText("");
          tfNamaP.setText("");
          tfAlamat.setText("");
          tfHp.setText("");
          tfGaji.setText("");
          tfJam.setText("");
          tfTunjangan.setText("");
          tfPajak.setText("");
          tfTotal.setText("");
          
        });
       
tfJam.addActionListener((ActionEvent e) -> {
    String jam = tfJam.getText();
    String gaji = tfGaji.getText();
    try {
        
        long a = Long.valueOf(jam);
        long b = Long.valueOf(gaji);
        long tunjangan = a * 15000;
        long pajak = b/100 *1;
        long total = b - pajak + tunjangan;
        
        
        tfTunjangan.setText(Long.toString(tunjangan));
        tfPajak.setText(Long.toString(pajak));
        tfTotal.setText(Long.toString(total));
        
    } catch (Exception a) {
        System.out.println(a.getMessage());
    }       
});

    }
            
public void insertPegawai(String id, String nama, String posisi, String alamat, String hp, String gaji, String jam, long tunjangan, long pajak, long total) {

        try{
        String query = "INSERT INTO `pegawai`(`id_pegawai`, `nama_p`, `posisi_p`, `alamat_p`, `hp_p`, `gaji_p`, `jam`, `tunjangan`, `pajak`, `total`) VALUES ('"+id+"','"+nama+"', '"+posisi+"','"+alamat+"','"+hp+"','"+gaji+"','"+jam+"','"+tunjangan+"','"+pajak+"','"+total+"')";
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
    
