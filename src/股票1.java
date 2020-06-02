public class 股票1 {
    class Solution {
        public int maxProfit(int[] prices) {
        /*
        int min = Integer.MAX_VALUE;
        int max = 0;
        for( int i = 0; i < prices.length; i++ ){
            min = Math.min(min,prices[i]);
            max = Math.max(max,prices[i]-min);
        }
        if( max > 0  ){
            return max;
        }
        return 0;
        */
            // dp[i] 表示前i天内的最大利润。
            // dp[i] = max( dp[i-1], prices[i]-前i-1天最小的数值 )
            // 边界 dp[0] = 0
            if( prices.length<=1 ) return 0;
            int[] dp = new int[prices.length];

            dp[0]=0;
            int min = prices[0];
            for( int i=1; i<prices.length; i++  ){
                dp[i] = Math.max(dp[i-1],prices[i]-min);
                min = Math.min(min,prices[i]);
            }
            return dp[prices.length-1];
        }
    }
}
