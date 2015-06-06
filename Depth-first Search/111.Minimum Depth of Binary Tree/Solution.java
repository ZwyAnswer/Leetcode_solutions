/**
	计算二叉树的最小深度（从根节点到叶子节点）
	题目地址：https://leetcode.com/problems/minimum-depth-of-binary-tree/
**/
public class Solution {
	/**
		DFS递归计算
		与计算最大深度不同的是，要考虑左右子树为空的情况。
	**/
    public int minDepth(TreeNode root) {
        if( root == null ) return 0;
        if( root.left == null) return minDepth( root.right ) + 1;
        if( root.right == null ) return minDepth( root.left ) + 1;
        return Math.min(minDepth(root.left),minDepth(root.right)) + 1;
    }
	
	/**
		BFS迭代计算，层次遍历
		一旦遇到叶节点，则立刻返回深度，此深度为最小深度
	**/
	public int minDepth2(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<> ();
        queue.add(root);
        int min = 0;
        
        while(!queue.isEmpty()) {
            int levelNum = queue.size();
            min++;
            for(int i = 0; i < levelNum; i++) {
                TreeNode node = queue.poll();
                if(node.left == null && node.right == null) return min;
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
        }
        return min;
    }
}