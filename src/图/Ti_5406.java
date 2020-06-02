package 图;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 图
 *
 * @author: lele
 * @date: 2020-05-10
 */
public class Ti_5406 {
    HashMap<Integer,ArrayList<Integer>> tree;
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        // dfs，到叶子节点后判断是否有apple，有则true返回，无则false
        // 在树枝，若得到下面有apple，则总数量+2，否则不加
        buildTree( n,edges );
        return dfs(0,hasApple);
    }

    void buildTree( int n,int[][] edges ){
        tree = new HashMap<Integer,ArrayList<Integer>>();
        for( int i=0; i<edges.length; i++ ){
            ArrayList<Integer> nodes = tree.getOrDefault(edges[i][0],new ArrayList<Integer>());
            nodes.add(edges[i][1]);
            tree.put( edges[i][0], nodes);
        }
    }
    // 返回需要的路径数量，i:当前所在节点
    // 需要注意一个坑：中间节点也可能存在苹果
    Integer dfs( int i , List<Boolean> hasApple ){
        List<Integer> nodes = tree.get(i);
        if( nodes==null && hasApple.get(i)) return 2;
        if( nodes==null && !hasApple.get(i)) return 0;

        Integer count=0;
        boolean flag = false; // 代表当前结点有苹果
        if( hasApple.get(i) ) flag = true;

        if( nodes!=null ){
            for( Integer node : nodes ){
                count += dfs(node,hasApple);
            }
        }
        if( ( count!=0 || flag ) && i!=0 ) count+=2;
        return count;
    }

    public static void main(String[] args) {
            Ti_5406 t = new Ti_5406();
        ;
        t.minTime(7,new int[][]{{0,1},{0,2},{1,4},{1,5},{2,3},{2,6}}, Arrays.asList(new Boolean[]{false,false,true,false,true,true,false}) );
    }
}
