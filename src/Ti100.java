import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import 二叉树.TreeNode;

public class Ti100 {
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        // 迭代，使用队列实现
        Queue<TreeNode> qStack = new LinkedList<TreeNode>();
        Queue<TreeNode> pStack = new LinkedList<TreeNode>();
        qStack.offer(q);
        pStack.offer(p);
        while( !(qStack==null && pStack==null) ){
            TreeNode tmpP = pStack.poll();
            TreeNode tmpQ = qStack.poll();
            // if( tmpP==null && tmpQ==null) return true;
            if( tmpP==null || tmpQ==null) return false;
            if(tmpP.val != tmpQ.val) return false;
            qStack.offer(tmpQ.left);
            qStack.offer(tmpQ.right);
            pStack.offer(tmpP.left);
            pStack.offer(tmpP.right);
        }

        return true;
    }

    public static void main(String[] args) {
        //二叉树.TreeNode p = new 二叉树.TreeNode(1);
        //二叉树.TreeNode q = new 二叉树.TreeNode(1);

    }
}
