import java.util.Queue;
import java.util.LinkedList;

class Solution {
    class Node{
        Integer val; // 该元素的值
        Node next; // 下一个节点
        Node(){}
        Node(Integer val){ this.val=val;}
    }
    public int numWays(int n, int[][] relation, int k) {
        //构造邻接表，然后广度优先遍历，第k层若是得到n-1，返回1；
        Node[] table = new Node[11];
        for( int[] row : relation ){
            Node node = new Node(row[1]);
            
            if( table[row[0]]==null ) table[row[0]]= node;
            else{
                Node next = table[row[0]].next;
                table[row[0]].next = node;
                table[row[0]].next.next=next;
            }
        }
        
        Queue<Node> queue = new LinkedList<Node>();
        Queue<Node> helper = new LinkedList<Node>();
        
        int sum = 0;
        
        Node head = table[0];
        while( head!=null ){
            if( k==1 && head.val==(n-1) ) sum++;
            queue.offer(head);
            head = head.next;
        }
        k--;
        
        while(k>0){
            while(!queue.isEmpty()){
                Node pop = table[queue.poll().val];
                // 所有queue的子节点全部得到
                while( pop!=null ){
                     // 当前若k==0，开始记录sum
                    if( k==1 && pop.val==(n-1)) sum++;
                    helper.offer(pop);
                    pop = pop.next;
                }
            }
            // 所有子节点返还给queue
            while(!helper.isEmpty()) queue.offer(helper.poll());
            k--;
        }
        
        return sum;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] a = new int[][]{{0,2},{2,1},{3,4},{2,3},{1,4},{2,0},{0,4}};

        System.out.println(s.numWays(5,a,3));
    }
    
}