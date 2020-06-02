public class 面试64 {
    static int plus( int a,int b ){
        while( b>0 ){
            int sum = a^b; // 得到所有项的加法之后应该有的位置
            b = (a&b) << 1; //得到需要进位的项,也就是需要加1的项
            a = sum;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println( plus(2,3) );
    }
}
