/**
 * 在O(nlogn)的时间内，使用常量的空间，对链表排序
 * 题目地址：https://leetcode.com/problems/sort-list/
 * 类似题目：Insertion Sort List， Sort Colors， Merge Two sorted lists
**/
public class Solution {
    /**
     * 要求在O(nlogn)时间内，又是链表，故使用归并排序
     * 主要在于merge插入法合并的函数
    **/
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode fast = head, slow = head;
        while(fast.next != null && fast.next.next != null) {  //注意此处的条件，不是fast != null
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode head1 = head, head2 = slow.next;
        slow.next = null;
        ListNode l1 = sortList(head1);
        ListNode l2 = sortList(head2);
        return merge(l1, l2);
    }
    
    //这部分merge算法同Merge Two sorted lists题
    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode pHead = new ListNode(0);
        ListNode cur = pHead, p1 = head1, p2 = head2;
        while(p1 != null && p2 != null) {
            if(p1.val < p2.val) {
                cur.next = p1;
                p1 = p1.next;
            } else {
                cur.next = p2;
                p2 = p2.next;
            }
            cur = cur.next;
        }
        if(p1 != null) cur.next = p1;
        if(p2 != null) cur.next = p2;
        return pHead.next;
    }
}