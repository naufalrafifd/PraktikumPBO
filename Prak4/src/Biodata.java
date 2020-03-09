import java.awt.Color;
import java.awt.Font;
import javax.swing.*;

public class Biodata {
public static void main(String[] args) {
        GUI g = new GUI();
    }
}

class GUI extends JFrame {
    //frame
    final JTextField alamat = new JTextField(10);
    JLabel judul = new JLabel ("BIODATA DIRI");
    JLabel gambar;
    Font font = new Font("Tahoma", Font.BOLD,16);
    Font fontt = new Font("Tahoma", Font.PLAIN,16);
    JLabel title = new JLabel("Biodata Diri");
    JLabel nama = new JLabel ("Naufal Rafif D");
    JLabel ttl = new JLabel ("Sleman, 30 November 1999");
    JLabel agama = new JLabel(" Agama ");
        String[] namaagama = {"Islam","Katolik","Kristen","Budha","Hindu"};
    JComboBox boxagama = new JComboBox(namaagama);
    JRadioButton laki = new JRadioButton(" Laki-laki ");
    JRadioButton perempuan = new JRadioButton("Perempuan ");
    JLabel lalamat = new JLabel ("Alamat");
    JButton tombolEdit = new JButton("Edit");
    JButton tombolSave = new JButton("Save");

public GUI(){
    
    
    setTitle("Biodata Diri");
    title.setFont(font);
    title.setForeground(Color.blue);
    nama.setFont(fontt);
    ttl.setFont(fontt);
    agama.setFont(fontt);
    boxagama.setFont(fontt);
    laki.setFont(fontt);
    perempuan.setFont(fontt);
    lalamat.setFont(font);
    lalamat.setForeground(Color.blue);
    setDefaultCloseOperation(3);
    setSize(340,560);
    setLocation(750,250);
    ButtonGroup group = new ButtonGroup();
        group.add(laki);
        group.add(perempuan); 
    
    gambar = new JLabel (new ImageIcon (getClass().getResource(("nopal.jpg"))));
    
    //set layout
        setLayout (null);
        add(title);
        add(gambar);
        add(nama);
        add(ttl);
        add(boxagama);
        add(laki);
        add(perempuan);
        add(lalamat);
        add(alamat);
        add(tombolEdit);
        add(tombolSave);
    
    //set bounds   
    
    title.setBounds(113,20,120,20);
    gambar.setBounds(100,55,120,120);
    nama.setBounds(110,190,120,20);
    ttl.setBounds(60,210,200,20);
    agama.setBounds(100,230,90,20);
    boxagama.setBounds(45,250,230,20);
    laki.setBounds(35,280,120,20);
    perempuan.setBounds(185,280,120,20);
    lalamat.setBounds(130,310,120,20);
    alamat.setBounds(45,330,230,100);
    tombolEdit.setBounds(45,450,90,30);
    tombolSave.setBounds(185,450,90,30);
    setVisible(true);
}}