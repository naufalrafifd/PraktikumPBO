/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tempatfilm;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class ModelTempatfilm {
     static final String JDBC_DRIVER ="com.mysql.jdbc.Driver";
   static final String DB_URL = "jdbc:mysql://localhost/tempatfilm";
   static final String USER = "root";
   static final String PASS = "";
   
   Connection koneksi;
   Statement statement;
   
public  ModelTempatfilm(){
try{
    Class.forName(JDBC_DRIVER);
    koneksi = (Connection) DriverManager.getConnection(DB_URL,USER,PASS);
    System.out.println("Koneksi berhasil");
}

catch(Exception ex){
    JOptionPane.showMessageDialog(null, ex.getMessage());
    System.out.println("Koneksi gagal");
}
}


public void createFilm(String judul, String tipe,String episode, String genre, String status, String rating){
    try{
        String query="INSERT INTO `film`(`Judul`, `Tipe`, `Episode`,`Genre`,`Status`,`Rating`)VALUES('"+judul+"','"+tipe+"','"+episode+"','"+genre+"','"+status+"','"+rating+"')";
        statement =(Statement) koneksi.createStatement();
        statement.executeUpdate(query);
        System.out.println("Berhasil ditambahkan");
        JOptionPane.showMessageDialog(null, "Data berhasil Ditambahkan");
    }    
     catch (Exception sql){
         System.out.println(sql.getMessage());
         JOptionPane.showMessageDialog(null, sql.getMessage());
    }
}

public String[][] readFilm(){
    try{
        int jmlData = 0;
        String data[][]= new String[getBanyakData()][7];
        String query="Select * from `film`";
        ResultSet resultSet =statement.executeQuery(query);
        while(resultSet.next()){
            data[jmlData][0] =resultSet.getString("ID");
            data[jmlData][1] =resultSet.getString("Judul");
            data[jmlData][2] =resultSet.getString("Tipe");
            data[jmlData][3] =resultSet.getString("Episode");
            data[jmlData][4] =resultSet.getString("Genre");
            data[jmlData][5] =resultSet.getString("Status");
            data[jmlData][6] =resultSet.getString("Rating");
            jmlData++;
        }
        return data;
    }
    catch(SQLException e){
        System.out.println(e.getMessage());
        System.out.println("SQL ERROR");
        return null;
    }
}

public int getBanyakData(){
    int jmlData=0;
    try{
        statement = koneksi.createStatement();
        String query ="Select * from `film`";
        ResultSet resultSet =statement.executeQuery(query);
        while(resultSet.next()){
            jmlData++;
        }
        return jmlData;
    }
    catch(SQLException e){
        System.out.println(e.getMessage());
        System.out.println("SQL ERROR");
        return 0;
    }
}



public int getBanyakDataSearch(String getSearch){
    int jmlData=0;
    try{
        statement = koneksi.createStatement();
        String query ="Select * from `film`where `judul` like '%"+getSearch+"%'";
        ResultSet resultSet =statement.executeQuery(query);
        while(resultSet.next()){
            jmlData++;
        }
        return jmlData;
    }
    catch(SQLException e){
        System.out.println(e.getMessage());
        System.out.println("SQL ERROR");
        return 0;
    }
}


public String[][] searchFilm(String getSearch){
    try{
        
        int jmlData = 0;
        String data[][]= new String[getBanyakDataSearch(getSearch)][7];
        String query="Select * from `film` where `judul` like '%"+getSearch+"%'";
        ResultSet resultSet =statement.executeQuery(query);
        while(resultSet.next()){
            data[jmlData][0] =resultSet.getString("ID");
            data[jmlData][1] =resultSet.getString("Judul");
            data[jmlData][2] =resultSet.getString("Tipe");
            data[jmlData][3] =resultSet.getString("Episode");
            data[jmlData][4] =resultSet.getString("Genre");
            data[jmlData][5] =resultSet.getString("Status");
            data[jmlData][6] =resultSet.getString("Rating");
            jmlData++;
        }
        
        return data;
    }
    catch(SQLException e){
        System.out.println(e.getMessage());
        System.out.println("SQL ERROR");
        return null;
    }
}


public void UpdateFilm(String Id,String Judul,String Tipe, String Episode, String Genre,String Status, String Rating) {                                         
       
        try {
      
 String query ="UPDATE `film` SET `Judul` = '"+Judul+"', `Tipe` = '"+Tipe+"',`Episode` = '"+Episode+"',`Genre`= '"+Genre+"',`Status` = '"+Status+"',`Rating`= '"+Rating+"' "
         + "WHERE `ID` = '"+ Id+"'";
            statement = koneksi.createStatement();
            statement.executeUpdate(query);
                        JOptionPane.showMessageDialog(null, "data berhasil di edit");
                       
        } catch(SQLException sql){
            System.out.println(sql.getMessage());
    }
    } 

public void deleteFilm(String id){
    try{
        String query ="DELETE FROM `film` WHERE `ID` = '"+id+"'";
        statement = koneksi.createStatement();
        statement.executeUpdate(query);
        JOptionPane.showMessageDialog(null, "Berhasil Dihapus");
    }
    catch(SQLException sql){
            System.out.println(sql.getMessage());
    }
    
}

}
 