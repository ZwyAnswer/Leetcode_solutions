class Solution:
    # @param head, a ListNode
    # @return a list node
    def detectCycle(self, head):
        fast = slow = head
        while fast and fast.next:
            fast = fast.next.next
            slow = slow.next
            if fast == slow:
                slow = head 
                while fast != slow:
                    fast = fast.next
                    slow = slow.next
                return fast
        return None