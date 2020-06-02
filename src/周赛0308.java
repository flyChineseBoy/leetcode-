import java.util.*;
import java.util.LinkedList;

public class 周赛0308 {
    public static int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        // 求这棵加权树的最长路径。
        // headId为根节点，如何找到所有manager中为headID的下标(Map<Integer,List>)。进行广度优先遍历
        // informTime为0的是叶子节点，可以去掉

        int sum = 0;
        // 1、map保存 manager和对应的子节点
        Map<Integer,ArrayList<Integer>> map = new HashMap<Integer,ArrayList<Integer>>();
        for( int i=0; i<n; i++ ){
            ArrayList<Integer> list = map.getOrDefault( manager[i],new ArrayList<Integer>() );
            list.add(i);
            map.put( manager[i], list );
        }
        // 2、广度优先遍历树，对每一层取最大时间，加到结果
        Queue<Integer> queue = new LinkedList<Integer>(); // 当一层结束，加入一个哨兵节点来标识
        queue.offer( headID );
        queue.offer( -2 );
        //sum += informTime[headID];
        int row_sum = 0;
            while( !queue.isEmpty() ){
            Integer ele = queue.poll();
            if( ele == -2 ){ // 是哨兵节点，说明这一层结束了
                sum += row_sum;
                row_sum = 0;
                if( !queue.isEmpty() ){
                    queue.offer( -2 );
                }

            }else{ // 还没有结束，继续
                ArrayList<Integer> eleList = map.get(ele);
                row_sum = Math.max( row_sum, informTime[ele]);
                if( eleList!=null ){
                    eleList.forEach( x-> queue.offer(x) );
                }

            }
        }
        // 3、遍历结束。
        return sum;
    }

    public static void main(String[] args) {
        System.out.println( numOfMinutes(11,4,new int[]{5,9,6,10,-1,8,9,1,9,3,4},new int[]{0,213,0,253,686,170,975,0,261,309,337}) );
    }

}
