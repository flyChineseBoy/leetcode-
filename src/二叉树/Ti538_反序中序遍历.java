package 二叉树;

import java.util.Stack;

/**
 * 二叉树
 *
 * @author: lele
 * @date: 2020-05-13
 */
public class Ti538_反序中序遍历 {
    public TreeNode convertBST(TreeNode root) {
        // 中序遍历反过来，右左中
        Stack<TreeNode> stack = new Stack<TreeNode>();
        int sum=0;

        TreeNode node = root;
        while( !stack.isEmpty() || node!=null ){
            while( node!=null ){
                stack.push( node );
                node = node.right;
            }

            node = stack.pop();
            sum = node.val + sum;
            node.val = sum;

            node = node.left;
        }
        return root;
    }

    public static void main(String[] args) {
        Ti538_反序中序遍历 t = new Ti538_反序中序遍历();

        TreeNode node = new TreeNode(5);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(13);
        node.left = node1;
        node.right = node2;
        System.out.println(t.convertBST(node));;
    }
}
