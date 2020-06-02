import java.util.Arrays;

public class Ti673_最长子序列的个数 {
    public static int findNumberOfLIS(int[] nums) {
        // 利用Ti300动态规划解法的变种
        int N = nums.length;
        int[] dp = new int[N]; // dp[i]表示以i为结尾的最长递增子序列的长度
        // 状态转移公式： dp[i] = max(之前所有满足nums[i]<nums[j]的dp)
        int[] counts = new int[N];
        Arrays.fill(counts,1);
        Arrays.fill(dp,1); // 注意这里与300有区别，300是因为只考虑最长的所以不需要初始化dp所有值。

        for( int i=0; i<N; i++ ){
            for( int j=0; j<i; j++ ){
                if( nums[i] > nums[j] ){
                    if( dp[i] < dp[j]+1 ){ // dp[i]这里相当于求max(dp[j])
                        dp[i] = dp[j]+1;
                        counts[i] = counts[j];
                    }else if( dp[i]==dp[j]+1 ){ // 考虑dp[j]出现多个最大值，要将count保留下来
                        counts[i] += counts[j];
                    }
                }
            }
        }
        // 找到最大长度
        int maxLength = -1;
        for( int i=0; i<N; i++ ) maxLength = Math.max(maxLength,dp[i]);
        // 计算最大长度的个数
        int maxCount = 0;
        for( int i=0; i<N; i++ ){
            if( maxLength==dp[i] ) maxCount +=counts[i];
        }
        return maxCount;
    }

    public static void main(String[] args) {
        System.out.println(findNumberOfLIS(new int[]{1,3,5,4,7}));;
    }
}
