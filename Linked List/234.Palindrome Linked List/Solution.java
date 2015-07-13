/**
 * 判断链表所含的值连起来是否构成回文
 * 题目地址：https://leetcode.com/problems/palindrome-linked-list/
 * 相似题目：Valid Palindrome，Palindrome Number，Reverse Linked List
**/
public class Solution {
    /**
     * 判断一个链表是否为回文链表的方法有：
     * 1. 反转后半部分链表与前半部分比较，若相同，则为回文。
     * 2. 使用栈，把前半部分的结点压栈。而后依次出栈与后半部分结点比较
     * 3. 递归
    **/
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode fast = head, slow = head;
        Stack<Integer> stack = new Stack<>();
        while(fast != null && fast.next != null) {  //使用快慢指针来找到链表的中间，
            stack.push(slow.val);   //前半部分结点值压栈
            fast = fast.next.next;
            slow = slow.next;
        }
        if(fast != null)  //若链表长度为偶数，则从第n/2+1个结点开始与前半部分开始比较。
            slow = slow.next;
            
        
        while(slow != null) {   //即从链表中间，前半部分向前遍历同时后半部分向后遍历来比较
            if(slow.val != stack.pop()) return false;
            slow = slow.next;
        }
        return true;
    }
}