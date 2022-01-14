public class Main {
	public static void main(String[] args) {
		Node<Integer> head = new Node<Integer>();
		head.value = 5;
		head.next = new Node<String>();
		head.next.value = "Hello World";
		System.out.println(head.value);
		System.out.println(head.next.value);
	}
}
class Node<T> {
    T value;
    Node next;
}
