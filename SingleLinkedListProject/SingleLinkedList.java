public class SingleLinkedList {
    Node head, tail;
    int size = 0;

    void init() { head = null; }
    boolean isEmpty() { return size == 0; }
    int size() { return size; }

    void addFirst(Node data) {
        if (isEmpty()) {
            head = data;
            tail = data;
        } else {
            data.next = head;
            head = data;
        }
        size++;
    }

    void addLast(Node data) {
        if (isEmpty()) {
            head = data;
            tail = data;
        } else {
            tail.next = data;
            tail = data;
        }
        size++;
    }

    // Method bantuan untuk mencetak isi list
    void printList(String message) {
        System.out.print(message + ": ");
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    Node searchByValue(Object value) {
        Node current = head;
        while (current != null) {
            if (current.data.equals(value)) return current;
            current = current.next;
        }
        return null;
    }

    Node searchByIndex(int index) {
        if (index < 0 || index >= size) return null;
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    // c. Menghapus node di posisi (index) ke-n
    void removeAtIndex(int index) {
        if (index < 0 || index >= size) return;
        if (index == 0) {
            head = head.next;
            if (head == null) tail = null;
        } else {
            Node prev = searchByIndex(index - 1);
            prev.next = prev.next.next;
            if (prev.next == null) tail = prev;
        }
        size--;
    }

    void removeByValue(Object value) {
        if (isEmpty()) return;
        if (head.data.equals(value)) {
            head = head.next;
            if (head == null) tail = null;
            size--;
            return;
        }
        Node current = head;
        while (current.next != null) {
            if (current.next.data.equals(value)) {
                current.next = current.next.next;
                if (current.next == null) tail = current;
                size--;
                return;
            }
            current = current.next;
        }
    }

    void insertAtIndex(int index, Node data) {
        if (index < 0 || index > size) return;
        if (index == 0) {
            addFirst(data);
        } else if (index == size) {
            addLast(data);
        } else {
            Node prev = searchByIndex(index - 1);
            data.next = prev.next;
            prev.next = data;
            size++;
        }
    }

    void insertAfter(Object value, Node data) {
        Node target = searchByValue(value);
        if (target != null) {
            data.next = target.next;
            target.next = data;
            if (target == tail) tail = data;
        }
    }

    void insertBefore(Object value, Node data) {
        if (isEmpty()) return;
        if (head.data.equals(value)) {
            addFirst(data);
            return;
        }
        Node current = head;
        while (current.next != null) {
            if (current.next.data.equals(value)) {
                data.next = current.next;
                current.next = data;
                size++;
                return;
            }
            current = current.next;
        }
    }

    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();
        
        // Setup awal: A -> B -> C
        list.addLast(new Node("A"));
        list.addLast(new Node("B"));
        list.addLast(new Node("C"));
        list.printList("Kondisi Awal");

        // Test a & b: Pencarian
        System.out.println("Cari nilai 'B': " + (list.searchByValue("B") != null ? "Ditemukan" : "Tidak Ditemukan"));
        System.out.println("Cari index ke-2: " + list.searchByIndex(2).data);

        // Test e: Insert di index ke-1
        list.insertAtIndex(1, new Node("X"));
        list.printList("Insert 'X' di index 1 (Test e)");

        // Test f: Insert setelah 'C'
        list.insertAfter("C", new Node("Y"));
        list.printList("Insert 'Y' setelah 'C' (Test f)");

        // Test g: Insert sebelum 'A'
        list.insertBefore("A", new Node("Z"));
        list.printList("Insert 'Z' sebelum 'A' (Test g)");

        // Test c: Hapus index ke-3 (nilai 'B')
        list.removeAtIndex(3);
        list.printList("Hapus index 3 (Test c)");

        // Test d: Hapus nilai 'X'
        list.removeByValue("X");
        list.printList("Hapus nilai 'X' (Test d)");
    }
}