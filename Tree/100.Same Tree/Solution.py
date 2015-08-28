class Solution:
    # @param p, a tree node
    # @param q, a tree node
    # @return a boolean
    def isSameTree(self, p, q):
        if not p and not q: return True
        if not (p and q) or p.val != q.val:
            return False
        return self.isSameTree(p.left, q.left) \
                and self.isSameTree(p.right, q.right)