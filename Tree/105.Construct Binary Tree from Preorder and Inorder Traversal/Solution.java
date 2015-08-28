/**
 * 给定二叉树的前序和中序遍历序列，构造二叉树
 * 题目地址：https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * 类似题目：Construct Binary Tree from Inorder and Postorder Traversal
**/
public class Solution {
    //递归构造
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0) return null;
        return dfsBuild(preorder, inorder, 0, 0, inorder.length-1);
    }
    //start，end代表当前构造子树对应的序列起始
    private TreeNode dfsBuild(int[] preorder, int[] inorder, int preorderRoot, int start, int end) {
        if(preorderRoot > preorder.length-1 || start > end) return null;
        TreeNode root = new TreeNode(preorder[preorderRoot]);  //用先序构造根节点
        int inorderRoot = 0;
        for(int i = 0; i < inorder.length; i++) {
            if(preorder[preorderRoot] == inorder[i]) {  //找到中序对应的根节点位置，以便分割左右子树
                inorderRoot = i;
                break;
            }
        }
        root.left = dfsBuild(preorder, inorder, preorderRoot+1, start, inorderRoot-1);
        root.right = dfsBuild(preorder, inorder, preorderRoot + inorderRoot - start + 1, inorderRoot+1, end);
        return root;
    }
}