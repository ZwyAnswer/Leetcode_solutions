class Solution:
    # @param head, a ListNode
    # @param x, an integer
    # @return a ListNode
    def partition(self, head, x):
        if not head:
            return None
        head1 = ListNode(0)
        head2 = ListNode(0)
        p = head
        p1 = head1
        p2 = head2
        while p:
            if p.val < x:
                p1.next = p
                p = p.next
                p1 = p1.next
                p1.next = None
            else:
                p2.next = p
                p = p.next
                p2 = p2.next
                p2.next = None
        p1.next = head2.next
        return head1.next