class Solution:
    # @param head, a ListNode
    # @return a ListNode
    def merge(self, head1, head2):
        if not head1: return head2
        if not head2: return head1
        pnode = ListNode(0)
        p = pnode
        while head1 and head2:
            if head1.val <= head2.val:
                p.next = head1
                head1 = head1.next
                p = p.next
            else:
                p.next = head2
                head2 = head2.next
                p = p.next
        if not head1:
            p.next = head2
        if not head2:
            p.next = head1
        return pnode.next
        
    def sortList(self, head):
        if not head or not head.next:
            return head
        fast = slow = head
        while fast.next and fast.next.next:
            fast = fast.next.next
            slow = slow.next
        head1 = head
        head2 = slow.next
        slow.next = None
        head1 = self.sortList(head1)
        head2 = self.sortList(head2)
        head = self.merge(head1, head2)
        return head