/**
 * 判断是否为平衡二叉树
 * 题目地址：https://leetcode.com/problems/balanced-binary-tree/
 * 类似题目：CTCI的4.1题。Maximum Depth of Binary Tree
**/
public class Solution {
	/**
	 * 根据平衡二叉树的定义，递归判断。
	 * 时间复杂度：O(N^2), 空间复杂度O(N)
	**/
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        return Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1
            && isBalanced(root.left) && isBalanced(root.right);
    }
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
	
	/**
	 * 由于计算树高时，涉及大量子树的重复计算，故应该在计算子树高度时加入平衡定义判断
	 * 用 -1 来代表不平衡，一旦不平衡则终止递归返回，若平衡则返回子树实际高度
	 * 时间复杂度O(N),空间复杂度O(N)
	**/
	public boolean isBalanced2(TreeNode root) {
        return maxDepth(root) != -1;
    }
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int l = maxDepth(root.left);
        if(l == -1) return -1;
        int r = maxDepth(root.right);
        if(r == -1) return -1;
        return Math.abs(l - r) <=1 ? Math.max(l,r)+1 : -1;
    }
}