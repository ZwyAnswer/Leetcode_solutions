class Solution:
    # @param head, a ListNode
    # @return a ListNode
    def deleteDuplicates(self, head):
        if not head or not head.next:
            return head
        phead = ListNode(0)
        phead.next = head
        p = phead
        temp = head
        while p.next:
            while temp.next and p.next.val == temp.next.val :
                temp = temp.next
            if temp == p.next:
                p = temp
                temp = temp.next
            else:
                p.next = temp.next
        return phead.next