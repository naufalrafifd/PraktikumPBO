/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas3;

import static java.lang.System.exit;
import java.util.Scanner;

/**
 *
 * @author lenovo
 */
public class main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean lanjut = true;
        
        do {
        System.out.println("Pilihan Menu");
        System.out.println("1. Balok");
        System.out.println("2. Kerucut");
        System.out.println("3. Limas");
        System.out.println("4. Exit");
        
        System.out.print("Masukan Pilihan : ");
        int pilih = input.nextInt();
        
        switch(pilih){
            case 1 :
                exception balok=new exception();
                exception.Balok();
                
                break;
            case 2 :
                exception kerucut=new exception();
                exception.Kerucut();
                break;
            case 3 :
                exception limas=new exception();
                exception.Limas();
                break;
                
            case 4:
                {
                    exit(0);
                }
                break;
        }
        
        }while (lanjut);
    }
    
}
