/**
 * 相较于83题，要求链表中重复了的结点全移去。
 * 题目地址：https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
**/
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode pHead = new ListNode(0);
        pHead.next = head;
        ListNode p = pHead, q = head;  //p为
        while( p.next != null) {
            while(q.next != null && q.next.val == p.next.val)  //
                q = q.next;
                
            if(p.next == q) {
                p = q;
                q = q.next;
            } else {
                p.next = q.next;
            }
        }
        return pHead.next;
    }
}