public class CustomQueue {
    private Node head, tail;
    private int size = 0;

    public void enqueue(int x) {
        Node n = new Node(x);
        if (tail != null) tail.next = n;
        tail = n;
        if (head == null) head = tail;
        size++;
    }

    public int dequeue() {
        if (head == null)
            throw new RuntimeException("Queue is empty.");
        int val = head.data;
        head = head.next;
        if (head == null) tail = null;
        size--;
        return val;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("Queue kosong.");
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public int peek() {
        if (head == null) {
            throw new RuntimeException("Queue is empty.");
        }
        return head.data; // Cuma ngembaliin nilai, nggak ngubah posisi head
    }

    public static void main(String[] args) {
        CustomQueue queue = new CustomQueue();
        
        // Setup awal antrian
        queue.enqueue(5);
        queue.enqueue(15);
        queue.enqueue(25);
        
        System.out.println("Demo Jawab Nomor 4");
        
        System.out.print("Isi queue SEBELUM peek : ");
        queue.print(); 
        
        // Demo memanggil method peek()
        System.out.println("Data paling depan (peek): " + queue.peek()); 
        
        System.out.print("Isi queue SESUDAH peek  : ");
        queue.print(); 
    }
}