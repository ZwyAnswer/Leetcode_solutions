/**
 * 给定已排序的链表，构造对应的二叉查找树
 * 题目地址：https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
**/
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        listNode = head;
        int n = 0;
        ListNode node = head;
        while(node != null) {  //找出链表长度
            node = node.next;
            n++;
        }
        return sortedListToBST(0,n-1);
    }
    
    private ListNode listNode;
    
    private TreeNode sortedListToBST(int begin, int end) {
        if(begin > end) return null;
        int mid = (begin + end) / 2;
        TreeNode leftChild = sortedListToBST(begin, mid-1);
        TreeNode parent = new TreeNode(listNode.val);
        listNode = listNode.next;  //注意此处，遍历的时候同时更新链表当前结点指针
        parent.left = leftChild;
        TreeNode rightChild = sortedListToBST(mid+1, end);
        parent.right = rightChild;
        return parent;
    }
}