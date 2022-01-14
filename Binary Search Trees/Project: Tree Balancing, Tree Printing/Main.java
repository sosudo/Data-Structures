import java.io.*;
import java.util.*;
import java.lang.*;
public class Main {
	public static void main(String[] args) {
		BST<Integer> bst = new BST<Integer>();
		bst.insert(5);
		bst.insert(7);
		bst.insert(3);
		bst.inOrderPrint();
		System.out.println(bst.exists(7));
		System.out.println(bst.exists(8));
		bst.balance();
		bst.printTree();
	}
}
class BST <T> {
    Node root;
    ArrayList<Node> array = new ArrayList<Node>();
    public void printTree() {
        ArrayList<Node> q = new ArrayList<Node>();
        q.add(root);
        Node v;
        while(q.size() != 0) {
            v = q.remove(0);
            System.out.println(v.value);
            if(v.left != null) {
                q.add(v.left);
            }
            if(v.right != null) {
                q.add(v.right);
            }
        }
    }
    public void balance() {
        Collections.sort(array);
        root = balanceHelper(array, 0, array.size()-1);
    }
    public Node balanceHelper(ArrayList<Node> x, int s, int e) {
        if(s > e) {
            return null;
        }
        int mid = (s + e)/2;
        Node node = x.get(mid);
        node.left = balanceHelper(x, s, mid-1);
        node.right = balanceHelper(x, mid+1, e);
        return node;
    }
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
        root = insertHelper(root, val, 0);
    }
    public Node insertHelper(Node root, T val, int done){
        Node inNode = new Node(val);
        if (done == 0) {
            array.add(inNode);
            done++;
        }
        if(root == null) {
            root = new Node(val);
            return root;
        }
        if(inNode.compareTo(root) <= 0) {
            root.left = insertHelper(root.left, val, done);
        } else if(inNode.compareTo(root) > 0) {
            root.right = insertHelper(root.right, val, done);
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
