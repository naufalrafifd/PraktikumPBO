
package prak1;
import static java.lang.System.exit;
import java.util.Scanner;

public class main {
  
    
    public static void main(String[] args) {
        
        balok hasilbalok = new balok();
        kerucut hasilkerucut = new kerucut();
        limas hasillimas = new limas();
        
        Scanner input = new Scanner(System.in);
        boolean lanjut = true;
        String ulang;
        double x, y, z, hasil_luas, hasil_volume;
        
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
                System.out.println("Balok");
               
                System.out.print("Masukan Panjang : ");
                x = input.nextDouble();
        
                System.out.print("Masukan Lebar : ");
                y = input.nextDouble();
                
                System.out.print("Masukan Tinggi : ");
                z = input.nextDouble();
            
                hasil_volume = hasilbalok.volume(x, y, z);
                System.out.print("Volume : ");
                System.out.println(hasil_volume);
                
                hasil_luas = hasilbalok.luaspermukaan(x, y, z);
                System.out.print("Luas Permukaan : ");
                System.out.println(hasil_luas);
                
                break;
            case 2 :
                System.out.println("Kerucut");
                
                System.out.print("Masukan Jari Jari : ");
                x = input.nextDouble();
        
                System.out.print("Masukan Tinggi : ");
                y = input.nextDouble();
                
                System.out.print("Masukkan Selimut : ");
                z = input.nextDouble();
                
                hasil_volume = hasilkerucut.volume(x, y);
                System.out.print("Volume : ");
                System.out.println(hasil_volume);
                
                hasil_luas = hasilkerucut.luaspermukaan(x, z);
                System.out.print("Luas Permukaan: ");
                System.out.println(hasil_luas);
                
                break;
            case 3 :
                System.out.println("Limas");
                
                System.out.print("Masukan Panjang : ");
                x = input.nextDouble();
        
                System.out.print("Masukan Lebar : ");
                y = input.nextDouble();
            
                System.out.print("Masukan Tinggi : ");
                z = input.nextDouble();
            
                hasil_volume = hasillimas.volume(x, y, z);
                System.out.print("Volume : ");
                System.out.println(hasil_volume);
                hasil_luas = hasillimas.luaspermukaan(x, y, z);
                System.out.print("Luas Permukaan: ");
                System.out.println(hasil_luas);
                
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
