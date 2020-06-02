import java.util.*;

public class Ti923 {

    // 错误
    // 想法：将A distinct，用hash保存A的重复元素的个数，剩下的distinct数组在进行双指针。
    // 在遇到合适条件时，直接取出hash中数量进行相乘。
    public static int threeSumMulti(int[] A, int target) {
        // 双指针法
        Arrays.sort(A);

        int sum = 0;
        for( int i=0; i<A.length; i++ ){
            int left = i+1;
            int right = A.length-1;
            while( left < right ){
                int temp =  A[i]+A[left]+A[right];
                if( temp==target ){
                    int L = 1;
                    int R = 1;
                    if( A[left] == A[right] ){ // 特殊情况，left与right接轨
                        while( A[left] == A[left+1] && left+1!=right ){
                            L++;
                            left++;
                        }
                    }else{
                        while( A[left] == A[left+1] ){
                            L++;
                            left++;
                        }
                        while( A[right] == A[right-1] ){
                            R++;
                            right--;
                        }
                    }

                    sum = sum+ L*R;
                    left++;
                    right--;
                }else if( temp>target ){
                    right--;
                }else{
                    left++;
                }
            }
        }
        return sum;

    }

    public static int threeSumMulti2(int[] A, int target) {
        // 双指针法
        //Arrays.sort(A);
        ArrayList<Integer> listA = new ArrayList();
        HashMap<Integer,Integer> hash = new HashMap<Integer,Integer>();
        for( int i=0; i<A.length; i++ ){
            if( !hash.containsKey( A[i] ) ){
                listA.add( A[i] );
                hash.put( A[i], 1 );
            }else{
                hash.put( A[i], hash.get(A[i])+1 );
            }
        }
        //if()

        int sum = 0;
        for( int i=0; i<listA.size(); i++ ){
            int left = i+1;
            int right = listA.size()-1;
            while( left < right ){
                int temp =  listA.get(i)+listA.get(left)+listA.get(right);
                if( temp==target ){
                    sum += hash.get(listA.get(i)) * hash.get(listA.get(left)) * hash.get(listA.get(right));
                    left++;
                    right--;
                }else if( temp>target ){
                    right--;
                }else{
                    left++;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args)
    {
        Integer[] A = new Integer[]{1,1,2,2,3,3,4,4,5,5};
        //System.out.println(threeSumMulti(A,8));
        //System.out.println(threeSumMulti2(A,8));
        int l = 100_00_000-8;
        int L=0,R=0;

        Arrays.sort(A,new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                // & 1 操作
                int aCount = 0;
                int bCount = 0;
                for( int i=0; i<32; i++ ){
                    if( (a & 1) == 1 ) aCount++;
                    if( (b & 1) == 1 ) bCount++;
                }
                return aCount-bCount;
        }


    });

        int aCount = 0;
        int a = 512;
        for( int i=0; i<32; i++ ){
            if( (a & 1) == 1 ) aCount++;
            a >>= 1;
            System.out.println(aCount);
        }
        System.out.println(aCount);

    }
}
