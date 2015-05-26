# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    # @return a ListNode
    def removeNthFromEnd(self, head, n):
        if not head: return None
        pnode = ListNode(0)
        pnode.next = head
        p1 = p2 = pnode
        for i in range(n):
            p1 = p1.next
        while p1.next:
            p1 = p1.next
            p2 = p2.next
        p2.next = p2.next.next
        return pnode.next