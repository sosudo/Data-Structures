import java.util.Scanner;
import java.io.*;
public class Main {
  public static void main(String[] args) throws IOException {
    Scanner one = new Scanner(new File("1.txt"));
    Scanner two = new Scanner(new File("2.txt"));
    Node h1 = new Node();
    Node h2 = new Node();
    h1.next = new Node();
    h2.next = new Node();
    h1.value = one.nextInt();
    h2.value = two.nextInt();
    Node c1 = h1.next;
    Node c2 = h2.next;
    c1.value = one.nextInt();
    c2.value = two.nextInt();
    c1.prev = h1;
    c2.prev = h2;
    Node p1;
    Node p2;
    while(one.hasNext()) {
      c1.next = new Node();
      p1 = c1;
      c1 = c1.next;
      c1.prev = p1;
      c1.value = one.nextInt();
    }
    while(two.hasNext()) {
      c2.next = new Node();
      p2 = c2;
      c2 = c2.next;
      c2.prev = p2;
      c2.value = two.nextInt();
    }
    one.close();
    two.close();
    c1 = h1;
    c2 = h2;
    while(c1.next != null) {
      c1 = c1.next;
    }
    while(c2.next != null) {
      c2 = c2.next;
    }
    boolean go = true;
    int sum;
    int carry = 0;
    int last;
    Node h3 = new Node();
    Node c3 = h3;
    Node p3;
    while(go) {
      if(c1 == null && c2 == null) {
        go = false;
        break;
      } else if (c1 == null && c2 != null) {
        sum = c2.value + carry;
        last = sum % 10;
        carry = (sum-last)/10;
        c2 = c2.prev;
        c3.value = last;
        c3.next = new Node();
        p3 = c3;
        c3 = c3.next;
        c3.prev = p3;
      } else if (c1 != null && c2 == null) {
        sum = c1.value + carry;
        last = sum % 10;
        carry = (sum-last)/10;
        c1 = c1.prev;
        c3.value = last;
        c3.next = new Node();
        p3 = c3;
        c3 = c3.next;
        c3.prev = p3;
      } else {
        sum = c1.value + c2.value + carry;
        last = sum % 10;
        carry = (sum-last)/10;
        c1 = c1.prev;
        c2 = c2.prev;
        c3.value = last;
        c3.next = new Node();
        p3 = c3;
        c3 = c3.next;
        c3.prev = p3;
      }
    }
    String ans = "";
    c3 = h3;
    while(c3.next != null) {
      ans = ans + c3.value;
      c3 = c3.next;
    }
    for(int i = ans.length()-1; i >= 0; i--) {
      System.out.print(ans.charAt(i));
    }
    System.out.println();
    System.exit(0);
  }
}
class Node {
  int value;
  Node next;
  Node prev;
}
