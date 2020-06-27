package 动态规划;

/**
 * 动态规划
 *
 * @author: lele
 * @date: 2020-06-26
 */
public class Ti_剑指Offer42_连续子数组的最大和 {
    /**
     * 问题：输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
     * 要求时间复杂度为O(n)。
     * 解析： 一般求区间特性的题目，都可以转化为 前缀和 的解法或表示法。
     *        比如本题中 `所有子数组` 实际上如果真的求所有子数组，那就是双层for循环来定位start和end，这样来确定所有的n*n个子数组。
     *        如何减少子数组的数量，我们可以转换思想，是否可以将子空间转化，不找所有子数组，而是找以i为结尾的子数组的和的最大值。
     *        仔细(玄学)想想，可行，可以写出状态转移公式：
     *          dp[i] = max(dp[i-1]+nums[i],nums[i]);
     *         边界条件：
     *           dp[0] = nums[0];
     */


    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int max = dp[0];

        for (int i = 1; i < dp.length; i++) {
            dp[i] = Math.max( dp[i-1]+nums[i],nums[i] );
            max = Math.max( dp[i],max );
        }

        return max;
    }
    public static void main(String[] args) {

    }
}
