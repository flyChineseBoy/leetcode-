public class Ti1248 {
    public static int numberOfSubarrays(int[] nums, int k) {
        /*
        // 子函数：判断该子数组是否优美
        // 子函数：is奇数
        // 是否优美的状态转移方程 ：
        //    dp[i,j] = dp[i+1,j] + !is奇数( nums[i] );
        // 边界条件：
        int[][] dp = new int[nums.length][nums.length];
        int allOdd = 0;
        int result = 0;
        for( int i=0; i<nums.length; i++ ){
            if( isOdd(nums[i])==1 ) allOdd++;
        }
        dp[0][nums.length-1] = allOdd;
        if( allOdd==k ) result++;

        // 状态转移
        for( int i=0,j=nums.length-1; i<=j; ){
            // 去掉左边
            dp[i+1][j]  = dp[i][j] - isOdd(nums[i+1]);
            // 去掉右边
            dp[i][j-1]  = dp[i][j] - isOdd(nums[j-1]);
            // 去掉两端
            dp[i+1][j-1]  = dp[i][j-1]  - isOdd(nums[i+1]);

            if( dp[i+1][j]==k ) result++;
            if( dp[i+1][j-1]==k ) result++;
            if( dp[i][j-1]==k ) result++;

            i++;
            j--;
        }
        return result;
*/
        //1、前缀和+two sum
        // 前缀和，On
        int[] arr = new int[nums.length];// arr[i]代表0到i有多少个奇数
        for( int i=0; i<nums.length; i++ ){
            if( i==0 ) arr[i] = isOdd(nums[i]);
            else{
                arr[i] = arr[i-1] + isOdd( nums[i] );
            }
        }
        int result=0;
        // 双层for循环，求i-j之间为k的个数
        for( int i=0; i<nums.length; i++ ){
            for( int j=i; j<nums.length; j++ ){
                if( (arr[j]-arr[i])==k ) result++;
            }
        }
        return result;
    }

    static int isOdd( int num ){
        if( num % 2 == 0 ) return 0;
        return 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2,1,1};
        System.out.println( numberOfSubarrays(nums,3) );
    }
}
