/**
	给定一个升序排列的数组，把数组构造成对应的BST
	题目地址：https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
**/
public class Solution {
	/**
		由于BST的中序遍历为递增序列，故可以像二分查找那样进行分治的递归构造。
		BST与相应的遍历序列并不一一对应
	**/
    public TreeNode sortedArrayToBST(int[] num) {
        return sortedArrayToBST(num, 0, num.length - 1);
    }
    public TreeNode sortedArrayToBST(int[] array, int begin, int end) {
        if(begin > end) return null;
        int mid = (begin + end) / 2;
        TreeNode tnode = new TreeNode(array[mid]);
        tnode.left = sortedArrayToBST(array, begin, mid-1);
        tnode.right = sortedArrayToBST(array, mid+1, end);
        return tnode;
    }
}