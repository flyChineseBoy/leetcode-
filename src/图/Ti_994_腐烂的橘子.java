package 图;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 图
 *
 * @author: lele
 * @date: 2020-05-14
 */
public class Ti_994_腐烂的橘子 {
    // BFS求层数、变成技巧

    private int[] dr = new int[]{0,0,1,-1};
    private int[] dc = new int[]{1,-1,0,0};
    public int orangesRotting(int[][] grid) {
        // 1、暴力遍历所有可能解，用memo[i][j]代表该橘子被腐烂的最快时间，从每一个源点进行一次遍历，最后求一个memo中的最大值。
        // 2.BFS
        int R = grid.length,C = grid[0].length;
        Queue<Integer> queue = new LinkedList<Integer>();
        for( int i=0; i< grid.length; i++ ){
            for( int j=0; j< grid[0].length; j++ ){
                if( grid[i][j]==2 ) queue.offer( i*C+j );
            }
        }
        int res = -1;
        queue.offer(null);
        while( !queue.isEmpty() ){
            Integer code = queue.poll();
            if( code==null ){
                res++;
                if( !queue.isEmpty() ) queue.offer(null);
                continue;
            }
            int r = code/C; // 行数
            int c = code%C; // 列数
            for( int k=0; k<4; k++ ){
                int next_c = c+dc[k];
                int next_r = r+dr[k];
                if( next_c>=0 && next_c<C && next_r<R && next_r>=0  ){
                    if( grid[next_r][next_c]==1 ){
                        grid[next_r][next_c] = 2;
                        queue.offer( next_r*C+next_c );
                    }
                }
            }
        }
        for( int i=0; i< grid.length; i++ ){
            for( int j=0; j< grid[0].length; j++ ){
                if( grid[i][j]==1 ) return -1;
            }
        }
        return res;
    }
}
