/**
 * 二叉树基本操作：先序遍历(root-left-right)
 * 题目地址：https://leetcode.com/problems/binary-tree-preorder-traversal/
 * 类似题目：Binary Tree Inorder/Postorder Traversal 
**/
public class Solution {
    //按先序遍历的定义递归实现
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<> ();
        preorderTraversal(root, result);
        return result;
    }
    
    private void preorderTraversal(TreeNode node, List<Integer> result) {
        if(node == null) return;
        result.add(node.val);
        preorderTraversal(node.left, result);
        preorderTraversal(node.right, result);
    }

    //迭代先序遍历，关键在于栈的使用
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        Stack<TreeNode> stack = new Stack<> ();
        TreeNode current = root;
        stack.push(current);

        while(!stack.isEmpty()) {
            current = stack.pop();
            result.add(current.val);
            if(current.right != null) stack.push(current.right);  //注意先压人右子树
            if(current.left != null) stack.push(current.left);
        }
        return result;
    }
}