import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Ti_5403 {
    class Solution {
        public int kthSmallest(int[][] mat, int k) {
            // m个队列，一个总数，不断的排除最小值，直到k次
            // 使用一个堆来快速找到最小值
            int m = mat.length;
            int n = mat[0].length;
            int[] headers = new int[m];
            PriorityQueue<List<Integer>> heap = new PriorityQueue<List<Integer>>((q, p)-> q.get(0)-p.get(0)
            );
            //heap.add(Arrays.asList(1,2,3));

            int min = 0;
            for( int i=0; i<m; i++ ){
                min += mat[i][0];
                heap.offer(Arrays.asList(mat[i][0],i));
                k--;
            }

            while( k>0 ){
                List<Integer> node = heap.poll();
                min -= node.get(0);
                if( node.get(1)>=n-1 ){
                    break; // TODO 如果最小行用完了怎么办。
                }
                else {
                    headers[node.get(1)]++;
                    heap.offer(  Arrays.asList( mat[headers[node.get(1)]][node.get(1)],node.get(1) ) );
                }
                k--;
            }

            return min;
        }
    }
}
