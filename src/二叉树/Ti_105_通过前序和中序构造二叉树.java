package 二叉树;

import java.util.HashMap;
import java.util.Map;

/**
 * 二叉树
 *
 * @author: lele
 * @date: 2020-05-22
 */
public class Ti_105_通过前序和中序构造二叉树 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        private Map<Integer,Integer> map = new HashMap<Integer,Integer>();

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            // 有点倒排索引的意思？
            for( int i=0; i<inorder.length; i++ ){
                map.put( inorder[i],i );
            }

            return dfs( 0,preorder,inorder,0,inorder.length );
        }

        //root_pre_index 在前序遍历中的位置
        // left_index 在中序遍历中的左边界
        TreeNode dfs( int root_pre_index, int[] preorder,int[] inorder,int left_index,int right_index ){
            if( left_index >= right_index ) return null;


            // 生成根节点
            TreeNode root = new TreeNode( preorder[root_pre_index] );
            // 明确根节点在中序遍历中的位置，以区分两棵树
            int root_in_index = map.get(root.val);
            // 计算左子树总长度
            int left_sum = root_in_index - left_index;
            // 生成左子树 1 , 0, 2---2,0,1
            root.left = dfs( root_pre_index+1,preorder,inorder,left_index, left_index+left_sum );
            //生成右子树
            root.right = dfs( root_pre_index+left_sum+1,preorder,inorder,left_index+left_sum+1,
                    right_index);

            return root;
        }
    }
}
