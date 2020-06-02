import java.util.ArrayList;

public class Ti5178 {
    class Solution {
        public int sumFourDivisors(int[] nums) {
            // 每个元素判断是否四因数
            // 是四因数的数字将因数累加到sum。
            int sum=0;
            for( int i=0; i<nums.length; i++ ){
                ArrayList<Integer> a = getDivisor(nums[i]);
                if(a!=null){
                    for(int num : a) sum += num;
                }
            }
            return sum;
        }

        // 返回该数字为四因数的所有因数
        ArrayList<Integer> getDivisor(int num){
            ArrayList divs= new ArrayList();
            for( int i=1; i<=num; i++ ){
                if( num%i == 0 ){
                    divs.add(i);
                    if( divs.size()>4 ) return null; // 剪枝
                }
            }
            if(divs.size()==4) return divs;
            return null;
        }


    }
}
