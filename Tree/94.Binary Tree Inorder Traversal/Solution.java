/**
 * 二叉树基本操作：中序遍历(left-root-right)
 * 题目地址：https://leetcode.com/problems/binary-tree-inorder-traversal/
 * 类似题目：Binary Tree Preorder/Postorder Traversal 
**/
public class Solution {
	/**
	 * 根据二叉树和中序遍历天然的递归定义，递归实现
	 * run time:300 ms
	**/
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<> ();
        inorderTraversalHelper(root, result);
        return result;
    }
    
    private void inorderTraversalHelper(TreeNode root, List<Integer> result) {
        if(root == null) return;
        inorderTraversalHelper(root.left, result);
        result.add(root.val);
        inorderTraversalHelper(root.right, result);
    }
	
	/**
	 * 迭代中序遍历，重点在于栈的利用
	**/
	public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<> ();
        Stack<TreeNode> stack = new Stack<> ();  //关键
        if(root == null) return result;
        TreeNode current = root;
        
        //注意循环条件是或的关系
        while(current != null || !stack.empty()) {
            while(current != null) {
                stack.push(current);
                current = current.left;  //先遍历到左子树为空的结点
            }
            current = stack.pop();
            result.add(current.val);
            current = current.right;
        }
        return result;
    }
}