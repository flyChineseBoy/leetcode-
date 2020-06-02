import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Ti264 {
    public static int nthUglyNumber(int n) {
        // 丑数即这个数 一直除2、3、5可以除到1；
        // 1、最简单的方法就是：对每一个数字都除5、除不动了除3、再处2，此时结果为1即丑数，不是就不是。
        // 2、上述方法n越大必然越慢，我们可以用一个hash保存之前为丑数的，一旦这个当前数做除法的结果 等于 hash中的元素，则可以确定这个数也是丑数。
        if( n==0 || n==1 ){
            return n;
        }
        HashSet<Integer> set = new HashSet<Integer>(n);
        int num = 1;
        while( set.size() < n ){
            if( num == 1 ||  isUglyNumber(num,set)  ){
                set.add( num );
            }
            num++;
        }
        return num-1;
    }

    static boolean isUglyNumber(int num, HashSet set){
        while( num%5==0 ){ // 直到num除5除不动了
            num = num/5;
            if(set.contains(num)){
                return true;
            }
        }
        while( num%3==0 ){ // 直到num除3除不动了
            num = num/3;
            if(set.contains(num)){
                return true;
            }
        }
        while( num%2==0 ){ // 直到num除2除不动了
            num = num/2;
            if(set.contains(num)){
                return true;
            }
        }
        if( num == 1){
            return true;
        }
        return false;
    }



    /**
     最小堆：从1开始不断将数压入最小堆，依次pop出，每出来一个，其的2、3、5倍入堆
     */
    public static int nthUglyNumber02(int n) {

        PriorityQueue<Long> heap = new PriorityQueue<Long>();
        HashSet<Long> set = new HashSet<Long>();
        heap.add(1l);
        Long min = 0l;
        while( n > 0 ){
            min = heap.poll();
            Long[] nums = new Long[3];
            nums[0] = min * 2l;
            nums[1] = min * 3l;
            nums[2] = min * 5l;

            for( Long i : nums ){
                if( !set.contains(i) ){
                    heap.add( i );
                    set.add( i );
                }
            }
            n--;
        }
        return Integer.valueOf( String.valueOf( min ) );
    }
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        queue.add(1);
        queue.peek();
        System.out.println( Arrays.asList(queue.toArray()) );
        //queue.poll();
        //System.out.println( nthUglyNumber(497) );
        System.out.println( 536870912 * 5);

        Long[] nums = new Long[3];
        //nums[0] = min * 2l;

    }
}
