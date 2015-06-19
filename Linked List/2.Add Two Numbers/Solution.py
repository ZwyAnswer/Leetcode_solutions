class Solution:
    # @return a ListNode
    def addTwoNumbers(self, l1, l2):
        if not l1: return l2
        if not l2: return l1
        flag = 0
        pnode = ListNode(0)
        p = pnode
        while l1 and l2:
            p.next = ListNode((l1.val + l2.val + flag) % 10)
            flag = (l1.val + l2.val + flag) / 10
            l1 = l1.next; l2 = l2.next
            p = p.next
        if l1:
            while l1:
                p.next = ListNode((l1.val + flag) % 10)
                flag = (l1.val + flag) / 10
                l1 = l1.next
                p = p.next
        if l2:
            while l2:
                p.next = ListNode((l2.val + flag) % 10)
                flag = (l2.val + flag) / 10
                l2 = l2.next
                p = p.next
        if flag == 1:
            p.next = ListNode(1)
        return pnode.next