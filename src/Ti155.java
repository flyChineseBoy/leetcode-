import javax.management.QueryEval;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Ti155 {

}

class MinStack {
    /**
     LinkedList做数据存储。minValue保存最小值。
     */
    LinkedList<Integer> stack = new LinkedList<Integer>();
    Integer minValue = 0;
    /** initialize your data structure here. */
    public MinStack() {

    }

    // O1
    public void push(int x) {
        stack.addFirst( x );
        if( x < minValue ){
            minValue = x;
        }
    }

    // On
    public void pop() {
        Integer current = stack.removeFirst();
        if( current.equals(minValue)  ){ // Integer 缓存，范围只有-128~127
            findMinVall();
        }
    }
    private void findMinVall(){
        minValue = Integer.MAX_VALUE;
        for( Integer i : stack ){
            minValue = Math.min( i , minValue );
        }
    }

    public int top() {
        return stack.getFirst();
    }

    public int getMin() {
        return minValue;
    }

    public static void main(String[] args) {
        MinStack s = new MinStack();
        s.push(512);
        s.push(-1024);
        s.push(-1024);
        s.push(512);
        s.pop();
        System.out.println(s.getMin());

        s.pop();
        System.out.println(s.getMin());

        s.pop();
        System.out.println(s.getMin());
        Queue a = new LinkedList();

    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
