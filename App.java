import java.util.Scanner;

public class App{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        

        Mobil m1 = new Mobil();
        
        System.out.print("Masukkan merk mobil 1: ");
        String merkUser1 = input.nextLine();
        m1.setMerk(merkUser1);
        
        System.out.print("Masukkan nomor polisi mobil 1: ");
        String nopolUser1 = input.nextLine();
        m1.setNopol(nopolUser1);
        
        m1.setWarna("Merah");
        m1.setKecepatan(50);
        
        
        double waktu1 = 2.0;
        double jarak1 = m1.hitungJarak(waktu1);
        m1.setJarakTempuh(jarak1);
        
        m1.display();
        
        double kecepatanMPS1 = m1.kecepatanMPerDetik();
        System.out.println("Kecepatan dalam m/s: " + kecepatanMPS1 + " m/s");
        
        System.out.println("---------------");
        
        Mobil m2 = new Mobil();
        
        System.out.print("Masukkan merk mobil 2: ");
        String merkUser2 = input.nextLine();
        m2.setMerk(merkUser2);
        
        System.out.print("Masukkan nomor polisi mobil 2: ");
        String nopolUser2 = input.nextLine();
        m2.setNopol(nopolUser2);
        
        m2.setWarna("Biru");
        m2.setKecepatan(100);
        
        double waktu2 = 2.0;
        double jarak2 = m2.hitungJarak(waktu2);
        m2.setJarakTempuh(jarak2);
        
        m2.display();
        
        double kecepatanMPS2 = m2.kecepatanMPerDetik();
        System.out.println("Kecepatan dalam m/s: " + kecepatanMPS2 + " m/s");
        
        System.out.println("---------------");
        System.out.println("Atribut pada objek m1 diubah.");
        
        m1.setWarna("Hijau");
        
        m1.display();
        
        System.out.println("Kecepatan dalam m/s: " + m1.kecepatanMPerDetik() + " m/s");
        
        input.close();
    }
}
