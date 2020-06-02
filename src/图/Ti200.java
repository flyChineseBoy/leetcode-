package 图;

import java.util.LinkedList;
import java.util.Queue;

public class Ti200 {
    /**
     * 1、深度优先遍历
     * @param grid
     * @return
     */
    public static int numIslands(char[][] grid) {
        // 寻找有几个连通分量
        // 对一个节点进行dfs，遇到0或2返回，遍历过的节点置为2。
        // 对其他节点进行同样操作，最后对原数组求1的和。
        int sum=0;
        for( int i=0; i<grid.length; i++ ){
            for( int j=0; j<grid[0].length; j++ ){
                if( dfs(grid,i,j) ) sum++;
            }
        }
        return sum;
    }
    // 若该点为起点是一个完整的且未被遍历过的陆地，则返回真
    public static boolean dfs( char[][] grid,int i, int j ){
        if( i<0 || i>=grid.length || j<0 || j>=grid[0].length ) return false;
        if(  grid[i][j]!='1' ) return false;
        grid[i][j]='2';
        dfs( grid,i-1,j );
        dfs( grid,i,j-1 );
        dfs( grid,i+1,j );
        dfs( grid,i,j+1 );
        return true;
    }


    /**
     * 2、广度优先遍历
     * @param grid
     * @return
     */
    public int numIslands02(char[][] grid) {
        // 广度优先遍历求解
        // 只遍历土地，并计入visited数组
        if( grid.length==0 ) return 0;
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];
        int[][] moves = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        int sum=0;

        Queue<Integer> queue = new LinkedList<Integer>();
        for( int i=0; i<grid.length; i++ ){
            for( int j=0; j<grid[0].length; j++ ){
                if( grid[i][j]=='1' && visited[i][j]!=1 ){
                    queue.clear();
                    // 进行广度优先遍历
                    queue.offer( i*m + j );
                    sum++;
                    while( !queue.isEmpty() ){
                        int currIndex = queue.poll();
                        int x = currIndex/m;
                        int y = currIndex%m;
                        for( int k=0; k<4; k++ ){
                            int next_x = x+moves[k][0];
                            int next_y = y+moves[k][1];
                            if( inRange(next_x,next_y,n,m)
                                    && grid[next_x][next_y]=='1'
                                    && visited[next_x][next_y]!=1  ){
                                queue.offer( next_x*m + next_y );
                                visited[next_x][next_y]=1;
                            }
                        }
                    }
                }
            }
        }
        return sum;
    }

    boolean inRange( int x,int y,int n, int m ){
        if( x>=n || x<0 || y>=m || y<0 ) return false;
        return true;
    }
    public static void main(String[] args) {
        char[][] a = new char[][]{
                {'1','1','1','1','0'},
                {      '1','1','0','1','0'},
        {           '1','1','0','0','0'},
    {'0','0','0','0','0'},
        };

        char[][] b = new char[][]{{'1','0','1','1','0','1','1'}};
        System.out.println(numIslands(b));
    }
}
