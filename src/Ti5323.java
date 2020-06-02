import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Ti5323 {

    public static int[] sortByBits(int[] arr) {
        // 暴力枚举，所有元素计算1的个数。然后排序
        Integer[] binaryArr = new Integer[arr.length];
        for( int i=0; i<arr.length; i++ ){
            binaryArr[i] = arr[i];
        }

        Arrays.sort(binaryArr,new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                // & 1 操作
                int aCount = 0;
                int bCount = 0;
                int oA = a;
                int oB = b;
                for( int i=0; i<32; i++ ){
                    if( (a & 1) == 1 ) aCount++;
                    if( (b & 1) == 1 ) bCount++;
                    a >>= 1;
                    b >>= 1;
                }
                return aCount == bCount ? oA - oB: aCount - bCount;
            }
        });

        for( int i=0; i<arr.length; i++ ){
            arr[i] = binaryArr[i];
            System.out.println(arr[i]);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] a = new int[]{ 1024,512,256,128,64,32,16,8,4,2,1 };
        sortByBits(a);
        //new ArrayList(a).forEach( x-> System.out.println(x) );
    }
}
