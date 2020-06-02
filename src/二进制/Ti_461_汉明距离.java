package 二进制;

/**
 * 二进制
 *
 * @author: lele
 * @date: 2020-05-12
 */
public class Ti_461_汉明距离 {
    // 汉明距离：二进制位不同的位数，注意，不是相同而是不同……
    public int hammingDistance(int x, int y) {
        // 二进制位不同的数目
        int sum = 0;
        while( x>0 || y>0 ){
            int a = x & 1;
            int b = y & 1;
            if( a!=b ) sum++;
            x >>= 1;
            y >>= 1;
        }
        return sum;
    }

    public static void main(String[] args) {
        Ti_461_汉明距离 t = new Ti_461_汉明距离();
        t.hammingDistance( 1,4 );
    }
}
