 class ListNode {
    int val;
    ListNode next;
     ListNode() { }
     ListNode(int x) { val = x; }
 }
    public class Ti61 {


        public static ListNode rotateRight(ListNode head, int k) {
            // 快慢指针
            // 先计算链表长度，若k大于链表长度，则对k取余数。
            // 快指针走k步，然后快慢一起走，走到尾。
            // 此时快指针所在即为新的头结点。
            if( head==null || head.next == null || k==0 ) return head;

            ListNode count = head;
            ListNode orgHead = head;
            int length = 0;
            while( count!=null ) {
                length++;
                count = count.next;
            }
            k = k % length;
            if( k==0 ) return head;

            ListNode tail = head;
            for( int i=0; i<k-1; i++ ){
                tail = tail.next;
            }
            while( tail.next!=null ){
                tail = tail.next;
                head = head.next; // 得到新的头结点
            }

            // 处理尾节点
            tail.next = orgHead;
            while( tail.next!=head ){
                tail = tail.next;
            }
            tail.next = null;
            return  head;
        }

    public static void main(String[] args) {
        ListNode hea = new ListNode(0);
        ListNode hea2 = new ListNode(1);
        ListNode hea3 = new ListNode(2);
        ListNode hea4 = new ListNode(4);
        ListNode hea5 = new ListNode(5);
        hea.next = hea2;
        hea2.next = hea3;
        //hea3.next = hea4;
        //hea4.next = hea5;

        rotateRight( hea,4 );
    }
}
