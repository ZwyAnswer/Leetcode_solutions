/**
	计算二叉树的最大深度
	题目地址：https://leetcode.com/problems/maximum-depth-of-binary-tree/
**/
public class Solution {
	// 递归计算(DFS)， 同先序遍历，时间复杂度O(N), 空间复杂度O(LogN)
    public int maxDepth(TreeNode root) {
        if( root == null ) return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;  
    }
	
	// 迭代计算(BFS), 同层次遍历, 时间复杂度O(N), 空间复制度O(1)
	public int maxDepth2(TreeNode root) {
        if(root == null) return 0;
        int deep = 0;
        Queue<TreeNode> queue = new LinkedList<> ();
        queue.add(root);
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            deep++;
            for( int i = 0; i < size; i++) {  
                TreeNode node = queue.poll();
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
        }
        return deep;
    }
}