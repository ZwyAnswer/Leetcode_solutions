/**
 * 给定中序和后序序列，构造二叉树
 * 题目地址：https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
**/
public class Solution {
    //类比105题，递归构造
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length == 0 || postorder.length == 0) return null;
        return dfsBuild(inorder, postorder, postorder.length-1, 0, inorder.length-1);
    }
    
    private TreeNode dfsBuild(int[] inorder, int[] postorder, int postRoot, int start, int end) {
        if(postRoot < 0 || start > end) return null;
        TreeNode root = new TreeNode(postorder[postRoot]);
        int inRoot = 0;
        for(int i = 0; i < inorder.length; i++) {
            if(inorder[i] == postorder[postRoot]) {
                inRoot = i;
                break;
            }
        }
        root.left = dfsBuild(inorder, postorder, postRoot - end + inRoot - 1, start, inRoot-1);
        root.right = dfsBuild(inorder, postorder, postRoot-1, inRoot+1, end); 
        return root;
    }
}