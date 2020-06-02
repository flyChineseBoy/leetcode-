public class Ti231 {
    public static boolean isPowerOfTwo(int n) {
        // 2的幂次方，1右移31次即为所有的2的幂次方
        //if( n < 0 ) return false;
        int res = 1;
        for( int i=0; i<31; i++ ){
            if( n==res )
                return true;
            res <<= 1;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(-2147483648));
        //System.out.println( (1<<31)-1 );
    }
}
