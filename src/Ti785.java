import java.util.Queue;
import java.util.LinkedList;

public class Ti785 {
    class Solution {
        public boolean isBipartite(int[][] graph) {
            // 染色法-广度优先遍历，相邻两个节点上不同颜色时。
            if( graph.length<2 ) return true;
            int[] marked = new int[graph.length]; // 1为黑色，2为白色
            Queue<Integer> queue = new LinkedList<Integer>();

            for( int j=0; j<graph.length; j++ ){ // 考虑子图不连通
                if( marked[j]==0 ){
                    queue.offer( j );
                    marked[j]=1;

                    while( !queue.isEmpty() ){ // bfs
                        Integer vertex = queue.poll();
                        for( int i=0; i<graph[vertex].length; i++ ){
                            if( marked[graph[vertex][i]] == marked[vertex] ) return false;

                            if( marked[graph[vertex][i]]==0 ){
                                marked[graph[vertex][i]] = marked[vertex]==1?2:1; // 上色
                                queue.offer(graph[vertex][i]); // 入队列
                            }
                        }
                    }
                }
            }

            return true;
        }
    }
}
