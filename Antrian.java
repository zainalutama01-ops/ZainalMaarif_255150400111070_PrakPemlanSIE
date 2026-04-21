import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Antrian {
    public static void main(String[] args) {
        // Deklarasi tetap Queue, tapi implementasi LinkedList
        Queue<String> queue = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            System.out.println("\nMenu Antrian Pelanggan: ");
            System.out.println("1. Tambah Pelanggan");
            System.out.println("2. Layani Pelanggan");
            System.out.println("3. Tampilkan Antrian");
            System.out.println("4. Cek Antrian Paling Depan");
            System.out.println("5. Keluar");
            System.out.print("Pilih (1-5): ");
            
            try {
                int choice = sc.nextInt();
                sc.nextLine(); // membersihkan newline
                
                switch (choice) {
                    case 1:
                        System.out.print("Masukan Nama Pelanggan: ");
                        String name = sc.nextLine();
                        
                        //Jalur VIP Khusus Budi
                        if (name.equalsIgnoreCase("Budi")) {
                            // Casting queue jadi LinkedList buat ngakses fitur addFirst (tambah di depan)
                            ((LinkedList<String>) queue).addFirst(name);
                            System.out.println(name + " masuk lewat jalur VIP! Ditambahkan ke antrian paling depan.");
                        } else {
                            queue.add(name); // Orang biasa tetap masuk lewat belakang
                            System.out.println(name + " ditambahkan ke antrian.");
                        }
                        
                        break;
                    case 2:
                        if (queue.isEmpty()) {
                            System.out.println("Antrian kosong.");
                        } else {
                            String nama = queue.poll();
                            System.out.println("Melayani pelanggan: " + nama);
                        }
                        break;
                    case 3:
                        System.out.println("Antrian Saat Ini: " + queue);
                        break;
                    case 4:
                        if (queue.isEmpty()) {
                            System.out.println("Tidak ada antrian.");
                        } else {
                            System.out.println("Pelanggan di posisi paling depan: " + queue.peek());
                        }
                        break;
                    case 5:
                        System.out.println("Keluar.");
                        sc.close();
                        return;
                    default:
                        throw new Exception("Invalid input.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input.");
                sc.nextLine(); 
            }
        }
    }
}