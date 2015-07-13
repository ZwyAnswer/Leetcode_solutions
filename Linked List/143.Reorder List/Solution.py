class Solution:
    # @param head, a ListNode
    # @return nothing
    def reorderList(self, head):
        if not head or not head.next or not head.next.next:
            return head
        fast = slow = head
        while fast and fast.next :
            fast = fast.next.next
            slow = slow.next
        head1 = head
        head2 = slow.next
        slow.next = None
        
        border = head2
        p = head2.next
        border.next = None
        while p:
            tmp = p
            p = p.next
            tmp.next = border
            border = tmp
        head2 = border
        
        p1 = head1; p2 = head2
        while p2:
            tmp1 = p1; p1 = p1.next
            tmp2 = p2; p2 = p2.next
            tmp1.next = tmp2
            tmp2.next = p1