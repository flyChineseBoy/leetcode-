import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ti18 {
        public static List<List<Integer>> fourSum(int[] nums, int target) {
            // 三指针
            // 1、 数组长度小于等于4
            // 2、数组排序
            // 3、遍历数组，对每个元素取后三位：
            //    对后三位：遍历数组，取该元素之后的最大元素和最小元素，若三元素之和等于所需元素，返回。
            //             若大于，L--;若小于，R++；
            List result = new ArrayList();
            if( nums.length < 4 ) return result;
            if( nums.length == 4){
                if( nums[0] + nums[1] + nums[2] + nums[3] != target){
                    return result;
                }
                result = Arrays.asList(nums);
                return result;
            }

            Arrays.sort(nums);

            for( int i=0; i<nums.length; i++ ){
                if( i>0 && nums[i]==nums[i-1] ) continue; // 四个元素转换为求三个元素等于目标和
                int threeTarget = target - nums[i];
                for( int j=i+1; j<nums.length; j++ ){
                    if( j>i+1 && nums[j]==nums[j-1] ) continue;
                    int L = j+1;
                    int R = nums.length-1;
                    while( L < R ){
                        int threeSum = nums[j] + nums[L] + nums[R];
                        if( threeSum == threeTarget ){
                            // 等于即获得一个答案，保存，并过滤相同值
                            result.add( Arrays.asList( nums[i], nums[j], nums[L], nums[R] ) );
                            while( L < R && nums[L] == nums[L+1] ){
                                L++;
                            }
                            while( L < R && nums[R] == nums[R-1] ){
                                R--;
                            }
                            L++;
                            R--;
                        }else if( threeSum > threeTarget ){
                            R--;
                        }else{
                            L++;
                        }
                    }
                }
            }
            return result;
        }

    public static void main(String[] args) {
        int[] nums = new int[]{-2,-1,0,0,1,2};
        // System.out.println(fourSum(nums,0));
        int a = -2147483647;
        //System.out.println( Integer.MIN_VALUE >> 1 );

        for(int i = 31; i >= 0; i--) {
            int temp = 2147483647 >> i;
        //    System.out.println(temp);
        }
        System.out.println( Math.pow(2.0,31.0) );
        System.out.println( 1 < (long)31.0);
        System.out.println(  -1 >> 2 );

        divide(10,3);
    }

    // Ti 29
    public static int divide(int dividend, int divisor) {
        /*
        // 循环遍历解 : 超时
        // * 正转负数越界问题，所以用负数来比较
        int flag = 0; // 1为负数，0为整数
        // | 小于0表示同一定有负号， & 大于表示一定有一个为正数（也可以用异或）
        if(  (dividend | divisor) < 0  && (dividend & divisor) > 0 ) flag = 1;

        dividend = 0-Math.abs( dividend );
        divisor = 0-Math.abs( divisor );

        int mutilDivisor = divisor;
        int res = 0;
        while( dividend <= mutilDivisor ){
            mutilDivisor += divisor;
            res++;
        }
        if( flag == 1 ) return 0-res;
        return res;
        */

        /*
            模拟小学除法：
                左位移，找到除数比被除数小，但是再乘以2就会比被除数大的那个数。（注意溢出）
                得到的差值作为被除数继续除以除数。
        */
        if (dividend == 0) {
            return 0;
        }
        if( dividend == divisor ) return 1;
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        int count = 0;
        int result = 0;
        int flag = 0;
        if(  (dividend | divisor) < 0  && (dividend & divisor) > 0 ) flag = 1;

        dividend = Math.abs( dividend );
        divisor = Math.abs( divisor );

        long divisorL = (long) divisor;
        long dividendL = (long) dividend;
        while( divisorL <= dividendL ){
            divisorL <<= 1;
            count++; // 对应当前是几倍
        }

        while( count!=0 ){
            count--;
            divisorL >>= 1;
            if( divisorL <= dividendL ){
                dividendL -= divisorL;
                result += 1 << count;
            }
        }
        if( flag == 1 ) return 0-result;
        return result;
    }
}
