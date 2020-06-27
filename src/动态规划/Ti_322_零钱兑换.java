package 动态规划;

import java.util.Arrays;

/**
 * 动态规划
 *
 * @author: lele
 * @date: 2020-06-26
 */
public class Ti_322_零钱兑换 {
    /**
     * 解析：零钱兑换题目，问题在于理解硬币数量与金额之间建立联系。
     *     实质上，类似于跳台阶、兔子数列。我们可以将不同的总金额看做dp数组，不同的coins的数量为变量。
     *     状态转移方程：
     *       dp[i] = min( dp[i-x1],dp[i-x2],dp[i-x3],…… )+1， [x1,x2,x3]属于coins集合
     *       边界条件：
     *          dp[x1]=1,dp[x2]=1,dp[x3]=1,……     [x1,x2,x3]属于coins集合
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0] = 0;
        for (int i = 1; i < amount+1; i++) {
            for (int coin : coins) {
                if( i>=coin ){
                    dp[i] = Math.min( dp[i], dp[i-coin]+1 );
                }
            }
        }

        return dp[amount]>amount?-1:dp[amount];
    }



}
