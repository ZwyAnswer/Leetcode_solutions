/**
 * 给定一颗树，判断其是否是对称结构的树
 * 题目地址：https://leetcode.com/problems/symmetric-tree/
**/
public class Solution {
    //递归
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isSymmetric(root.left, root.right);
    }
    
    private boolean isSymmetric(TreeNode node1, TreeNode node2) {
        if(node1 == null && node2 == null) return true;
        if(node1 == null || node2 == null) return false;
        if(node1.val != node2.val) return false;
        return isSymmetric(node1.right, node2.left) && isSymmetric(node1.left, node2.right);  //注意此处左右子树的顺序
    }

    //迭代
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        Stack<TreeNode> s1 = new Stack<> ();
        Stack<TreeNode> s2 = new Stack<> ();
        s1.push(root.left);
        s2.push(root.right);
        
        while(!s1.empty() && !s2.empty()) {
            TreeNode n1 = s1.pop();
            TreeNode n2 = s2.pop();
            if(n1 == null && n2 == null) continue;
            if(n1 == null || n2 == null) return false;
            if(n1.val != n2.val) return false;
            s1.push(n1.left);  //注意此处压栈的顺序
            s2.push(n2.right);
            s1.push(n1.right);
            s2.push(n2.left);
        }
        return true;
    }
}