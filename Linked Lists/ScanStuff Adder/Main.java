import java.io.*;
import java.util.Scanner;
public class Main {
  public static void main(String [] args) throws Exception{
    Scanner scan;
    scan = new Scanner(new BufferedReader(new FileReader("nums.txt")));
    int ans = 0;
    while(scan.hasNext()) {
      ans = ans + scan.nextInt();
    }
    System.out.println(ans);
  }
}
