/**
 * 找到二叉树的最大路径和
 * 题目地址： https://leetcode.com/problems/binary-tree-maximum-path-sum/
 * 类似题目：Sum Root to Leaf Numbers
**/
public class Solution {
    private int maxSum;
    
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        findMax(root);
        return maxSum;
    }
    
    private int findMax(TreeNode node) {
        if(node == null) return 0;
        int leftMax = Math.max(0, findMax(node.left));
        int rightMax = Math.max(0, findMax(node.right));
        maxSum = Math.max(maxSum, leftMax + rightMax + node.val);
        return node.val + Math.max(leftMax, rightMax);
    }
}