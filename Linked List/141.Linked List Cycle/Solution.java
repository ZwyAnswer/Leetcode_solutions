/**
 * 判断一个链表是否含有环
 * 题目地址：https://leetcode.com/problems/linked-list-cycle/
**/
public class Solution {
	/**
	 * 使用快慢指针方法，快指针前进速度为慢的两倍
	 * 如果链表有环，则快慢指针最终会在环中某处相遇。
	**/
    public boolean hasCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) return true;
        }
        return false;
    }
}