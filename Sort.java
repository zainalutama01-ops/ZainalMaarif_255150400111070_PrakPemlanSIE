import java.util.Arrays;

public class Sort {

    public static int[] insertion(int[] list) {
        int tukarAtauGeser = 0; 
        for (int i = 1; i < list.length; ++i) {
            int key = list[i];
            int k = i - 1;
            while (k >= 0 && list[k] > key) {
                list[k + 1] = list[k];
                k = k - 1;
                tukarAtauGeser++; 
            }
            list[k + 1] = key;
        }
        System.out.println("Jumlah geser/tukar (Insertion) : " + tukarAtauGeser);
        return list;
    }

    public static int[] selection(int[] list) {
        int tukarAtauGeser = 0; 
        for (int i = 0; i < list.length - 1; i++) {
            int minIndex = i;
            for (int k = i + 1; k < list.length; k++) {
                if (list[k] < list[minIndex]) {
                    minIndex = k;
                }
            }
            int t = list[minIndex];
            list[minIndex] = list[i];
            list[i] = t;
            tukarAtauGeser++; 
        }
        System.out.println("Jumlah geser/tukar (Selection) : " + tukarAtauGeser);
        return list;
    }

    public static int[] bubble(int[] list) {
        int tukarAtauGeser = 0; 
        for (int i = 0; i < list.length - 1; i++) {
            for (int k = i + 1; k < list.length; k++) {
                if (list[k] < list[i]) {
                    int t = list[i];
                    list[i] = list[k];
                    list[k] = t;
                    tukarAtauGeser++; 
                }
            }
        }
        System.out.println("Jumlah geser/tukar (Bubble)    : " + tukarAtauGeser);
        return list;
    }

    public static void main(String[] args) {
        int[] arr = {
            42, 17, 89, 5, 63, 21, 95, 34, 78, 12, 
            56, 3, 91, 28, 74, 19, 85, 47, 60, 8, 
            99, 31, 68, 14, 53, 26, 70, 9, 82, 38
        };

        System.out.println("Array Belum Terurut:");
        System.out.println(Arrays.toString(arr));

        System.out.println("\n--- Hasil Uji Efisiensi Sorting ---");
        int[] sortedInsertion = insertion(arr.clone());
        int[] sortedBubble = bubble(arr.clone());
        int[] sortedSelection = selection(arr.clone());

        System.out.println("\nArray Sesudah Diurutkan:");
        System.out.println("Insertion Sort : " + Arrays.toString(sortedInsertion));
        System.out.println("Bubble Sort    : " + Arrays.toString(sortedBubble));
        System.out.println("Selection Sort : " + Arrays.toString(sortedSelection));
    }
}