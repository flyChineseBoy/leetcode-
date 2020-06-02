import java.util.Arrays;
import java.util.HashMap;

/**
 */
class Ti532 {
    public static int findPairs(int[] nums, int k) {
        /**
         hash表
         数组排序，
         将所有数据按照《元素，数量》存在hash中；
         遍历数组，计算所需数值，若存在，则result+1且该两个元素在map中减一。
         */
        if( nums.length < 2 || k < 0 ){
            return 0;
        }
        int result = 0;
        HashMap<Integer,Integer> hash = new HashMap<Integer,Integer>();
        Arrays.sort( nums );
        for( int i = 0; i < nums.length; i++ ){
            hash.put( nums[i], hash.getOrDefault( nums[i], 0 )+1 );
        }
        for( int i = 0; i < nums.length; i++ ){
            int kSub1 = nums[i] - k;
            int kSub2 = k + nums[i];
            // k为0时，不能从map中取自己
            if( k==0 && hash.get(kSub1)==1 ){
                continue;
            }
            if( hash.containsKey( kSub1 ) && hash.get( kSub1 ) > 0 && hash.get( nums[i] ) > 0 ){
                result++;
                hash.put( nums[i], hash.get( nums[i]) - 1 );
                hash.put( kSub1, hash.get( kSub1 ) - 1 );
            }else if( hash.containsKey( kSub2 ) && hash.get( kSub2 ) > 0 && hash.get( nums[i] ) > 0  ){
                result++;
                hash.put( nums[i], hash.get( nums[i]) - 1 );
                hash.put( kSub2, hash.get( kSub2 ) - 1 );
            }
        }
        return result;
    }

    public static void main(String[] args) {
        findPairs(new int[]{1,1,1,2,1},1);
    }
}




