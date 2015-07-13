/**
 * 按给定值给链表分区，小于x的结点部分在前，大于等于的在后，保持原结点的相对顺序
 * 与给数组分区的算法不同(快排中的partition算法)
 * 题目地址：https://leetcode.com/problems/partition-list/
**/
public class Solution {
    /**
     * 要保持链表中大于x和小于x的相对顺序，只能依次插入。
     * 遍历链表，根据与x的大小关系，依次插入到两个链表中，最后再合并链表
    **/
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) return head;
        ListNode pHead1 = new ListNode(0), pHead2 = new ListNode(0);
        ListNode p = head,  l1 = pHead1, l2 = pHead2;
        while(p != null) {
            if(p.val < x) {   //比值插入
                l1.next = p;
                p = p.next;
                l1 = l1.next;
            } else {
                l2.next = p;
                p = p.next;
                l2 = l2.next;
            }
        }
        l1.next = pHead2.next;  //合并两个部分
        l2.next = null;
        return pHead1.next;
    }
}