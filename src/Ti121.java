import java.util.HashMap;

public class Ti121 {
    public static int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for( int i = 0; i < prices.length; i++ ){
            min = Math.min(min,prices[i]);
            max = Math.max(max,prices[i]-min);
        }
        if( max > min ){
            return max-min;
        }
        return 0;
    }

    public static void main(String[] args) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int[] a = new int[]{7,1,5,3,6,4};
        System.out.println(maxProfit(a));

    }
}
