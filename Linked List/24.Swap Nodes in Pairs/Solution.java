/**
 * 链表每两个结点交换顺序，要求不改变链表内的值，O(1)的空间复杂度
 * 题目地址：https://leetcode.com/problems/swap-nodes-in-pairs/
 * 相似题目：Reverse Nodes in k-Group
**/
public class Solution {
    /**
     * 使用一个遍历指针，利用插入的方法来交换结点顺序
     * 由于插入需要指向前一个结点的指针，故使用伪头结点
    **/
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode pHead = new ListNode(0);
        pHead.next = head;
        ListNode p = pHead;  //遍历指针，交换p.next和p.next.next两个结点
        while(p.next != null && p.next.next != null) {
            ListNode swap = p.next.next;  //当前待交换的结点
            //交换结点
            p.next.next = swap.next;
            swap.next = p.next;
            p.next = swap;
            p = p.next.next;  //更新遍历指针
        }
        return pHead.next;
    }