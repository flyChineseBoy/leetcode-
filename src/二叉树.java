import 二叉树.TreeNode;
public class 二叉树 {

        static TreeNode subtreeWithAllDeepest(TreeNode root) {
            // DFS的同时保留深度和父元素
            if(root==null) return null;
            Node node = dfs(root,1,null);

            return node.parent;
        }


        static Node dfs(TreeNode node, int depth, TreeNode parent ){
            if( node==null ) return null;
            if( node.left==null && node.right==null ){
                return new Node(node,depth,parent);
            }
            Node left = dfs( node.left, depth+1, node );
            Node right = dfs( node.right, depth+1, node );

            if( right==null ) return left;
            if( left!=null && left.depth>right.depth ){
                return left;
            }
            return right;
        }


    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        treeNode.left  = treeNode2;
        subtreeWithAllDeepest(treeNode);
    }
}

/*class 二叉树.TreeNode {
    int val;
    二叉树.TreeNode left;
    二叉树.TreeNode right;
    二叉树.TreeNode(int x) { val = x; }
}*/
class Node{
    TreeNode node;
    int depth;
    TreeNode parent;
    Node(TreeNode node, int depth, TreeNode parent){ this.node=node;this.depth=depth;this.parent=parent; }
}