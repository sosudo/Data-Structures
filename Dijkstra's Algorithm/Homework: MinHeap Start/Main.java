import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) {
		MinHeap x = new MinHeap();
		x.insert(2);
		x.insert(3);
		x.insert(4);
		x.insert(1);
		x.insert(1);
		x.insert(2);
		x.insert(7);
		System.out.println(x.values);
		x.delete();
		System.out.println(x.values);
		System.out.println(x.peek());
	}
}
class MinHeap {
    ArrayList<Integer> values = new ArrayList<Integer>();
    public void insert(int val) {
        if(values.size() == 0) {
            values.add(val);
        } else {
            values.add(val);
            int idx = values.size() - 1;
            int parentIdx = (int) Math.ceil(((double) idx - 2.0)/2.0);
            int parent = values.get(parentIdx);
            int curr = values.get(idx);
            boolean go = parent > curr;
            while(go) {
                values.set(idx, parent);
                values.set(parentIdx, curr);
                idx = parentIdx;
                if(idx == 0) {
                    go = false;
                    break;
                }
                parentIdx = (int) Math.ceil(((double) idx - 2.0)/2.0);
                parent = values.get(parentIdx);
                curr = values.get(idx);
                go = parent > curr;
            }
        }
    }
    public int delete() {
        int ret = values.get(0);
        values.set(0, values.get(values.size()-1));
        values.remove(values.size()-1);
        int idx = 0;
        int curr = values.get(idx);
        int childOneIdx = 2*idx+1;
        int childTwoIdx = 2*idx+2;
        int childIdx = values.get(childOneIdx) >= values.get(childTwoIdx) ? childTwoIdx : childOneIdx;
        int child = values.get(childIdx);
        boolean go = child < curr;
        while(go) {
            values.set(childIdx, curr);
            values.set(idx, child);
            idx = childIdx;
            childOneIdx = 2*idx+1;
            childTwoIdx = 2*idx+2;
            if(childOneIdx > values.size()-1) {
                go = false;
                break;
            } else if(childTwoIdx > values.size()-1) {
                childIdx = values.get(childOneIdx);
            } else {
                childIdx = values.get(childOneIdx) >= values.get(childTwoIdx) ? childTwoIdx : childOneIdx;
            }
            child = values.get(childIdx);
            curr = values.get(idx);
            go = child < curr;
        }
        return ret;
    }
    public int peek() {
        return values.get(0);
    }
}
