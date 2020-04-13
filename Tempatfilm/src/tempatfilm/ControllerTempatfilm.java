/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tempatfilm;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class ControllerTempatfilm {
    ModelTempatfilm modelTempatfilm;
    ViewTempatfilm viewTempatfilm;
    
    public ControllerTempatfilm(ModelTempatfilm modelTempatfilm, ViewTempatfilm viewTempatfilm){
        this.modelTempatfilm = modelTempatfilm;
        this.viewTempatfilm = viewTempatfilm;
        if(modelTempatfilm.getBanyakData() !=0){
           String dataFilm[][]= modelTempatfilm.readFilm();
           viewTempatfilm.tabel.setModel((new JTable(dataFilm, viewTempatfilm.namaKolom)).getModel());
        }
        else{
            JOptionPane.showMessageDialog(null,"Data Tidak ada");          
        }
        viewTempatfilm.btnCreatePanel.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if (viewTempatfilm.getJudul().equals("")
                        || viewTempatfilm.getTipe().equals("")
                        || viewTempatfilm.getEpisode().equals("")
                        || viewTempatfilm.getGenre().equals("")
                        || viewTempatfilm.getStatus().equals("")
                        || viewTempatfilm.getRating().equals("")){
                    JOptionPane.showMessageDialog(null, "Field tidk boleh kosong");
                       
            }else{
                    String judul = viewTempatfilm.getJudul();
                    String tipe = viewTempatfilm.getTipe();
                    String episode = viewTempatfilm.getEpisode();
                    String genre = viewTempatfilm.getGenre();
                    String status = viewTempatfilm.getStatus();
                    String rating = viewTempatfilm.getRating();
                    modelTempatfilm.createFilm(/* id,*/judul, tipe, episode, genre, status,rating);
                    
                    String dataFilm[][] = modelTempatfilm.readFilm();
                    viewTempatfilm.tabel.setModel(new JTable (dataFilm, viewTempatfilm.namaKolom).getModel());
                }
                
        }
        }); 
        
    viewTempatfilm.btnRefershPanel.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            String dataFilm[][] = modelTempatfilm.readFilm();
                    viewTempatfilm.tabel.setModel(new JTable (dataFilm, viewTempatfilm.namaKolom).getModel());
                
            viewTempatfilm.tfID.setText(null);
            viewTempatfilm.tfJudul.setText(null);
            viewTempatfilm.tfTipe.setText(null);
            viewTempatfilm.tfEpisode.setText(null);
            viewTempatfilm.tfGenre.setText(null);
            viewTempatfilm.tfRating.setText(null);
            viewTempatfilm.cmbStatus.setSelectedItem(this);
            viewTempatfilm.tfSearch.setText(null);
        }
    });
        
    viewTempatfilm.btnSearch.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
        String getSearch= viewTempatfilm.getSearch();
                String dataFilm[][] = modelTempatfilm.searchFilm(getSearch);
                    viewTempatfilm.tabel.setModel(new JTable (dataFilm, viewTempatfilm.namaKolom).getModel());
                 }
        }); 

                
    viewTempatfilm.tabel.addMouseListener(new MouseAdapter(){
        
        @Override
        public void mouseClicked(MouseEvent e){
           int baris = viewTempatfilm.tabel.getSelectedRow();
           int kolom = viewTempatfilm.tabel.getSelectedColumn();
        String dataterpilih = viewTempatfilm.tabel.getValueAt(baris, 0).toString();
        System.out.println(dataterpilih);
       
        String judul =viewTempatfilm.tabel.getValueAt(baris, 1).toString();
        viewTempatfilm.tfJudul.setText(judul);
        String tipe =viewTempatfilm.tabel.getValueAt(baris, 2).toString();
        viewTempatfilm.tfTipe.setText(tipe);
        String episode =viewTempatfilm.tabel.getValueAt(baris, 3).toString();
        viewTempatfilm.tfEpisode.setText(episode);
        String genre =viewTempatfilm.tabel.getValueAt(baris, 4).toString();
        viewTempatfilm.tfGenre.setText(genre);
        String status =viewTempatfilm.tabel.getValueAt(baris, 5).toString();
        viewTempatfilm.cmbStatus.setSelectedItem(status);
        String rating =viewTempatfilm.tabel.getValueAt(baris, 6).toString();
        viewTempatfilm.tfRating.setText(rating);        
        
        viewTempatfilm.btnUpdatePanel.addActionListener(new ActionListener(){
             @Override
             public void actionPerformed(ActionEvent e){ 
                 String id = dataterpilih;
                    
                    String judul = viewTempatfilm.getJudul();
                    String tipe = viewTempatfilm.getTipe();
                    String episode = viewTempatfilm.getEpisode();
                    String genre = viewTempatfilm.getGenre();
                    String status = viewTempatfilm.getStatus();
                    String rating = viewTempatfilm.getRating();
                    modelTempatfilm.UpdateFilm( id,judul, tipe, episode, genre, status,rating);
                

                String dataFilm[][]= modelTempatfilm.readFilm();
                viewTempatfilm.tabel.setModel(new JTable(dataFilm, viewTempatfilm.namaKolom).getModel());

     }
        });
        
       viewTempatfilm.btnDeletePanel.addActionListener(new ActionListener(){
             @Override
             public void actionPerformed(ActionEvent e){    
                    modelTempatfilm.deleteFilm(dataterpilih);
                    String dataFilm[][]= modelTempatfilm.readFilm();
                    viewTempatfilm.tabel.setModel(new JTable(dataFilm, viewTempatfilm.namaKolom).getModel());
                  
             }
        });
    
     }
       });
   
   
    }
}