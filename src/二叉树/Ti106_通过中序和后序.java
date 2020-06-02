package 二叉树;

import java.util.HashMap;
import java.util.Map;

/**
 * 二叉树
 *
 * @author: lele
 * @date: 2020-05-22
 */
public class Ti106_通过中序和后序 {
    private Map<Integer,Integer> map = new HashMap<Integer,Integer>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // 与前序遍历是个相反的操作
        for( int i=0; i<postorder.length; i++ ){
            map.put( inorder[i],i );
        }
        return dfs(inorder,postorder,0,postorder.length-1,0,postorder.length-1);
    }
    public TreeNode dfs( int[] inorder,int[] postorder, int in_left, int in_right, int post_left,int post_right ){
        if( post_left>post_right ) return null;

        TreeNode root = new TreeNode( postorder[post_right] );
        int in_root_index = map.get(root.val);

        int right_sum = in_right -in_root_index;

        // 2,4,  1,3
        root.right = dfs(inorder,postorder,in_root_index+1
                ,in_right,post_right-right_sum, post_right-1);
        // 0,0,0,0
        root.left = dfs(inorder,postorder,in_left,in_root_index-1
                ,post_left,post_right-right_sum-1);
        return root;
    }

    public static void main(String[] args) {
        Ti106_通过中序和后序 t = new Ti106_通过中序和后序();
        t.buildTree( new int[]{9,3,15,20,7},new int[]{9,15,7,20,3} );
    }
}
