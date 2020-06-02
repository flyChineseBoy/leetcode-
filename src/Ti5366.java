public class Ti5366 {
    class Solution {
        public boolean hasValidPath(int[][] grid) {
            // 不会存在岔路口，所以只要从原点开始往下走就好了(需要记录一个方向，来判断当前结点往上还是下，往左还是右)
            // 需要判断当前元素和下一步的元素是否能对上，对不上直接over
            int i=0;
            int j=0;

            while( i<grid.length && j<grid[0].length ){
                if( grid[i][j]==1 ){
                    if( i>=grid.length || grid[i+1][j]==2 || grid[i+1][j]==4 || grid[i+1][j]==6 ) return false;
                    i++;
                }
                else if(grid[i][j]==3){
                    if( j>=grid.length || grid[i][j+1]==2 || grid[i][j+1]==4 || grid[i][j+1]==6 ) return false;
                    j++;
                }
                else if(grid[i][j]==5 ){
                    if( j>0 || grid[i][j-1]==2 || grid[i][j-1]==4 || grid[i][j-1]==6 ) return false;
                    j--;
                }
                else if(grid[i][j]==2){
                    if( j>=grid[0].length || grid[i][j+1]==1 || grid[i][j+1]==3 || grid[i][j+1]==4 ) return false;
                    j++;
                }
                else if(grid[i][j]==4){}
        }
            return false;

        }
    }
}
