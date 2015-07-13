/**
 * 如果链表有环，找到环的开始处。否则返回null。 要求不使用额外空间。
 * 题目地址：https://leetcode.com/problems/linked-list-cycle-ii/
**/
public class Solution {
    /**
     * 算法步骤： 1.创建快慢指针，快的速度比慢的快一倍，循环至其相遇。
     * 2.相遇后，把慢指针放回链表头，同时同速移动快慢指针，直至其相遇。
     * 3.相遇点即是链表环的开始出。
     * 4.证明可画图进行证明。
    **/
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                slow = head;
                while(fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }
}