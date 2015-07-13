/**
 * 将已排序链表中值重复的结点只留其一，其余去除。
 * 题目地址：https://leetcode.com/problems/remove-duplicates-from-sorted-list/
**/
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode p = head, q = p.next;
        while(q != null) {
            if( p.val == q.val) {  //若重复则跳到下一个
                q = q.next;
            } else {  //不重复时，则去重并跳到下一个。
                p.next = q;
                p = q;
                q = p.next;
            }
        }
        p.next = null;
        return head;
    }
}