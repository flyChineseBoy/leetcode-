import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Ti169 {

    public static int majorityElement(int[] nums) {
        /**
         1、先排序，再一遍计算
         2、用一个hash表来统计数量，然后取最大的那个。
         */
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>( nums.length/2 );
        int max = 0;
        int max_key = 0;
        for( int i = 0; i < nums.length; i++ ){
            if( !map.containsKey(nums[i]) ){
                map.put( nums[i], 1 );
            }else{
                map.put( nums[i], map.get(nums[i])+1 );
            }
        }
        for( Map.Entry<Integer,Integer> mapElem : map.entrySet() ){
            if( mapElem.getValue() > max ){
                max = mapElem.getValue();
                max_key = mapElem.getKey();
            }
        }
        return max_key;
    }

    static void swap( int[] nums, int left, int right ){
        int temp =nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
    static void quickSort( int[] nums, int start, int end ){
        if( start >= end ){
            return;
        }
        int base = nums[start];
        int leftIndex = start;
        int rightIndex = end;
        while( leftIndex < rightIndex ){
            while( leftIndex < rightIndex && nums[rightIndex] > base){
                rightIndex--;
            }
            while( leftIndex < rightIndex && nums[leftIndex] <= base){
                leftIndex++;
            }
            swap(nums,leftIndex,rightIndex);
        }
        swap(nums,start,leftIndex); // 基准归位
        quickSort( nums,start,leftIndex-1 );
        quickSort( nums,rightIndex+1,end );
    }
    /**
     * 先快速排序，再取中位数
     * @param nums
     * @return
     */
    public static int majorityElement02(int[] nums) {
        /**
         1、先排序，再一遍计算
         */
        quickSort( nums,0,nums.length -1 );
        return nums[nums.length/2];
    }

    public static void main(String[] args) {
        int[] q = new int[]{2,2,1,1,1,2,2};
        System.out.println( majorityElement02(q));
        System.out.println(1/2);
    }
}
