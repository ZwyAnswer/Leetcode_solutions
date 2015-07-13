/**
 * 链表插入排序
 * 题目地址：https://leetcode.com/problems/insertion-sort-list/
 * 相似题目：Sort List
**/
public class Solution {
    /**
     * 解法同基于数字的插入排序
     * 把待排序结点依次找到其在已排序部分中的插入位置
    **/
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode pHead = new ListNode(0);
        pHead.next = head;
        ListNode cur = head;  //cur代表待排序结点的前一个结点，cur.next代表当前待排序结点
        while(cur.next != null) {
            if(cur.val <= cur.next.val) cur = cur.next;  //注意此处，如果已有序，则直接更新cur。
            else {
                ListNode prev = pHead; //插入位置的指针
                while(prev.next.val < cur.next.val) {
                    prev = prev.next;  //找到插入位置
                }
                //插入待排序结点
                ListNode temp = cur.next;  
                cur.next = temp.next;
                temp.next = prev.next;
                prev.next = temp;
            }
        }
        return pHead.next;
    }
}