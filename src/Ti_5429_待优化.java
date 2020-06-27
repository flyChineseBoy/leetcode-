import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * PACKAGE_NAME
 *
 * @author: lele
 * @date: 2020-06-07
 */
public class Ti_5429_待优化 {
    class Solution {
        class Node{
            int index;
            int value;
            int res;
            Node( int index,int value,int res){
                this.index=index;this.value=value;this.res=res;
            }
        }
        public int[] getStrongest(int[] arr, int k) {
            // 排序、计算中位数，然后从两端分别找k个最大的答案
            Arrays.sort(arr);
            int n = arr.length;
            int mediun = arr[(n - 1) / 2];


            PriorityQueue<Node> heap = new PriorityQueue<Node>(k,(Node a1, Node a2)->{

                if( a1.res>a2.res  ){
                    return 1;
                }
                if( a1.res<a2.res  ){
                    return -1;
                }
                if( a1.value>a2.value ){
                    return 1;
                }else if(a1.value < a2.value){
                    return -1;
                }
                return 0;
            });

            for( int i=0; i<n; i++ ){
                Node node = new Node( i,arr[i],Math.abs(arr[i]-mediun) );
                if( heap.size()<k ){
                    heap.offer( node );
                }else if(compare(heap.peek(),node)>0){
                    heap.poll();
                    heap.offer( node );
                }
            }

            int[] result = new int[k];
            int i=0;
            while( !heap.isEmpty() ){
                result[i++] = heap.poll().value;
            }
            return result;
        }
        // a1>a2,返回-1
        int compare(Node a1,Node a2){
            if( a1.res>a2.res  ){
                return -1;
            }
            if( a1.res<a2.res  ){
                return 1;
            }
            if( a1.value>a2.value ){
                return -1;
            }else if(a1.value < a2.value){
                return 1;
            }
            return 0;
        }
    }
}
