class Solution:
    # @param head, a ListNode
    # @return a ListNode
    def insertionSortList(self, head):
        if not head: return head
        current = head
        pnode = ListNode(0)
        pnode.next = head
        while current.next:
            if current.val > current.next.val:
                pre = pnode
                while pre.next.val < current.next.val:
                    pre = pre.next
                temp = current.next
                current.next = temp.next
                temp.next = pre.next
                pre.next = temp
            else:
                current = current.next
        return pnode.next