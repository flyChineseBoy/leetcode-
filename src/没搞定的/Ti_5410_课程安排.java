package 没搞定的;

import java.util.Arrays;

/**
 * 没搞定的
 *
 * @author: lele
 * @date: 2020-05-30
 */
public class Ti_5410_课程安排 {
    public static void main(String[] args) {
        int[][] distinct = new int[2][2];
        int a = 0;
        System.out.println(distinct[0][0]);
    }
    class Solution {

     /*   class Node{
            int x;
            Node next;
            Node last;
            Node( int x,Node nex,Node last){ this.x=x;this.next=nex;this.last=last; }
        }

        public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
            // 维护一个矩阵 101*101的依赖矩阵，数值为1代表i课程依赖于j课程。
            // 树形遍历填充，要先找到所有根节点，即哪些节点在第一列出现过，但是没有在第二列出现过。
            // 比如依赖为1的，先找依赖为1的所有节点，然后找这些节点下面。
            // 2. 先形成一个简陋的图，然后在图上一遍遍推演填补。
            // 3.大爷的，为什么要填充满，形成一个图，然后查询的时候直接在图里面溯源不就好了么。。。
            int m = prerequisites.length;
            int[] used = new int[m];

            Node[] requires = new Node[101];
            Set<Integer>[] querySet = new HashSet[101]; // 并不会全部计算，用到哪个计算哪个

            List<Boolean> res = new ArrayList<Boolean>(queries.length);

            for( int i=0; i<prerequisites.length; i++ ){
                Node next = new Node(prerequisites[i][0],null,null);
                if(requires[prerequisites[i][1]]==null){
                    requires[prerequisites[i][1]] = new Node(prerequisites[i][1],next,next);
                }else{
                    requires[prerequisites[i][1]].last.next =  next;
                    requires[prerequisites[i][1]].last = next;
                }
            }


            for( int i=0; i<queries.length; i++ ){
                int a = queries[i][1]; // 得到被验证节点下标
                if( querySet[i]!=null ){
                    res.set(i,querySet[i].contains(queries[i][0]) );
                    continue;
                }
                Node tmp = requires[a].next;
                Queue<Integer> queue = new LinkedList<Integer>();
                while( tmp!=null ){
                    queue.offer(tmp.x);
                }
                Set set = new HashSet<Integer>();

                while( !queue.isEmpty() ){
                    Integer father = queue.poll();
                    set.add(father);
                    tmp = requires[father].next;
                    while( tmp!=null ){
                        queue.offer(tmp.x);
                    }
                }

            }
            return res;

        }*/


    }
}
