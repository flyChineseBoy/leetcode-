import java.util.HashSet;
import java.util.PriorityQueue;

public class TestQueue {
    public static void main(String[] args) {
        PriorityQueue<String> q = new PriorityQueue<String>(); // 会排序的队列？还算队列吗？
        //入列

        q.offer("2");
        q.offer("5");
        q.offer("3");
        q.offer("1");
        q.offer("4");
        //出列
        System.out.println(q.poll());  //1
        System.out.println(q.poll());  //2
        System.out.println(q.poll());  //3
        System.out.println(q.poll());  //4
        System.out.println(q.poll());  //5

        HashSet<Integer> set = new HashSet<Integer>(10);
        //set.contains()
    }
}
