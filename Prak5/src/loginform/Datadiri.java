
package loginform;

import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class Datadiri extends JFrame {
    String nama,jenkel,agama,hobby;
    
   final JTextField fnama = new JTextField(10);

   JLabel lnama = new JLabel(" Nama Lengkap ");
   JLabel ljeniskelamin = new JLabel(" Jenis Kelamin ");

   JRadioButton rbPria = new JRadioButton(" Laki-Laki ");
   JRadioButton rbWanita = new JRadioButton("perempuan ");

   JLabel lagama = new JLabel(" Agama ");
   String[] namaAgama =
            {"Islam","Kristen","Katolik","Hindu","Budha"};
   JComboBox cmbAgama = new JComboBox(namaAgama);

   JLabel lhobby = new JLabel(" Hobby ");

   JCheckBox cbSepakbola = new JCheckBox(" Sepakbola ");
   JCheckBox cbBasket = new JCheckBox(" Basket ");

   JButton btnSave = new JButton("OK");
   
   JLabel hnama = new JLabel();
   JLabel hkelamin = new JLabel();
   JLabel hagama = new JLabel();
   JLabel hHobi = new JLabel();
   public Datadiri() {
        setTitle("Data Diri");
	setDefaultCloseOperation(3);
	setSize(350,250);
        setLocation(600,300);
	ButtonGroup group = new ButtonGroup();
	group.add(rbPria);
	group.add(rbWanita);

	setLayout(null);
	add(lnama);
	add(fnama);
	add(ljeniskelamin);
	add(rbPria);
	add(rbWanita);
	add(lagama);
	add(cmbAgama);
	add(lhobby);
	add(cbSepakbola);
	add(cbBasket);
	add(btnSave);
        add(hnama);
        add(hkelamin);
        add(hagama);
        add(hHobi);
        
	// setBounds(m,n,o,p)
	// m = posisi x; n = posisi n
	// o = panjang komponen; p = tinggi komponen
	lnama.setBounds(10,10,120,20);
	fnama.setBounds(130,10,150,20);
	ljeniskelamin.setBounds(10,35,120,20);
	rbPria.setBounds(130,35,100,20);
	rbWanita.setBounds(230,35,100,20);
	lagama.setBounds(10,60,150,20);
	cmbAgama.setBounds(130,60,150,20);
	lhobby.setBounds(10,85,120,20);
	cbSepakbola.setBounds(130,85,100,20);
	cbBasket.setBounds(230,85,150,20);
	btnSave.setBounds(100,130,120,20);
        btnSave.setBackground(new java.awt.Color(255, 52, 52));
btnSave.addActionListener((ActionEvent e) -> {
    if(fnama.getText().length()==0){
        JOptionPane.showMessageDialog(null, "Nama tidak ada");}
    else{
        nama = fnama.getText();
        
        if(rbPria.isSelected()){
            jenkel=rbPria.getText();
        }
        else if(rbWanita.isSelected()){
            jenkel=rbWanita.getText();
        }
        
        agama = (String) cmbAgama.getSelectedItem();
        
        if(cbSepakbola.isSelected()&&cbBasket.isSelected())
        {
            hobby=cbSepakbola.getText()+" dan "+cbBasket.getText();
        }
        else if(cbSepakbola.isSelected()){
            hobby=cbSepakbola.getText();
        }
        else if(cbBasket.isSelected()){
            hobby=cbBasket.getText();
        }
        
        
    Output hasil = new Output(nama,jenkel,agama,hobby);
    hasil.setVisible(true);
    }
    dispose();
});
        setVisible(true);

   }
}
