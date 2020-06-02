public class Ti309_股票冷冻期 {
        static  int[][] memo;
        public static int maxProfit(int[] prices) {
            // 买股票系列：简单交易可以直接寻找谷峰谷底。
            // 加入冷冻期。
            // dfs可遍历到所有的解空间，然后求最大利润
            // memo[0][i]记录i天未持有股票、之后的交易的最大利润
            // memo[1][i]记录i天持有股票、之后的交易的最大利润
            return Math.max( dfs(prices,0,0,0,0),dfs(prices,0,1,0,0) );
        }
        // has：0未持有，1持有,freezing 1为冷冻中,currProfit 当前利润
        static int dfs( int[] prices, int i, int has,int freezing,int currProfit ){
            if( i >= prices.length ) {
                System.out.println(currProfit);
                return currProfit;
            }

            int res = 0;
            // 若今天冷冻期，则只能直接跳到明天
            if( freezing==1 )
                res = dfs( prices,i+1,has,0 ,currProfit );
            else if( has==0 ){
                // 今天未持有

                res =  Math.max( dfs(prices,i+1,has,0,currProfit ), dfs(prices,i+1,1, 0 ,currProfit-prices[i]) );
            }else{
                res =  Math.max( dfs(prices,i+1,has,0,currProfit ), dfs(prices,i+1,0,1,currProfit+prices[i] ));
            }

            return res;
        }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1,2,3,0,2}));
    }

}
