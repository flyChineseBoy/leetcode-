import java.util.*;
import java.util.LinkedList;

public class Ti347 {
    public static List<Integer> topKFrequent(int[] nums, int k) {
        /**
         1、一遍统计，排序，然后再遍历找到第k个 。 需要排序的复杂度。
         2、构造k大小的最大堆，一遍统计，然后一个个入堆。
         */
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for( int i : nums ){
            map.put( i, map.getOrDefault(i,0)+1 );
        }

        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(
                (n1,n2) -> (map.get(n1)-map.get(n2))
        );
        // n1-n2是升序，n2-n1是降序



        map.forEach((key,v)->{
            heap.add( key );
            if( heap.size() > k ){
                heap.poll();
            }
        });

        List<Integer> top_k = new LinkedList<Integer>();
        while( !heap.isEmpty() ){
            top_k.add( heap.poll() );
        }
        Collections.reverse(top_k);
        return top_k;
    }

    public static void main(String[] args) {
        int nums[] =  new int[]{4,1,-1,2,-1,2,3};
        //System.out.println( topKFrequent(nums,2) );
        int nums2[] = nums;
        nums[0] = 9;
        System.out.println(nums[0]);
        System.out.println(nums2[0]);
    }
}
