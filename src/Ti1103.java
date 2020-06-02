public class Ti1103 {
        public static int[] distributeCandies(int candies, int num_people) {
                // 暴力法
                // 求candies是1+……+m这个m是多少。
                // 求(1+m)*m/2 <= candies 即  (1+m)*m <= candies*2
                // 二分法查找m。找到的m必然是 (1+m)*m <= candies*2 且 candies-m*(1+m)/2 < m的。
                // candies-m(1+m)/2得到剩余糖果
                // 最后分配到每个人身上。

                int right = candies/2;
                int left = 0;
                int m = (right+left)/2;
                while( left < right ){
                    if( (1+m)*m/2 <= candies &&  candies-m*(1+m)/2 < m ){
                        break;
                    }else if( (1+m)*m/2 > candies ){
                        right = m-1;
                    }else{
                        left = m+1;
                    }
                    m = (right+left)/2;
                }

                int rouonds = m / num_people; // 共多少轮
                int retain = candies - (rouonds*num_people)*(rouonds*num_people+1)/2; // 最后还剩多少糖果
                int[] res = new int[num_people];
                for( int i=0; i<num_people; i++ ){
                    res[i] =  rouonds*(i+1) +num_people*(rouonds*(rouonds-1)/2); // 1 1+n 1+2n 1+3n
                    if( retain > 0 ){
                        res[i] += Math.min( retain, rouonds*num_people+1+i );
                        retain -= Math.min( retain, rouonds*num_people+1+i );;
                    }
                }
                return res;
            }

    public strictfp static void main(String[] args) {
        //System.out.println( distributeCandies(10,3)[0] );
        System.out.println( 1000000000 );
        Ti1103 t = new Ti1103();
        t.e();
        }
        strictfp void e(){
            double a = 0.1d;
            double b = 0.2d;
            System.out.println(  a+b  ); // 小数计算有误差
        }
}
