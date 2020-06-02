public class Ti300_找最长子序列 {
    public int lengthOfLIS(int[] nums) {
        // dp[i]= 0≤j<i,nums[j]<nums[i] max dp[j]+1
        // nums[0,i]的最长上升子序列是 前面 所有比自己小的子序列的一个max 再加一。
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < dp.length; i++) {
            int maxval = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    maxval = Math.max(maxval, dp[j]);
                }
            }
            dp[i] = maxval + 1;
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }
}
