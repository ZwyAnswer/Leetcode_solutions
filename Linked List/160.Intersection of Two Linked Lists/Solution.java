/**
 * 查找两个相交链表的相交点，如果未相交，则返回null
 * 要求O(n)的时间，O(1)的空间
 * 要求不破坏原链表结构，可以认为原链表无环
**/
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode nodeA = headA, nodeB = headB;
        int lenA = getLength(headA), lenB = getLength(headB);
        int gap = Math.abs(lenA - lenB);  //找的两链表长度之差
        for(int i = 0; i < gap; i++) {  //找到两个链表的同一起跑线
            if(lenA > lenB) nodeA = nodeA.next;
            else nodeB = nodeB.next;
        }
        
        while(nodeA != null && nodeB != null) {  //遍历直到两个指针重合，即为相交点。
            if(nodeA == nodeB) return nodeA;
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }
        return null;
    }
    
    //返回链表长度
    private int getLength(ListNode head) {
        int len = 0;
        while(head != null) {
            head = head.next;
            len++;
        }
        return len;
    }
}