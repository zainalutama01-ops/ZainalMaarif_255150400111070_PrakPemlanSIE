public class CustomStack {
    Node top;
    int size = 0;

    public void push(int x) {
        Node n = new Node(x);
        n.next = top;
        top = n;
        size++;
    }

    public int pop() {
        if (top == null)
            throw new RuntimeException("Stack is empty.");
        int val = top.data;
        top = top.next;
        size--;
        return val;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int peek() {
        if (top == null)
            throw new RuntimeException("Stack is empty.");
        return top.data;
    }

    public static void main(String[] args) {
        CustomStack custom = new CustomStack();
        
        // Kondisi awal (1 paling bawah, 4 paling atas)
        custom.push(1);
        custom.push(2);
        custom.push(3);
        custom.push(4);

        // Langkah 1: Keluarkan elemen di atas titik target penyisipan dan simpan
        int temp4 = custom.pop();
        int temp3 = custom.pop();
        int temp2 = custom.pop();

        // Langkah 2: Masukkan angka 5
        custom.push(5);

        // Langkah 3: Kembalikan elemen yang disimpan tadi sesuai urutan aslinya
        custom.push(temp2);
        custom.push(temp3);
        custom.push(temp4);

        // Pembuktian (Mencetak dari atas ke bawah)
        System.out.print("Isi Stack saat ini (di-pop dari atas): ");
        while (!custom.isEmpty()) {
            System.out.print("[" + custom.pop() + "]");
        }
        System.out.println();
    }
}