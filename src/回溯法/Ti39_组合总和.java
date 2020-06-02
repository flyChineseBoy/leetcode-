package 回溯法;/*
 * 回溯法
 * @author: lele
 * @date: 2020-04-29
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ti39_组合总和 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // 回溯法，不需要used数组
        Arrays.sort(candidates); // 方便剪枝
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        dfs( 0, new ArrayDeque<Integer>(),target,res,candidates );
        return res;
    }

    // 起始下标，当前计算的行/路径，剩余需要求的数值,结果集,可用数组
    void dfs(int start, ArrayDeque<Integer> path, int target, List<List<Integer>> res, int[] candidates ){
        if( target==0 ){
            res.add( new ArrayList(path) );
            return;
        }else if( target<0 ){
            return;
        }

        for( int i=start; i<candidates.length; i++ ){
            if( candidates[i]>target ) break; // 剪枝
            // 将start传递下去，剪枝
            path.addLast( candidates[i] );
            dfs( i,path,target-candidates[i],res,candidates );
            path.removeLast( );
        }
    }
}
