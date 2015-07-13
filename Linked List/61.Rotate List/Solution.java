/**
 * 对链表进行右移k步，k为非负数
 * 题目地址：https://leetcode.com/problems/rotate-list/
**/
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k <= 0) return head;
        ListNode pHead = new ListNode(0);
        pHead.next = head;
        int len = 0;
        ListNode p = pHead;
        while(p.next != null) {  //找到链表长度，方便从头找待移结点。
            p = p.next;
            len++;
        }
        ListNode q = pHead;
        for(int i = 0; i < len - k % len; i++) {  //防止k过大导致TLE，取余。
            q = q.next;
        }
        p.next = pHead.next;
        pHead.next = q.next;
        q.next = null;
        return pHead.next;
    }
}