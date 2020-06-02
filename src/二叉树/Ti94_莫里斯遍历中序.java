package 二叉树;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树
 *
 * @author: lele
 * @date: 2020-05-12
 */
public class Ti94_莫里斯遍历中序 {

    public List<Integer> inorderTraversal(TreeNode root) {
        //线索树:将二叉树转换成一个用右指针串联的链表
        List<Integer> res = new ArrayList<Integer>();
        TreeNode curr = root;
        TreeNode pre; // 前置节点

        while( curr!=null ){
            // 无左子树，直接看下一节点
            if( curr.left==null ){
                res.add(curr.val);
                curr = curr.right;
            }else{
                pre = curr.left;
                while( pre.right!=null ){
                    pre = pre.right;
                }
                pre.right =  curr;
                TreeNode tmp = curr;
                curr = curr.left; // 此时left一定不是null
                tmp.left=null;
            }
        }
        return res;
    }
}
