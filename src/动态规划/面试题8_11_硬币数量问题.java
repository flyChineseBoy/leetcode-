package 动态规划;/*
 * 动态规划
 * @author: lele
 * @date: 2020-04-23
 */

import java.util.Arrays;

public class 面试题8_11_硬币数量问题 {
    public int waysToChange(int n) {
        // 1.dfs遍历，对当前面值分别进行-25，-10，-5，-1的操作。
        //      用Map保存当前金额以及金额对应的表示法有几种。
        // 2. dp[i] 表示i分的方案数，先从coins为1开始，然后[1,5]，最后包含所有硬币
        int[] dp = new int[n+1];
        // 当只使用面值为1的硬币时，总金额无论是0还是n，方案数都是1.
        Arrays.fill(dp,1);

        // 当开始使用面值为5的硬币时，需要在1的方案数上面多考虑5的方案数，即dp[i] = dp[i]+dp[i-1].
        // 当开始使用面值为10的硬币时，需要在1,5的方案数上面多考虑10的方案数，即dp[i] = dp[i]+dp[i-10].
        int[] otherCoins = new int[]{5,10,25};
        for( int coin : otherCoins ){
            for( int i=0; i<dp.length; i++ )
                dp[i] = i>=coin ? dp[i] + dp[i-coin] :dp[i];
        }
        return dp[n];
    }

}
