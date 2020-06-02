package 二叉树;

/**
 * 二叉树
 *
 * @author: lele
 * @date: 2020-05-13
 */
public class Ti_531_二叉树的直径 {
    int ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        //求最长路径 dfs
        // 一条路径长度可以看做一个节点的左子树的深度+右子树的深度+1
        // 答案就是将所有节点当做根节点遍历一次，找到最大的长度
        ans = 1; // 屏蔽深度为1时的问题：为1和为0时，ans最后都会减一为0
        dfs(root);
        return ans-1;
    }
    //  返回此节点往下的最长路径
    int dfs( TreeNode node ){
        if( node==null ) return 0;
        int left = dfs(node.left);
        int right = dfs(node.right);
        ans = Math.max(ans,left+right+1);
        return Math.max( left, right )+1;
    }
}
