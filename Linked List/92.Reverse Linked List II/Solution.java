/**
 * 反转链表中第m到第n个结点，1 ≤ m ≤ n ≤ length of list.
 * 题目地址：https://leetcode.com/problems/reverse-linked-list-ii/
**/
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null) return head;
        ListNode pHead = new ListNode(0);   
        pHead.next = head;   
        ListNode prev = pHead;
        for(int i = 0; i < m-1; i++) prev = prev.next;  //找到插入结点处
        ListNode start = prev.next, reverse = start.next;  //反转结点的前一个结点，当前反转结点
        
        for(int i = 0; i < n-m; i++) {
            start.next = reverse.next;
            reverse.next = prev.next;
            prev.next = reverse;
            reverse = start.next;
        }
        return pHead.next;
    }
}