package 动态规划;

/**
 * 动态规划
 *
 * @author: lele
 * @date: 2020-05-29
 */
public class Ti198_打家劫舍 {
    /**
     * 1. 动态规划：以dp[i]为0到i家获得的最大金额
     * 2.这道题类似股票冷冻期 的题目，可以通过每天的状态转移/限制来遍历所有可能的解并获得最大值
     */
    public int rob01(int[] nums) {
        /**
         一个dp数组。
         对于第n个房屋来说，最大金额为 MAX(n-1得到的最大金额，n的金额+（n-2）得到的最大金额)
         n=1就是1，n为2时，就是MAX（n1，n2）
         */
        if( nums.length == 0 ){
            return 0;
        }
        if( nums.length == 1 ){
            return nums[0];
        }

        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for( int i = 1; i < nums.length; i++ ){
            dp[i+1] = Math.max( dp[i], dp[i-1] + nums[i] );
        }
        return dp[nums.length];
    }

    /*public int rob01(int[] nums) {

    }*/
}
