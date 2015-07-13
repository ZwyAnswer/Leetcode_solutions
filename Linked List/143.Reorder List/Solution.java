/**
 * 调整链表结点顺序，如L0→L1→…→Ln-1→Ln调整为L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 题目地址：https://leetcode.com/problems/reorder-list/
**/
public class Solution {
    /**
     * 按照调整规则，算法可分为以下几步：
     * 1.分割链表为两部分，L0-L1-...L[n/2],以及L[n/2]+1-...Ln
     * 2.反转链表L[n/2+1]...Ln为Ln....
     * 3.把链表2插依次插入到链表1中。
    **/
    public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) return;
        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null) {  //利用快慢指针分割链表为两部分
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode head1 = head, prev = slow.next;
        slow.next = null;
        
        ListNode pHead = new ListNode(0);  
        pHead.next = prev;
        ListNode reverse = prev.next;  
        while(reverse != null) {       //反转第二个链表
            prev.next = reverse.next;
            reverse.next = pHead.next;
            pHead.next = reverse;
            reverse = prev.next;
        }
        
        ListNode head2 = pHead.next;
        while(head2 != null) {   //把第二个链表依次插入到第一个链表中
            ListNode tmp1 = head1.next, tmp2 = head2.next;
            head1.next = head2;
            head2.next = tmp1;
            head1 = tmp1;
            head2 = tmp2;
        }
    }
}