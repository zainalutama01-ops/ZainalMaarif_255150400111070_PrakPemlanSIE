import java.util.Arrays;

public class Search {

    static int jumlahCekLinear = 0;
    static int jumlahCekBinary = 0;

    public static int linearSearch(int[] arr, int search) {
        jumlahCekLinear = 0; // Reset nilai setiap fungsi dipanggil
        for (int i = 0; i < arr.length; i++) {
            jumlahCekLinear++; // Menghitung proses cek
            if (arr[i] == search) return i;
        }
        return -1; // Nilai kembalian jika tidak ditemukan
    }

    public static int binarySearch(int[] arr, int search) {
        jumlahCekBinary = 0; // Reset nilai setiap fungsi dipanggil
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            jumlahCekBinary++; // Menghitung proses cek
            int mid = low + (high - low) / 2;
            if (arr[mid] == search) return mid;
            if (arr[mid] < search) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {
            2, 5, 8, 12, 15, 18, 22, 25, 29, 31, 
            35, 38, 41, 45, 48, 52, 55, 59, 62, 66, 
            71, 75, 78, 82, 85, 88, 91, 94, 97, 100
        };
        System.out.println("Data Array (30 Elemen Terurut):");
        System.out.println(Arrays.toString(arr) + "\n");

        int hasilLinear = linearSearch(arr, 88);
        System.out.println("Pencarian Linear (Angka 88)  : " + hasilLinear);

        int hasilLinearTidakAda = linearSearch(arr, 999);
        System.out.println("Pencarian Linear (Angka 999) : " + hasilLinearTidakAda);

        int hasilBinary = binarySearch(arr, 88);
        System.out.println("Pencarian Binary (Angka 88)  : " + hasilBinary);

        int hasilBinaryTidakAda = binarySearch(arr, 999);
        System.out.println("Pencarian Binary (Angka 999) : " + hasilBinaryTidakAda + "\n");

        linearSearch(arr, 88);
        binarySearch(arr, 88);
        System.out.println("--- Evaluasi Efisiensi Pencarian (Angka 88) ---");
        System.out.println("Jumlah pengecekan Linear Search : " + jumlahCekLinear + " kali");
        System.out.println("Jumlah pengecekan Binary Search : " + jumlahCekBinary + " kali\n");

        linearSearch(arr, 999);
        binarySearch(arr, 999);
        System.out.println("--- Evaluasi Efisiensi Pencarian (Angka 999) ---");
        System.out.println("Jumlah pengecekan Linear Search : " + jumlahCekLinear + " kali");
        System.out.println("Jumlah pengecekan Binary Search : " + jumlahCekBinary + " kali");
    }
}