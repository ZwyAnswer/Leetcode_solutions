/**
 * 验证是否是BST
 * 题目地址：https://leetcode.com/problems/validate-binary-search-tree/
 * 类似题目：Binary Tree Inorder Traversal
**/
public class Solution {
    private TreeNode pre = null;
    
    public boolean isValidBST(TreeNode root) {
        return inOrderCheck(root);
    }
    
	/**
	 * 利用BST中序遍历是单调递增的特点来验证
	 * 一旦发现逆序，则立即返回。
	 * 递归实现中序遍历，每次比较当前结点与前一结点
	**/
    private boolean inOrderCheck(TreeNode node) {
        if(node == null) return true;
        if(!inOrderCheck(node.left)) return false;
        if( pre != null && pre.val >= node.val ) return false;
        pre = node;
        if(!inOrderCheck(node.right)) return false;
        return true;
    }
	
	/**
	 * 利用BST的性质，每个结点均在某个(min,max)范围内
	 * 递归遍历检查的同时，递归更新这些范围，一旦不通过检查则返回false
	**/
	public boolean isValidBST2(TreeNode root) {
        return valid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean valid(TreeNode p, long low, long high) {
        if (p == null) return true;
        return p.val > low && p.val < high
            && valid(p.left, low, p.val)
            && valid(p.right, p.val, high);
    }
}