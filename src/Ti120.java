import java.util.List;

public class Ti120 {
    // 1. dfs遍历解空间求最优质解
    public int minimumTotal(List<List<Integer>> triangle) {
        return dfs( triangle,0,0,triangle.get(0).get(0) );

    }
    /**
     i : 当前行
     J： 当前列
     minTotal : 从[0,0]到当前节点的路径长度
     return : 返回该节点向下经历的最短长度+上面的长度
     */
    int dfs( List<List<Integer>> triangle, int i, int j, int minTotal ){
        if( i==triangle.size()-1 ) return minTotal;
        return Math.min( dfs(triangle,i+1,j,triangle.get(i+1).get(j)+minTotal ),
                dfs(triangle,i+1,j+1,triangle.get(i+1).get(j+1)+minTotal)
        );
    }



    // 解法二： 使用一个数组记录已经遍历过的节点。
    private int[][] dp;
    public int minimumTotal02(List<List<Integer>> triangle) {
        dp = new int[triangle.size()][triangle.get(triangle.size()-1).size()];
        return dfs( triangle,0,0 );

    }
    /**
     i : 当前行
     J： 当前列
     return : 返回该节点开始，向下经历的最短长度
     */
    int dfs( List<List<Integer>> triangle, int i, int j ){
        if( i==triangle.size()-1 ) return triangle.get(i).get(j);
        if( dp[i][j]!=0 ) return dp[i][j];

        dp[i][j] = triangle.get(i).get(j) + Math.min( dfs(triangle,i+1,j),dfs(triangle,i+1,j+1));

        return dp[i][j];
    }

    // 解法三，要实现题目要求的辅助空间O(n)，只能BFS，懒得写了。。
}
