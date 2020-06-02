package 动态规划;

import java.util.HashMap;

/**
 * 动态规划
 *
 * @author: lele
 * @date: 2020-05-10
 */
public class Ti5405_异或相等数组 {
        public int countTriplets(int[] arr) {
            // i到j区间内的异或 == j到k区间内的异或
            // 三层循环，i、j、k将所有值都尝试一遍。 超时
            // memo[a][b]保存a到b之间的异或结果，包头包尾

            int res=0;
            Integer[][] memo = new Integer[arr.length][arr.length];
            int ij=0;
            int jk=0;
            for( int i=0; i<arr.length; i++ ){
                for( int j=i+1; j<arr.length; j++ ){
                    for( int k=j; k<arr.length; k++ ){
                        if( memo[i][j-1]!=null ) ij = memo[i][j-1];
                        else{
                            for( int m=i; m<j; m++ ){
                                ij ^= arr[m];
                            }
                            memo[i][j-1] = ij;
                        }
                        if( memo[j][k]!=null ) jk = memo[j][k];
                        else{
                            for( int n=j; n<=k; n++ ){
                                jk ^= arr[n];
                            }
                            memo[j][k] = jk;
                        }

                        if( ij==jk )
                            res++;
                        ij=0;jk=0;
                    }
                }
            }
            return res;
    }

    public static void main(String[] args) {
        Ti5405_异或相等数组 t = new Ti5405_异或相等数组();
        System.out.println(t.countTriplets( new int[]{2,3,1,6,7} ));
    }
}
