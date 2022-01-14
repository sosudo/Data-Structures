/**
* Main.java
* @author Shivansh Gour
* @throws IOException
* This class creates a Linked List based off of numerical inputs through a text
file, then prints the contents of the Linked List.
* Runs in O(n) time
*/
// Necessary imports
import java.io.*;
import java.util.Scanner;
// Node class
// Note: I didn't feel like making it its own file
class Node {
    int value;
    Node next;
    // Class constructor
    public Node() {}
    // Overloading the constructor in the case of a numerical parameter
    public Node(int v) {
        value = v;
    }
}
public class Main {
    // Must throw IOException to use File()
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("nums.txt")); // Setting stdin to the
        specified file
        Node head = new Node(); // Instantiating the linked list
        Node curr = head; // Referencing curr to the head node
        curr.value = in.hasNextLine() ? in.nextInt() : null; // If the first line of the file is empty, we set the value of curr to null
        // While the file has not been fully traversed, instantiate and set the value of the next node to the input, then move to that node
        /* We choose to instantiate the next node first since the 0th node is already
        filled by the previous line,
        so the next empty node is always one node ahead of curr */
        while (in.hasNextLine()) {
            curr.next = new Node(in.nextInt());
            curr = curr.next;
        }
        curr = head; // Reset curr to the head node
        // Print out the Linked List
        while (curr != null) {
            System.out.println(curr.value);
            curr = curr.next;
        }
    }
}
