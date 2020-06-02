package 动态规划;
import java.util.List;
/*
 * 动态规划
 * @author: lele
 * @date: 2020-04-23
 */

public class Ti2 {

      public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 数位DP
        // 从链表头开始，用一个标识位表示是否进位
        int flag = 0;
        ListNode res = new ListNode(0);
        ListNode head = res;

        while( l1!=null || l2!=null || flag>0 ){
            int val = flag;
            if( l2!=null&&l1!=null ){
                val += l1.val + l2.val;
                l2=l2.next;
                l1=l1.next;
            }
            else if( l2!=null ){  val +=l2.val; l2=l2.next; }
            else if( l1!=null ) {  val +=l1.val; l1=l1.next; }

            if( val>=10 ){ val=val-10;flag=1; }
            else flag=0;
            res.next = new ListNode(val);
            res = res.next;

        }
        return head.next;
    }
}
