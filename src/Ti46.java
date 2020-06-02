import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Ti46 {
    public List<List<Integer>> permute(int[] nums) {
        // 回溯法
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        int[] used = new int[nums.length];

        dfs(nums,used,new ArrayList<Integer>(),res);

        return res;
    }

    /**
     *
     * @param nums 原始nums
     * @param i 本次需要使用的i元素
     * @param res 结果集
     */
    void dfs(int[] nums, int[] used,ArrayList<Integer> row,ArrayList<List<Integer>> res){
        if( row.size() == used.length ) {
            // 替换深度拷贝
            res.add( new ArrayList<Integer>(row) );
            return;
        }

        for( int i=0; i<used.length; i++ ){
            if( used[i]==0 ){
                row.add(nums[i]);
                used[i] = 1;
                dfs( nums,used,row,res);
                row.remove( row.indexOf(nums[i]) );
                used[i] = 0;
            }
        }
    }

    public ArrayList a =new ArrayList(2);

    public ArrayList test(ArrayList b){
        System.out.println( a==b);
        return b;
    }
    public static void main(String[] args) {
        Ti46 ti = new Ti46();
        System.out.println(ti.permute(new int[]{1,2,3}));
        ti.test(ti.a);

        ArrayList c = new ArrayList();
        System.out.println(ti.test( c )==c);
    }
}
