/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prak2;

import java.util.Scanner;

/**
 *
 * @author apple
 */
public class Main {

    /**
     * @param args the command line arguments
     */ 
    public static void main(String[] args) {
      double UTS, UAS,Harian1,Harian2,Harian3;
      Siswa data = new Siswa();
      data.setNama("Naufal Rafif");
      data.setNIS("28");
      data.setKelas("A");
      data.setMatapel("Matematika");
      
      System.out.println("Nama           = " + data.getNama());
      System.out.println("Nomor Absen    = " + data.getNIS());
      System.out.println("Kelas          = " + data.getKelas());
      System.out.println("Mata Pelajaran = " + data.getMatapel());
      System.out.println("");
      
      Scanner input = new Scanner(System.in);
      System.out.print("Ulangan Harian 1        = ");
      Harian1 = input.nextDouble();
      System.out.print("Ulangan Harian 2        = ");
      Harian2 = input.nextDouble();
      System.out.print("Ulangan Harian 3        = ");
      Harian3 = input.nextDouble();
      System.out.print("Ulangan Tengah Semester = ");
      UTS = input.nextDouble();
      System.out.print("Ulangan Akhir Semester  = ");
      UAS = input.nextDouble();
      
      Ulangan p = new Ulangan(UTS, UAS,Harian1,Harian2,Harian3);
      System.out.println("===Nilai Siswa===");
      System.out.println("Ulangan Harian 1        = " + Harian1);
      System.out.println("Ulangan Harian 2        = " + Harian2);
      System.out.println("Ulangan Harian 3        = " + Harian3);
      System.out.println("Ulangan Tengah Semester = " + UTS);
      System.out.println("Ulangan Akhir Semester  = " + UAS);
      p.tampil();
    }
    
}
