import java.util.*;
import java.util.LinkedList;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Ti23 {
    /* 太啰嗦了，直接对lists进行无限for循环，当所有链表为空时break。同时每一次遍历取所有链表头里面最小的一个，这样才是O(N*k),N为总结点，k为k个链表
    public static ListNode mergeKLists(ListNode[] lists) {
        // 1、直接获取，每一次从n个链表中获取链表头元素。 O(n*k)
        // 获取到一个元素，就将其元素删除，若本链表只剩一个则将链表删除
        // linkedListed保存lists，以保证对元素删除的速度（n*k*n,链表获取元素很慢）,换成ArrayList可通过（ArrayList的remove很慢，但是ArrayList自己有一些优化）
        ListNode head = new ListNode();
        ListNode res = head;
        ArrayList<ListNode> sets = new ArrayList<ListNode>();
        for( int i=0; i<lists.length; i++ ) if(lists[i]!=null)sets.add(lists[i]);

        while(!sets.isEmpty()){
            // 挑选最小值
            int min_index = -1;
            int min = Integer.MAX_VALUE;
            for( int i=0; i<sets.size(); i++ ){
                if( sets.get(i).val < min ) {min_index=i;min=sets.get(i).val;}
            }
            res.next = sets.get(min_index);
            if( sets.get(min_index).next==null ) sets.remove(min_index);
            else sets.set(min_index,sets.get(min_index).next);
            res = res.next;
            res.next=null;
        }
        return head.next;
    }
*/
    public static ListNode mergeKLists(ListNode[] lists) {
        // 2、使用优先队列进行排序、取值。 O(N*logk)
        // 优先队列每次poll一个元素需要重整堆，需要logk时间复杂度。
        // ** 非空判断。
        ListNode head = new ListNode();
        ListNode res = head;
        ArrayList<ListNode> sets = new ArrayList<ListNode>();
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if(o1==null||o2==null) return 0;
                return o1.val-o2.val;
            }
        });

        for( int i=0; i<lists.length; i++ ) if(lists[i]!=null)queue.offer(lists[i]);

        while(!queue.isEmpty()){
            // 挑选最小值
            ListNode minNode = queue.poll();
            if(minNode.next!=null) queue.offer(minNode.next);
            res.next = minNode;
            res = res.next;
            res.next=null;

        }
        return head.next;
    }
    public static void main(String[] args) {
        ListNode l11 = new ListNode(1);
        ListNode l12 = new ListNode(4);
        ListNode l13 = new ListNode(5);
        l11.next=l12;
        l12.next=l13;
        ListNode l21 = new ListNode(1);
        ListNode l22 = new ListNode(3);
        ListNode l23 = new ListNode(4);
        l21.next=l22;
        l22.next=l23;
        ListNode l31 = new ListNode(2);
        ListNode l32 = new ListNode(6);
        l31.next=l32;
        ListNode[] lists = new ListNode[3];
        lists[0] = l11;
        lists[1] = l21;
        lists[2] = l31;
        System.out.println(mergeKLists(lists));
    }
}

