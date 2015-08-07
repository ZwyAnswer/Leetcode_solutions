/**
 * 反转单链表，可以迭代或者递归来反转 
 * 题目地址：https://leetcode.com/problems/reverse-linked-list/
 * 相似题目：Palindrome Linked List
**/
public class Solution {
	//递归式反转，依然为头插
    public ListNode reverseList(ListNode head) {
        return reverse(head, null);
    }
    
    private ListNode reverse(ListNode head, ListNode newHead) {
        if(head == null) return newHead;  //递归终止条件
        ListNode headNext = head.next;
        head.next = newHead;
        return reverse(headNext, head);
    }

    //迭代反转，头插法，每次往新链表头部插入原链表的头结点。
    public ListNode reverseList2(ListNode head) {
        ListNode newHead = null;  //新链表的头
        while(head != null) {
            ListNode headNext = head.next;  //保存原链表当前结点下一结点
            head.next = newHead;
            newHead = head;
            head = headNext;  //下一次迭代前 保证两个链表的头指针均指向头结点
        }
        return newHead;
    }

    //迭代反转，直接在原链表上进行操作。例如，1-2-3-4先变换为2-1-3-4
    public ListNode reverseList3(ListNode head) {
        if(head == null || head.next == null) return head;
        //利用三个指针进行迭代，分别是伪头结点，原头结点以及当前反转的结点
        ListNode pHead = new ListNode(0);
        pHead.next = head;
        ListNode reverse = head.next;
        while(reverse != null) {
            head.next = reverse.next;
            reverse.next = pHead.next;
            pHead.next = reverse;
            reverse = head.next;
        }
        return pHead.next;
    }
}