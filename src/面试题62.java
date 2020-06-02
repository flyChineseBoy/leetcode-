import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class 面试题62 {
    public static int lastRemaining(int n, int m) {
        // 暴力
        // 用arraylist模拟游戏过程，复杂度最差 O(n^2)
        List<Integer> list = new ArrayList<Integer>();
        for( int i=0; i<n; i++ ){
            list.add(i);
        }

        for( int i=(m-1)%n; n>1; i=(i+m-1)%n ){
            list.remove(i); // remove时间复杂度 n
            n--;
        }
        return list.get(0);
    }

    public static void main(String[] args) {
        System.out.println(lastRemaining( 5,2 ));
        Optional<ArrayList> a=Optional.ofNullable( new ArrayList() );

        a.ifPresent(b->b.forEach(x-> System.out.println(x)));
    }
}
