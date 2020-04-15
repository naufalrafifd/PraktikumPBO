/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perpustakaan;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

        
public class Perpustakaan {
 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Awal awal = new Awal();
        //DataKaryawan d = new DataKaryawan ();
    }
    
    
}

class Awal extends JFrame {
    JLabel menuutama = new JLabel ("Menu Utama");
    JButton btnBuku = new JButton("Data Buku");
    JButton btnAnggota = new JButton("Data Anggota");
    JButton btnKaryawan = new JButton("Data Karyawan");
    JButton btnPinjam = new JButton("Data Peminjaman");
    
    public Awal(){
        setTitle("Beranda");
	setDefaultCloseOperation(3);
        setSize(350,250);
        setLocation(500,275);
        setLayout(null);

        menuutama.setBounds(125,30,120,40);
        btnAnggota.setBounds(10,80,140,40);
        btnKaryawan.setBounds(10,140,140,40);
        btnBuku.setBounds(180,80,140,40);
        btnPinjam.setBounds(180,140,140,40);
    
        
        add(btnAnggota);
        add(btnBuku);
        add(btnKaryawan);
        add(btnPinjam);
        add(menuutama);
        setVisible(true);
        
        btnAnggota.addActionListener((ActionEvent e) -> {
           DataAnggota anggota = new DataAnggota();
           dispose();
        });
        
        btnBuku.addActionListener((ActionEvent e) -> {
           DataBuku buku = new DataBuku();
           dispose();
        });
        
        btnKaryawan.addActionListener((ActionEvent e) -> {
           DataKaryawan karyawan = new DataKaryawan();
           dispose();
        });
        
        btnPinjam.addActionListener((ActionEvent e) -> {
           DataPinjam pinjam = new DataPinjam();
           dispose();
        });
    }
}
