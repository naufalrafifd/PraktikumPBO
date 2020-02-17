/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prak2;

/**
 *
 * @author apple
 */
public class Nilai {
   protected double UTS, UAS,Harian1,Harian2,Harian3;

   public Nilai(double uts, double uas, double ulhar1, double ulhar2, double ulhar3){
      UTS = uts;
      UAS = uas;
      Harian1 = ulhar1;
      Harian2 = ulhar2;
      Harian3 = ulhar3;
   }
   
   protected double Ulhar(){
      return 0;
   }
 
   protected double UTA(){
      return 0;
   }
   
   protected double Rata(){
      return 0;
   }
   
   public void tampil(){
      System.out.println("Rata-rata Ulangan Harian                      : "+Ulhar());
      System.out.println("Rata-rata Ulangan Tengah Semester dan Akhir   : "+UTA());
      System.out.println("Rata2 Gabungan Ulangan                        : "+Rata());
   }
    
}
