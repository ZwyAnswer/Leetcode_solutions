class Solution:
    # @param two ListNodes
    # @return a ListNode
    def mergeTwoLists(self, l1, l2):
        if not l1: return l2
        if not l2: return l1
        nhead = ListNode(0)
        p = nhead
        while l1 and l2:
            if l1.val <= l2.val:
                p.next = l1
                p = p.next
                l1 = l1.next
            else:
                p.next = l2
                p = p.next
                l2 = l2.next
        if not l1:
            p.next = l2
        if not l2:
            p.next = l1
        return nhead.next