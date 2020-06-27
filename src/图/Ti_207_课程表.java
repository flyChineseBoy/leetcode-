package 图;

/**
 * 图
 *
 * @author: lele
 * @date: 2020-06-15
 */
public class Ti_207_课程表 {

    class Solution {
        private int[][] matrix;
        private int[] visited;

        /**
         * DFS+visited数组，visited数组为1代表本节点遍历过，为-1代表其他节点遍历过
         * 还可以用邻接表、广度优先遍历-拓扑排序来做。
         * @param numCourses
         * @param prerequisites
         * @return
         */
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            // 即判断图中是否存在环。用标记位，两次走到一个节点即存在环
            // 广度或深度，只要接下来的点是被遍历过的点，则存在环。
            matrix = new int[numCourses][numCourses];
            visited = new int[numCourses];

            for( int[] prerequisite : prerequisites ){
                matrix[prerequisite[0]][prerequisite[1]] = 1;
            }

            // dfs
            for( int i=0; i<numCourses; i++ ){
                if( !dfs(i) ) return false;
            }
            return true;
        }

        boolean dfs( int i ){
            if( visited[i] == 1 ) return false;
            if( visited[i] == -1 ) return true;
            visited[i] = 1;
            for( int j=0; j<visited.length; j++ ){
                if(  matrix[i][j]==1   ){
                    if( !dfs(j) ) return false;
                }
            }
            visited[i] = -1;
            return true;
        }

    }
}
