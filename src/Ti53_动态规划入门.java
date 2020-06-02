public class Ti53_动态规划入门 {
    public int maxSubArray(int[] nums) {
        // 前点遍历，以当前点为最后点来遍历，以度来遍历
        // 最后点遍历，dp[i]代表以i为最后点的所有子序列的最大连续子数组的和
        // dp[i] = max(dp[i-1]+nums[i],nums[i]) // 最后节点必须要，所以只能看前面子序列是不是有用
        int[] dp= new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0]; // 从以0结尾的dp[0]到以n结束的dp[n]之间，找到最大值
        for( int i=1; i<nums.length; i++ ){
            dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
            max = Math.max(max,dp[i]);
        }
        return max;
    }
    class Solution {
        public int maxSubArray(int[] nums) {
            // 对于以nums[i]为开头的数字，有 [-2],[-2,1],[-2,1,-3]等……
            // 所有以nums[i]为开头的数字囊括了所有数字，所以我们可以拆开来看，先开以nums[0]为开头的数组
            // 可以发现 nums[0]是在所有以nums[1]为开头的子数组，在其之上前面加了个-2的结果
            // 再来定义 dp[i]代表以nums[i]开头的子数组中有最大和的那一个。
            // 可以知道 dp[0]= max(nums[0],nums[0]+dp[1])
            if(nums.length==0) return 0;
            if(nums.length==1) return nums[0];
            int[] dp = new int[nums.length];
            dp[nums.length-1] = nums[nums.length-1];
            int max = Integer.MIN_VALUE;
            for( int i=nums.length-2; i>=0;i-- ){
                dp[i] = Math.max(dp[i+1]+nums[i],nums[i]);
                max = Math.max(dp[i],max);
            }
            return max;
        }
    }
}
