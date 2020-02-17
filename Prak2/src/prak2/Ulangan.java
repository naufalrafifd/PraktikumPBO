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
public class Ulangan extends Nilai {
   double ulanganhar = (Harian1+Harian2+Harian3)/3;
   double ulangansem = (UTS+UAS)/2;

    Ulangan(double UTS, double UAS, double Harian1, double Harian2, double Harian3) {
        super(UTS,UAS,Harian1,Harian2,Harian3);
    }
   @Override
   protected double Ulhar(){
      return (ulanganhar);
   }

   @Override
   protected double UTA(){
      return (ulangansem);
   }
   
   @Override
   protected double Rata(){
      return (ulanganhar+ulangansem/2);
   }
}
