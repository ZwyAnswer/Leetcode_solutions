/**
 * 给定排好序的数组，构造对应的二叉查找树
 * 题目地址：https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 * 类似题目：Convert Sorted List to Binary Search Tree
**/
public class Solution {

    public TreeNode sortedArrayToBST(int[] num) {
        return sortedArrayToBST(num, 0, num.length - 1);
    }
    //利用折半的思想，递归求解
    public TreeNode sortedArrayToBST(int[] array, int begin, int end) {
        if(begin > end) return null;
        int mid = (begin + end) / 2;
        TreeNode tnode = new TreeNode(array[mid]);
        tnode.left = sortedArrayToBST(array, begin, mid-1);
        tnode.right = sortedArrayToBST(array, mid+1, end);
        return tnode;
    }


}