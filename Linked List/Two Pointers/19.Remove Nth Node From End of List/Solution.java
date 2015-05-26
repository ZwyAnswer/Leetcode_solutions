/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 *
 * 移除距离链表尾第n个结点(要明确，最后一个结点n = 1)，那么首先要找到这个结点（参考CTCI 2.2题）
 * 由于是单向链表，不知道链表长度(最好别先遍历一遍链表），又希望不使用额外的空间
 * 要在链表上单次遍历，直接在链表上原处删除，那么只有用Two pointer。 
 */
public class Solution {
	/**
		用两个指针p1,p2。让p2领先p1先走n-1步，那么这时p1,p2同时前进，p2走到最后一个结点时，p1指向要删除的结点。
		由于删除某结点的操作，必须有指向该结点的前一个结点的指针，那么最终p1的最终位置应该在被删除结点的前一个
	**/
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(n <= 0) return null;
        ListNode pNode = new ListNode(0);  //构造伪头结点，那么p1,p2从伪头结点开始遍历，最终p1会指向待删结点的前一个
        pNode.next = head;
        ListNode p1 = pNode, p2 = pNode;
        for(int i = 0; i < n; i++) {   //最终p1,p2相距n步，那么p2应先走n步
            if(p2 != null) p2 = p2.next;
        }
        if(p2 == null) return null;  
        
        while(p2.next != null) {  //p1, p2同时前进，直至p2到链表尾
            p1 = p1.next;
            p2 = p2.next;
        }
        p1.next = p1.next.next;
        return pNode.next;  //不应该返回head，防止原头结点被删除的情况
    }
}