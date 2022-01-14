import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("polish.txt"));
		Stack polish = new Stack();
		String input;
		char opcode;
		int n1;
		int n2;
		while(in.hasNext()) {
		    input = in.next();
		    try {
		        polish.push(Integer.parseInt(input));
		    } catch (Exception e) {
			n1 = polish.pop();
			n2 = polish.pop();
		        opcode = input.charAt(0);
		        if(opcode == '+') {
		            polish.push(n2+n1);
		        } else if(opcode == '-') {
		            polish.push(n2-n1);
		        } else if(opcode == '*') {
		            polish.push(n2*n1);
		        } else if(opcode == '/') {
		            polish.push(n2/n1);
		        } else {}
		    }
		}
		System.out.println(polish.peek());
	}
}
class Stack {
    Node top;
    public void push(int p) {
        Node n = new Node(p);
        n.next = top;
        top = n;
    }
    public Integer peek() {
        if (top == null) return null;
        return top.value;
    }
    public Integer pop() {
        if (top == null) return null;
        Node oldtop = top;
        top = top.next;
        oldtop.next = null;
        return oldtop.value;
    }
    public class Node {
        int value;
        Node next;
        public Node(int x) {
            value = x;
        }
    }
}
