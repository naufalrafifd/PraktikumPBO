/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class exception {
    private static final Scanner s = new Scanner(System.in);
    
    public static void Balok(){
        double p, l, t;
        double luasbalok, volbalok;
        
        Scanner Input = new Scanner(System.in);
        boolean inputbalok=true;
        do{
            try{
                System.out.println("=========================================");
                System.out.println("Menentukan Luas Pemukaan dan Volume Balok");
                System.out.println("=========================================");
                System.out.print("Masukan Panjang : ");
                p = Input.nextDouble();
                System.out.print("Masukan Lebar : ");
                l = Input.nextDouble();
                System.out.print("Masukan Tinggi : ");
                t = Input.nextDouble();
            
                luasbalok = 4*p*4*l + 2*l*2*t;
                volbalok = p*l*t;
                
                System.out.println("Volume : " + volbalok);
                System.out.println("Luas Permukaan : " + luasbalok);
                inputbalok=false;
            }
            catch(InputMismatchException ex){
                System.out.println(" ");
                System.out.println(ex);
                System.out.println("Error!");
                Input.nextLine();
            }
        } while(inputbalok);
    }
    
     public static void Kerucut(){
        double r, t, p;
        final double phi = 3.14;
        double luaskerucut, volkerucut;
        
        Scanner Input = new Scanner(System.in);
        boolean inputkerucut=true;
        do{
            try{
                System.out.println("=========================================");
                System.out.println("Menentukan Luas Pemukaan dan Volume Kerucut");
                System.out.println("=========================================");
                System.out.print("Masukan Jari-jari (r): ");
                r = Input.nextDouble();
                System.out.print("Masukan Tinggi    (t) : ");
                t = Input.nextDouble();
                System.out.print("Masukan Selimut   (s/p): ");
                p = Input.nextDouble();
            
                luaskerucut = phi*r*r*t*0.33;
                volkerucut = phi*r*r+phi*r*p;
                
                System.out.println("Volume : " + volkerucut);
                System.out.println("Luas Permukaan : " + luaskerucut);
                inputkerucut=false;
            }
            catch(InputMismatchException ex){
                System.out.println(" ");
                System.out.println(ex);
                System.out.println("Error!");
                Input.nextLine();
            }
        } while(inputkerucut);
    }
     public static void Limas(){
        double p,l,t;
        double luaslimas, vollimas;
        
        Scanner Input = new Scanner(System.in);
        boolean inputlimas=true;
        do{
            try{
                System.out.println("=========================================");
                System.out.println("Menentukan Luas Pemukaan dan Volume Limas Segiempat");
                System.out.println("=========================================");
                System.out.print("Masukan Panjang (P): ");
                p = Input.nextDouble();
                System.out.print("Masukan Lebar   (L) : ");
                l = Input.nextDouble();
                System.out.print("Masukan Tinggi  (T): ");
                t = Input.nextDouble();
            
                double miring = Math.sqrt(Math.pow(0.5*p,2)+ Math.pow(t, 2));
                luaslimas = 4*(miring*l*0.5) + p*l;
                vollimas  = p*l*t*0.33;
                
                System.out.println("Volume : " + vollimas);
                System.out.println("Luas Permukaan : " + luaslimas);
                inputlimas=false;
            }
            catch(InputMismatchException ex){
                System.out.println(" ");
                System.out.println(ex);
                System.out.println("Error!");
                Input.nextLine();
            }
        } while(inputlimas);
    }
}
