import java.util.*;

public class TI491_连续子序列 {
    class Node{
        List<Integer> val; // 连续子序列
        int index;  // 下一个在nums中的下标
        Node(List<Integer> val,int index){ this.val=val;this.index=index; }
    }

    public List<List<Integer>> findSubsequences(int[] nums) {
        // 找出所有递增子序列
        // 从第一个字母开始，得到长度为2的递增子序列，以此类推
        // ** 需要考虑重复结果，这里写的代码比较恶心。
        List<List<Integer>> res =  new ArrayList<List<Integer>>();

        // 初始化所有长度为1的递增子序列。
        Stack<Node> stack =  new Stack<Node>();
        Set<Integer> set1  = new HashSet<Integer>();
        for( int i=0; i<nums.length; i++ ){
            if( !set1.contains(nums[i]) ){
                List<Integer> list = new ArrayList<Integer>();
                list.add(nums[i]);
                Node node = new Node(list,i+1);
                stack.push(node);
                set1.add(nums[i]);
            }
        }
        while( !stack.isEmpty() ){
            Node ele = stack.pop();
            // Set保存本次已经使用的元素
            Set<Integer> set  = new HashSet<Integer>();
            for( int j=ele.index; j<nums.length; j++ ){
                if( !set.contains(nums[j]) &&  nums[j]>=ele.val.get(ele.val.size()-1)){
                    List<Integer> list = new ArrayList<Integer>();
                    for( Integer old : ele.val ) list.add(old);
                    list.add( nums[j]);
                    set.add(nums[j]);
                    Node node = new Node(list,j+1);
                    stack.push(node);
                    res.add(list); // 保存结果
                }
            }
        }

        return res;

    }

    public static void main(String[] args) {
        TI491_连续子序列 c = new TI491_连续子序列();
        c.findSubsequences(new int[]{4,6,7,7});
    }
}
