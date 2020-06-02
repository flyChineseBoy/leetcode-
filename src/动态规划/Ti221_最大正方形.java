package 动态规划;

/**
 * 动态规划
 *
 * @author: lele
 * @date: 2020-05-08
 */
public class Ti221_最大正方形 {

    /**
     * 暴力解法：
     * 从左至右，从上至下，找到1，算作边长1的正方形
     *         找到后，逻辑判断新增一行一列是否还成立，成立则在新增一行进行判断
     *
     *  优化： 可以考虑使用一个memo数组记录已经被之前正方形使用的1，这样的1不再计算，直接continue。
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {
        if( matrix.length==0 ) return 0;
        int maxSize = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;

        for( int i=0; i<rows; i++ ){
            for( int j=0; j<cols; j++ ){
                if( matrix[i][j]=='1' ){
                    maxSize = Math.max( maxSize,1);
                    int remainLen = Math.min(rows-i,cols-j);

                    for( int k=1; k<remainLen; k++ ){
                        boolean flag = true;
                        if( matrix[i+k][j+k]=='0' ) break;
                        for( int l=0; l<k; l++ ){
                            if( matrix[i+k][j+l]=='0' || matrix[i+l][j+k]=='0' ){
                                flag = false;
                                break;
                            }
                        }
                        if( flag ){
                            maxSize = Math.max( maxSize,1+k );
                        }else{
                            break;
                        }
                    }
                }
            }
        }
        return maxSize*maxSize;
    }


    // TODO 使用动态规划，dp[i][j]代表以i、j有右下节点的所能够拥有的最大边长

}
