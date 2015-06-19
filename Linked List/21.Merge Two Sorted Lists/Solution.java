/**
 *	合并两个有序链表，得到一个新的有序链表。
 *	类似于归并排序中的Merge操作，只不过归并排序中是对数组合并。
 *	题目地址：https://leetcode.com/problems/merge-two-sorted-lists/
**/
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode pHead = new ListNode(0);  //注意伪头结点的使用
        ListNode current = pHead;
        ListNode p = l1, q = l2;
        
        while( p != null && q != null) {
            if(p.val <= q.val) {
                current.next = p;
                current = current.next;
                p = p.next;
            } else {
                current.next = q;
                current = current.next;
                q = q.next;
            }   
        }
        if( p != null ) current.next = p;
        if( q != null ) current.next = q;
        return pHead.next;
    }
}