package 图;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 图
 *
 * @author: lele
 * @date: 2020-06-01
 */
public class Ti_1162_地图分析 {
    int[][] visited;
    int[][] moves = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    int N;
    public int maxDistance(int[][] grid) {
        // 找到距离所有陆地最远的海洋即可
        // 解法：记录并更新所有海洋节点到陆地的最近距离
        N = grid.length;
        int[][] distinct = new int[N][N];

        //Arrays.fill(distinct,Integer.MAX_VALUE);

        Queue<Integer> queue = new LinkedList<Integer>();

        for( int i=0; i<N; i++  ){
            for( int j=0; j<N; j++  ){
                if( grid[i][j]==1 ) {
                    queue.add( i*N + j ); // 用i*N+j来代替i，j坐标
                }else{
                    distinct[i][j] = Integer.MAX_VALUE; // 初始化distinct的海洋变量
                }
            }
        }

        while( !queue.isEmpty() ){
            Integer currentIndex = queue.poll();
            int y = currentIndex % N;
            int x = currentIndex / N;
            for( int k=0; k<4;k++ ){
                int next_x = x+moves[k][0];
                int next_y = y+moves[k][1];
                if( isValid(next_x,next_y) && grid[next_x][next_y]==0 ){
                    if( distinct[x][y]+1 < distinct[next_x][next_y] ){
                        distinct[next_x][next_y] = distinct[x][y]+1;
                    }else{
                        // 该路径继续遍历也毫无贡献
                        continue;
                    }
                    queue.add( next_x*N +  next_y );
                }
            }
        }

        // 找到距离所有陆地最远的那个海洋
        int max=-1;
        for( int i=0; i<N; i++  ){
            for( int j=0; j<N; j++  ){
                if(  grid[i][j]==0 && distinct[i][j]!=Integer.MAX_VALUE  )
                    max = Math.max(max,distinct[i][j]) ;
            }
        }

        return max;
    }


    boolean isValid( int x,int y ){
        if( x>=N || x<0 || y>=N || y<0 ) return false;
        return true;
    }

        public static void main(String[] args) {
            int[][] canshu = new int[][]{{1,0,1},{0,0,0},{1,0,1}};
            Ti_1162_地图分析 t = new Ti_1162_地图分析();
            System.out.println(t.maxDistance( canshu ));
        }

}
