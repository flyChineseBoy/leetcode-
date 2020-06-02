/*
 * PACKAGE_NAME
 * @author: lele
 * @date: 2020-05-04
 */
public class Ti55_跳跃游戏 {
    /**
     *1、 DFS骚操作，效率低
     */
    int[] mem; // 0代表未遍历，1代表已经计算且为true
    public boolean canJump(int[] nums) {
        // dfs 可能性？
        mem = new int[nums.length];
        return dfs(nums,0);
    }

    boolean dfs( int[] nums, int start){
        if( start>=nums.length-1 ) return true;
        if( nums[start]==0 ) return false;
        if( mem[start]!= 0 ) return mem[start]==1?true:false;
        boolean res = false;
        for( int i=1; i<=nums[start]; i++ ){
            res |= dfs(nums,start+i);
        }
        mem[start] = res?1:-1;
        return res;
    }

    /**
     * 2、贪心法
     */
    public boolean canJump02(int[] nums) {
        // 贪心法，达到一个地方，都去更新·我·能够到达的的最远的地方
        int moreFar = 0;
        for( int i=0; i< nums.length; i++ ){
            if( moreFar < i ) break;
            if( i+nums[i]>moreFar ) moreFar=i+nums[i];
        }
        if( moreFar>=nums.length-1 ) return true;
        return false;
    }

}
