public class Ti5391_记忆化DP {

        private static int mod = 1_000_000_000 + 7;
        public int numOfArrays(int n, int m, int k) {
            Long[][][] memo = new Long[n + 1][m + 1][k + 1]; // dp数组
            return (int) dfs(0, 0, 0, n, k, m, memo) % mod; //
        }
        //k 代表的意思是最长递增子序列的长度
        //curN 数量 curK当前的k
        //memo记忆化
        private long dfs(int curN, int curK, int curMax, int n, int k, int max, Long[][][] memo) {
            if (curN == n) {
                return curK == k ? 1 : 0;
            }
            if (curK > k) {
                //长度超过k 了  不用找了
                return 0;
            }
            //记忆化递归
            if (memo[curN][curMax][curK] != null){
                return memo[curN][curMax][curK];
            }
            long res = 0;
            //k 代表的意思是最长递增子序列的长度
            for (int i = 1; i <= max; i++) {
                if (i > curMax) {
                    //第一种是递增序列包括 当前 的值，  当前 值比 前面的最大值大 ，然后 curK + 1 max = i
                    res += dfs(curN + 1, curK + 1, i, n, k, max, memo);
                    res %= mod;
                } else {
                    //第二种是递增序列不在其中，当前 值不比 前面的最大值大 不在 递增序列中， curK不变 max 不变
                    res += dfs(curN + 1, curK, curMax, n, k, max, memo);
                    res %= mod;
                }
            }
            memo[curN][curMax][curK] = res;
            return res;
    }
}
