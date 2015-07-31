/**
 * 找到二叉树的最小深度，最小深度指的是根节点到最近叶节点的最短路径
 * 题目地址：https://leetcode.com/problems/minimum-depth-of-binary-tree/
 * 类似题目：Binary Tree Level Order Traversal，Maximum Depth of Binary Tree
**/
public class Solution {
	//dfs
    public int minDepth(TreeNode root) {
        if( root == null ) return 0;
        if( root.left == null) return minDepth( root.right ) + 1;
        if( root.right == null ) return minDepth( root.left ) + 1;
        return Math.min(minDepth(root.left),minDepth(root.right)) + 1;
    }

    //bfs
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<> ();
        queue.add(root);
        int min = 0;
        
        while(!queue.isEmpty()) {
            int levelNum = queue.size();
            min++;
            for(int i = 0; i < levelNum; i++) {
                TreeNode node = queue.poll();
                if(node.left == null && node.right == null) return min;  //第一次碰到叶节点则返回
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
        }
        return min;
    }
}