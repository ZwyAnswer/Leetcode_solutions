/**
 * 从链表中删去给定值的结点
 * 题目地址：https://leetcode.com/problems/remove-linked-list-elements/
 * 类似问题：Remove Element
**/
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if( head == null) return head;
        ListNode pHead = new ListNode(0);
        pHead.next = head;
        ListNode prev = pHead, current = head;  //用两个指针遍历，分别代表当前结点的前一个和当前结点
        
        while(current != null) {
            if(current.val == val) {
                prev.next = current.next;
                current = current.next;
            } else {
                prev = prev.next;
                current = current.next;
            }
        }
        return pHead.next;
    }
}