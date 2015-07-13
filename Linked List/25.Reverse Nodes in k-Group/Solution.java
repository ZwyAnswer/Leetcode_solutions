/**
 * 从链表头开始，每隔k个结点翻转一次链表。若最后的结点不足k个，则不翻转。
 * 要求只用O(1)的空间，故需要在原链表基础上进行翻转。反转链表的方法同206题
 * 题目地址：https://leetcode.com/problems/reverse-nodes-in-k-group/
 * 类似题目：Swap Nodes in Pairs
**/
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k <= 1) return head;
        ListNode pHead = new ListNode(0);
        pHead.next = head;
        int len = 0;
        ListNode node = head;  
        while(node != null) {  //计算链表长度
            node = node.next;
            len++;
        }
        
        int times = len / k;  //得到需要翻转k个结点的次数
        //使用了3个指针，遍历时分别指向当前待反转部分的头部，反转结点前一结点和当前反转结点
        ListNode prev = pHead, start = head, reverse = start.next; 
        while(times > 0) {
            for(int i = 0; i < k-1; i++) {  //翻转当前k个结点
                start.next = reverse.next;
                reverse.next = prev.next;
                prev.next = reverse;
                reverse = start.next;
            }
            prev = start;  //每次反转了k个，更新指针
            start = prev.next;
            if(start != null) reverse = start.next;
            times--;
        }
        return pHead.next;
    }
}