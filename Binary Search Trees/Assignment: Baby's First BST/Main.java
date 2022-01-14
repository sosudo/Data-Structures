import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) {
		BST<Integer> bst = new BST<Integer>();
		bst.insert(5);
		bst.insert(7);
		bst.insert(3);
		bst.inOrderPrint();
		System.out.println(bst.exists(7));
		System.out.println(bst.exists(8));
	}
}
class BST <T> {
    Node root;
    public boolean exists(T val) {
        return existsHelper(root, val);
    }
    public boolean existsHelper(Node root, T val) {
        if(root != null) {
            if(root.value == val) {
                return true;
            } else if(root.compareTo(new Node(val)) > 0) {
                return existsHelper(root.left, val);
            } else {
                return existsHelper(root.right, val);
            } 
        }
        return false;
    }
    public void inOrderPrint() {
        inOrderHelper(root);
    }
    public void inOrderHelper(Node root) {
        if(root != null) {
            inOrderHelper(root.left);
            System.out.println(root.value);
            inOrderHelper(root.right);
        }
    }
    public void insert(T val) {
        root = insertHelper(root, val);
    }
    public Node insertHelper(Node root, T val){
        Node inNode = new Node(val);
        if(root == null) {
            root = new Node(val);
            return root;
        }
        if(inNode.compareTo(root) <= 0) {
            root.left = insertHelper(root.left, val);
        } else if(inNode.compareTo(root) > 0) {
            root.right = insertHelper(root.right, val);
        }
        return root;
    }
    public class Node implements Comparable {
        T value;
        Node left;
        Node right;
        public Node(T val) {
            value = val;
        }
        public T get() {
            return value;
        }
        public int compareTo(Object o) {
            Node node = (Node) o;
            return ((Comparable) value).compareTo((Comparable) node.get());
        }
    }
}
