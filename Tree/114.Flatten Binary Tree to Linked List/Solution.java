/**
 * 把二叉树压平为链表（压平的链表顺序为对应先序遍历序列）
 * 题目地址：https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
**/
public class Solution {
    public void flatten(TreeNode root) {
        if(root == null) return;
        TreeNode left = root.left;
        TreeNode right = root.right;
        flatten(left);
        flatten(right);
        
        root.left = null;
        root.right = left;  //压平的第一个右结点为左结点
        TreeNode leftMostRight = root;  //找到压平后左子树的最后一个结点
        while( leftMostRight.right != null) 
            leftMostRight = leftMostRight.right;
        leftMostRight.right = right; //接上压平后的右子树
    }
}