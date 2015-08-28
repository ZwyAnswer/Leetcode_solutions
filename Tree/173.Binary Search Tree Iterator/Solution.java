/**
 * 实现二叉树的迭代器
 * 题目地址：https://leetcode.com/problems/binary-search-tree-iterator/
**/
public class BSTIterator {
    
    private Stack<TreeNode> stack = new Stack<> ();  //关键在于使用栈

    public BSTIterator(TreeNode root) {
        pushLeft(root);
    }

    /** @return whether we have a next smallest number 时间复杂度O(1),空间复杂度O(h)*/
    public boolean hasNext() {
        return !stack.empty();  
    }

    /** @return the next smallest number 时间复杂度O(1),空间复杂度O(h)*/
    public int next() {
        TreeNode next = stack.pop();
        pushLeft(next.right);
        return next.val;
    }
    
    private void pushLeft(TreeNode node) {
        while(node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */