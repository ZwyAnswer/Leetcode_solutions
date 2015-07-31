/**
 * 二叉树基本操作：后序遍历(left-right-root)
 * 题目地址：https://leetcode.com/problems/binary-tree-postorder-traversal/
 * 类似题目：Binary Tree Preorder/Inorder Traversal 
**/
public class Solution {
    //递归
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<> ();
        postOrderHelper(root, result);
        return result;
    }
    
    private void postOrderHelper(TreeNode node, List<Integer> result) {
        if(node == null) return;
        postOrderHelper(node.left, result);
        postOrderHelper(node.right, result);
        result.add(node.val);
    }

    //迭代(用最简单的二叉树试验)
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        stack.push(current);
        
        while(!stack.isEmpty()) {
            current = stack.pop();
            result.add(current.val);
            if(current.left != null) stack.push(current.left);
            if(current.right != null) stack.push(current.right);
        }
        Collections.reverse(result);  //反转结果列表
        return result;
    }
}