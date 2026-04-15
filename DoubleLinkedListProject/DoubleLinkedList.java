public class DoubleLinkedList {
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
            head.prev = data;
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
            data.prev = tail;
            tail = data;
        }
        size++;
    }

    void print() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    void printFromLast() {
        Node current = tail;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.prev;
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

    void removeAtIndex(int index) {
        if (index < 0 || index >= size) return;
        if (index == 0) {
            head = head.next;
            if (head != null) head.prev = null;
            else tail = null;
        } else if (index == size - 1) {
            tail = tail.prev;
            tail.next = null;
        } else {
            Node target = searchByIndex(index);
            Node prevNode = target.prev;
            Node nextNode = target.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
        }
        size--;
    }

    void removeByValue(Object value) {
        Node target = searchByValue(value);
        if (target != null) {
            if (target == head) {
                head = head.next;
                if (head != null) head.prev = null;
                else tail = null;
            } else if (target == tail) {
                tail = tail.prev;
                tail.next = null;
            } else {
                Node prevNode = target.prev;
                Node nextNode = target.next;
                prevNode.next = nextNode;
                nextNode.prev = prevNode;
            }
            size--;
        }
    }

    void insertAtIndex(int index, Node data) {
        if (index < 0 || index > size) return;
        if (index == 0) {
            addFirst(data);
        } else if (index == size) {
            addLast(data);
        } else {
            Node target = searchByIndex(index);
            Node prevNode = target.prev;
            
            data.next = target;
            data.prev = prevNode;
            prevNode.next = data;
            target.prev = data;
            size++;
        }
    }

    void insertAfter(Object value, Node data) {
        Node target = searchByValue(value);
        if (target != null) {
            if (target == tail) {
                addLast(data);
            } else {
                Node nextNode = target.next;
                data.next = nextNode;
                data.prev = target;
                target.next = data;
                nextNode.prev = data;
                size++;
            }
        }
    }

    void insertBefore(Object value, Node data) {
        Node target = searchByValue(value);
        if (target != null) {
            if (target == head) {
                addFirst(data);
            } else {
                Node prevNode = target.prev;
                data.next = target;
                data.prev = prevNode;
                prevNode.next = data;
                target.prev = data;
                size++;
            }
        }
    }

    public static void main(String[] args) {
        DoubleLinkedList list = new DoubleLinkedList();
        
        // Setup Awal
        list.addLast(new Node("A"));
        list.addLast(new Node("B"));
        list.addLast(new Node("C"));
        
        System.out.print("Kondisi Awal       : ");
        list.print();

        System.out.println("Cari nilai 'B'     : " + (list.searchByValue("B") != null ? "Ditemukan" : "Tidak Ditemukan"));
        System.out.println("Cari index ke-2    : " + list.searchByIndex(2).data);

        list.insertAtIndex(1, new Node("X"));
        System.out.print("Insert X idx 1 : ");
        list.print();

        list.insertAfter("C", new Node("Y"));
        System.out.print("Insert Y stlh C: ");
        list.print();

        list.insertBefore("A", new Node("Z"));
        System.out.print("Insert Z sblm A: ");
        list.print();

        list.removeAtIndex(3);
        System.out.print("Hapus index 3  : ");
        list.print();

        list.removeByValue("X");
        System.out.print("Hapus nilai X  : ");
        list.print();
        
        System.out.print("Cek mundur (tail)  : ");
        list.printFromLast();
    }
}