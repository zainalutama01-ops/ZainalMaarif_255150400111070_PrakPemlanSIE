import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    Node root;

    public void add(int data) {
        if (root == null) {
            root = new Node(data);
            return;
        }
        root.add(data);
    }

    public void preTraverse(Node node) {
        if (node == null) return;
        System.out.printf("[%d] ", node.data);
        preTraverse(node.left);
        preTraverse(node.right);
    }

    public void inTraverse(Node node) {
        if (node == null) return;
        inTraverse(node.left);
        System.out.printf("[%d] ", node.data);
        inTraverse(node.right);
    }

    public void postTraverse(Node node) {
        if (node == null) return;
        postTraverse(node.left);
        postTraverse(node.right);
        System.out.printf("[%d] ", node.data);
    }

    public int countNodes(Node node) {
        if (node == null) {
            return 0; 
        }
        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    public int countLeaves(Node node) {
        if (node == null) {
            return 0; 
        }
        if (node.left == null && node.right == null) {
            return 1; 
        }
        return countLeaves(node.left) + countLeaves(node.right);
    }

    public int height(Node node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public void levelTraverse(Node node) {
        if (node == null) return;
        
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        
        while (!q.isEmpty()) {
            Node current = q.poll();
            System.out.printf("[%d] ", current.data);
            
            if (current.left != null) {
                q.add(current.left);
            }
            
            if (current.right != null) {
                q.add(current.right);
            }
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        
        int[] angka = {49, 18, 55, 88, 76, 80, 52, 24, 79, 43};
        
        System.out.println("--- Proses Insert Angka ---");
        for (int nilai : angka) {
            System.out.printf("Nilai %d dimasukkan.\n", nilai);
            tree.add(nilai);
        }

        System.out.println("\n--- Hasil Traversal ---");
        System.out.print("Pre-order   : ");
        tree.preTraverse(tree.root);
        
        System.out.print("\nIn-order    : ");
        tree.inTraverse(tree.root);
        
        System.out.print("\nPost-order  : ");
        tree.postTraverse(tree.root);
        
        System.out.print("\nLevel-order : ");
        tree.levelTraverse(tree.root);
        System.out.println();

        System.out.println("\n--- Hasil Perhitungan Tree ---");
        System.out.println("Total Node   : " + tree.countNodes(tree.root));
        System.out.println("Total Daun   : " + tree.countLeaves(tree.root));
        System.out.println("Tinggi Tree  : " + tree.height(tree.root));
    }
}