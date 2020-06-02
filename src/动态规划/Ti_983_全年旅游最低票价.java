package 动态规划;

import java.util.HashSet;
import java.util.Set;

/*
 * 动态规划
 * @author: lele
 * @date: 2020-05-06
 */
public class Ti_983_全年旅游最低票价 {
    Integer[] memo = new Integer[366];
    Set<Integer> days = new HashSet<Integer>();
    int[] costs;

    public int mincostTickets(int[] days, int[] costs) {
        // 动态规划 牛逼
        //  memo[i]代表从第i天开始到年底的花销
        // 时间复杂度366，每天计算一次
        for( int day : days ){
            this.days.add( day );
        }
        this.costs = costs;
        this.memo[0] = 0;
        return cost(1);
    }

    /**
     day : 当前是在第几天
     */
    Integer cost( int day ){
        if( day > 365 ) return 0;
        if( memo[day] != null ) return memo[day];

        if( days.contains(day)  ){
            memo[day] = Math.min( costs[0]+cost(day+1)
                    ,Math.min( costs[1]+cost(day+7),costs[2]+cost(day+30) ) );
        }else{
            memo[day] = cost(day+1);
            //memo[day-1]==null?0 : memo[day-1];
        }
        return memo[day];
    }

    public static void main(String[] args) {
        Ti_983_全年旅游最低票价 a = new Ti_983_全年旅游最低票价();
       // System.out.println( a.mincostTickets(new int[]{1,4,6,7,8,20}, new int[]{2,7,15}) );
        System.out.println(6^7);
    }

}
