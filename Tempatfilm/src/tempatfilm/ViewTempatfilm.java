/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tempatfilm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

public class ViewTempatfilm extends JFrame{
  //tampilan saja
     JLabel lFilm= new JLabel("Tempat FILM");
   JTextField tfNo = new JTextField(); 
   JTextField tfID = new JTextField();
   JLabel lJudul= new JLabel("Judul :");
   JTextField tfJudul = new JTextField();
   JLabel lTipe = new JLabel("Tipe :");
   JTextField tfTipe = new JTextField();
   JLabel lStatus = new JLabel("Status :");
   String[] namaStatus =
            {" Belum"," Selesai"};
   JComboBox cmbStatus = new JComboBox(namaStatus);

   JLabel lEpisode = new JLabel("Episode :");
   JTextField tfEpisode = new JTextField();
   JLabel lRating = new JLabel("Rating :");
   JTextField tfRating = new JTextField();
   JLabel lGenre = new JLabel("Genre :");
   JTextField tfGenre = new JTextField();
   
   JButton btnSearch = new JButton("Search");
   JTextField tfSearch = new JTextField();
   JButton btnRefershPanel = new JButton("Refesh");
   JButton btnCreatePanel = new JButton("Create");
   JButton btnUpdatePanel = new JButton("Update");
   JButton btnDeletePanel = new JButton("Delete");
   JButton btnExitPanel = new JButton("Exit");
   
   JTable tabel;
   DefaultTableModel tableModel;
   JScrollPane scrollPane;
   Object namaKolom[] = {"ID","Judul","Tipe","Episode","Genre","Status","Rating"};
   
   public ViewTempatfilm(){
       tableModel = new DefaultTableModel (namaKolom,0);
       tabel = new JTable(tableModel);
       scrollPane = new JScrollPane(tabel);
       
       setDefaultCloseOperation(EXIT_ON_CLOSE);
       //setVisible(true);
       setLayout(null);
       setSize(850,630);
       setLocation(225,75);
       
       add(lFilm);
       lFilm.setBounds(345,15,90,20);
      
       add(tfID);
       add(lJudul);
       lJudul.setBounds(5,350,90,20);
       add(tfJudul);
       tfJudul.setBounds(5,370,245,20);
       add(lTipe);
       lTipe.setBounds(5,390,90,20);
       add(tfTipe);
       tfTipe.setBounds(5,410,120,20);
       add(lStatus);
       lStatus.setBounds(130,390,90,20);
       add(cmbStatus);
       cmbStatus.setBounds(130,410,120,20);
       add(lEpisode);
       lEpisode.setBounds(5,430,90,20);
       add(tfEpisode);
       tfEpisode.setBounds(5,450,120,20);
       add(lRating);
       lRating.setBounds(130,430,90,20);
       add(tfRating);
       tfRating.setBounds(130,450,120,20);
       add(lGenre);
       lGenre.setBounds(5,480,90,20);
       add(tfGenre);
       tfGenre.setBounds(5,500,245,20);
       add(btnSearch);
       btnSearch.setBounds(400,370,90,20);
       add(tfSearch);
       tfSearch.setBounds(300,370,90,20);
       
       add(btnRefershPanel);
       btnRefershPanel.setBounds(300,500,90,20);
       add(btnCreatePanel);
       btnCreatePanel.setBounds(400,500,90,20);
       add(btnUpdatePanel);
       btnUpdatePanel.setBounds(500,500,90,20);
       add(btnDeletePanel);
       btnDeletePanel.setBounds(600,500,90,20);
       add(btnExitPanel);
       btnExitPanel.setBounds(700,500,90,20);

       //Tabel
       add(scrollPane);
       scrollPane.setBounds(5,85,600,200);
       scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
   
       
        btnExitPanel.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
    dispose();

        }
   });         

       setVisible(true);
   }
   
   
   public String getID(){
       return tfID.getText();
   }
   public String getJudul(){
       return tfJudul.getText();
   }
   public String getTipe(){
       return tfTipe.getText();
   }
   public String getEpisode(){
       return tfEpisode.getText();
   }
   public String getGenre(){
       return tfGenre.getText();
   }
   public String getStatus(){
       return (String) cmbStatus.getSelectedItem();
   }
   public String getRating(){
       return tfRating.getText();
   }
  
   public String getSearch(){
       return tfSearch.getText();
   }
  
 }
