package 回溯法;/*
 * 回溯法
 * @author: lele
 * @date: 2020-04-28
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Ti47_全排列2 {
    public static List<List<Integer>> permuteUnique(int[] nums) {
        // 回溯法
        boolean[] used = new boolean[nums.length];
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.fill(used,true);
        dfs(nums,used,res,new ArrayList());

        return res;
    }
    /**
     used[i] : 第i个元素已经用过了
     res： 最终结果
     row: 当前正在计算的行
     */
    static void dfs( int[] nums, boolean[] used, List<List<Integer>> res,List<Integer> row ){
        System.out.print("---"+row.toString());
        if( row.size() == nums.length ){
            res.add( new ArrayList(row) );
            System.out.println("");
            return;
        }
        HashSet<Integer> set = new HashSet<Integer>();


        for( int i=0; i<nums.length; i++ ){
            if( used[i] && !set.contains(nums[i]) ){
                used[i] = false;
                row.add( nums[i] );
                dfs( nums,used,res,row );
                used[i] = true;
                row.remove(row.size()-1);
                set.add( nums[i] );
            }
        }
    }

    public static void main(String[] args) {
        permuteUnique(new int[]{2,2,1,1});
    }
}
