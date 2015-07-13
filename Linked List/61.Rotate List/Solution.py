class Solution:
    # @param head, a ListNode
    # @param k, an integer
    # @return a ListNode
    def rotateRight(self, head, k):
        if not head or not head.next:
            return head
        if k == 0:
            return head
        p1 = head
        while k > 0:
            p1 = p1.next
            if not p1: p1 = head
            k -= 1
        p2 = head
        while p1.next != None:
            p1 = p1.next
            p2 = p2.next
        p1.next = head
        head = p2.next
        p2.next = None
        return head