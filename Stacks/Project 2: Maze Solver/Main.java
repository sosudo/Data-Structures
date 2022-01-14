import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("maze.txt"));
        int length = in.nextLine().length();
        int lines = 1;
        while(in.hasNextLine()) {
            lines++;
            in.nextLine();
        }
        in.close();
        char[][] map = new char[lines][length];
        Scanner input = new Scanner(new File("maze.txt"));
        String word;
        int x = 0;
        while(input.hasNextLine()) {
            word = input.nextLine();
            for(int i = 0; i < word.length(); i++) {
                map[x][i] = word.charAt(i);
            }
            x++;
        }
        input.close();
        char curr = 'x';
        Stack stack = new Stack();
        int y;
        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[i].length; j++) {
                curr = map[i][j];
                if(curr == '@') {
                    Integer[] coords = {i, j};
                    stack.push(coords);
                }
            }
        }
        x = stack.peek()[0];
        y = stack.peek()[1];
        curr = map[x][y];
        stack.pop();
        boolean go = true;
        boolean solvable = true;
        boolean moved;
        boolean popped = false;
        while(go) {
            if(!popped) {
                moved = false;
                if(curr == '$') {
                    Integer[] coords = {x, y};
                    stack.push(coords);
                    go = false;
                    break;
                }
                Integer[] coords = {x, y};
                stack.push(coords);
                map[x][y] = '0';
            }
            popped = false;
            moved = false;
            if(x != 0) {
                if(map[x-1][y] != '0' && map[x-1][y] != '#') {
                    x--;
                    curr = map[x][y];
                    moved = true;
                }
            } 
            if (x != lines-1 && !moved) {
                if(map[x+1][y] != '0' && map[x+1][y] != '#') {
                    x++;
                    curr = map[x][y];
                    moved = true;
                }
            } 
            if (y != 0 && !moved) {
                if(map[x][y-1] != '0' && map[x][y-1] != '#') {
                    y--;
                    curr = map[x][y];
                    moved = true;
                }
            } 
            if (y != length-1 && !moved) {
                if(map[x][y+1] != '0' && map[x][y+1] != '#') {
                    y++;
                    curr = map[x][y];
                    moved = true;
                }
            }
            if(!moved) {
                map[stack.peek()[0]][stack.peek()[1]] = '#';
                stack.pop();
                if(stack.peek() == null) {
                    solvable = false;
                    go = false;
                    break;
                }
                map[stack.peek()[0]][stack.peek()[1]] = '.';
                x = stack.peek()[0];
                y = stack.peek()[1];
                popped = true;
            }
        }
        if(!solvable) {
            System.out.println("Not Solvable");
            System.exit(0);
        }
        ArrayList<String> ans = new ArrayList<String>();
        while(stack.peek() != null) {
            ans.add(Integer.toString(stack.peek()[0]) + ", " + Integer.toString(stack.peek()[1]));
            stack.pop();
        }
        Collections.reverse(ans);
        for(String i : ans) {
            System.out.println(i);
        }
        System.exit(0);
    }
}
class Stack {
    Node top;
    public void push(Integer[] p) {
        Node n = new Node(p);
        n.next = top;
        top = n;
    }
    public Integer[] peek() {
        if (top == null) return null;
        return top.value;
    }
    public Integer[] pop() {
        if (top == null) return null;
        Node oldtop = top;
        top = top.next;
        oldtop.next = null;
        return oldtop.value;
    }
    public class Node {
        Integer[] value;
        Node next;
        public Node(Integer[] x) {
            value = x;
        }
    }
}
