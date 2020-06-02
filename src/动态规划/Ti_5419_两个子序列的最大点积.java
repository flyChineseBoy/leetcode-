package 动态规划;

/**
 * 动态规划
 *
 * @author: lele
 * @date: 2020-05-24
 */
public class Ti_5419_两个子序列的最大点积 {

    // 有问题，不是连续子序列，是子序列
    @Deprecated
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        // 暴力法：nums1中所有子序列和nums2中所有等长子序列进行点积
        int k = Math.min( n,m );
        int max = nums1[0]*nums2[0];
        int tmp = 0;

        for( int i=1; i<=k; i++ ){
            // 计算nums1中所有长度为i的
            for( int j=0; j<n-k; j++ ){
                // 计算nums2中长度为i的，两者点积
                for( int l=0; l<m-k; l++ ){
                    tmp=0;
                    for( int o=0; o<k; o++ ){
                        tmp += nums1[i+o]*nums2[l+o];
                    }
                    max = Math.max( tmp,max );
                }
            }
        }
        return max;
    }
}
