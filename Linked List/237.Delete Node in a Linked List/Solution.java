/**
 * 删除链表中某结点，但链表是以该结点的指针给出（即找不到头结点）
 * 被删结点不会是尾结点。
 * 题目地址：https://leetcode.com/problems/delete-node-in-a-linked-list/
 * 类似题目：Remove Linked List Elements
**/
public class Solution {
	/**
	 * 因为取不到待删除结点前一个结点的指针，故无法直接删除待删结点。
	 * 将后一个结点的值拷贝到待删结点，然后删掉待删结点的后一个结点，这样相当于删除了给定结点。
	**/
    public void deleteNode(ListNode node) {
        if(node == null) return;
        node.val = node.next.val;
        node.next = node.next.next;
    }
}