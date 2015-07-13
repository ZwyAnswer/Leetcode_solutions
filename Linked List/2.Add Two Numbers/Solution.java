/**
 *	两个链表相加，注意链表保存是先存低位再存高位，所以做加法的进位方向也同正常加法相反。
 *	题目地址：https://leetcode.com/problems/add-two-numbers/
**/
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pHead = new ListNode(0);  //伪头结点，为方便在其后插入和返回新链表
        ListNode current = pHead;
        ListNode p = l1, q = l2;  //两个遍历指针
        int carry = 0; //保存当前向下一位的进位
        
        while( p != null || q != null) {  //直至遍历到两个链表的尽头
            int x = ( p != null) ? p.val : 0;  //分别取两个链表的对应加数
            int y = ( q != null) ? q.val : 0;
            int sum = x + y + carry;   //当前位的和
            carry = sum / 10;   //更新进位
            current.next = new ListNode(sum % 10);  //构建当前位对应的结点
            
            current = current.next;   //更新当前构建指针以及两个遍历指针
            if( p != null ) p = p.next;
            if( q != null ) q = q.next;
        }
        //当前还有进位，则需要构建最后一个进位结点
        if( carry > 0) {
            current.next = new ListNode(carry);
        }
        return pHead.next;
    }
}