class Solution:
    # @param head, a ListNode
    # @return a ListNode
    def deleteDuplicates(self, head):
        if not head or not head.next: 
            return head
        p = head
        temp = head.next
        while temp:
            if temp.val == p.val:
                temp = temp.next
            else:
                p.next = temp
                p = temp
                temp = p.next
        p.next = None
        return head