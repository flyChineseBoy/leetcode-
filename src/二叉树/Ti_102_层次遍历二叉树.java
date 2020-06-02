package 二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树
 *
 * @author: lele
 * @date: 2020-05-13
 */
public class Ti_102_层次遍历二叉树 {
    /**
     *  1. 比较low的方法，用两个队列倒换
     *  2. 使用一个头结点
      */
    public List<List<Integer>> levelOrder(TreeNode root) {
        // 用一个队列来保存一层的节点
        if( root == null ){
            return new ArrayList();
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Queue<TreeNode> queue02 = new LinkedList<TreeNode>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        queue.offer( root );
        while( !queue.isEmpty() ){
            List<Integer> tmpRes =  new ArrayList<Integer>();
            while( !queue.isEmpty() ){
                TreeNode node = queue.poll();
                if( node != null ){
                    queue02.offer( node );
                    tmpRes.add(node.val);
                }
            }
            res.add(tmpRes);
            while( !queue02.isEmpty() ){
                TreeNode node = queue02.poll();
                if(node.left!=null) queue.offer( node.left );
                if(node.right!=null) queue.offer( node.right );
            }
        }
        return res;
    }

}
