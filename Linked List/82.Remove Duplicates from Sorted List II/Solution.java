/**
 * 相较于83题，要求链表中重复了的结点全移去。
 * 题目地址：https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
**/
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode pHead = new ListNode(0);
        pHead.next = head;
        ListNode p = pHead, q = head;  
        while( p.next != null) {
            while(q.next != null && q.next.val == p.next.val)  //跳过重复
                q = q.next;
                
            if(p.next == q) {  //不重复
                p = q;
                q = q.next;
            } else {
                p.next = q.next;  //有重复，删除所有重复的。
            }
        }
        return pHead.next;
    }
}