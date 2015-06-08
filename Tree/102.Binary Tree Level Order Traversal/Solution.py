class Solution:
    # @param root, a tree node
    # @return a list of lists of integers
    def preOrder(self, root, level, ans):
        if root:
            if len(ans) < level+1: ans.append([])
            ans[level].append(root.val)
            self.preOrder(root.left, level+1, ans)
            self.preOrder(root.right, level+1, ans)
        
    def levelOrder(self, root):
        ans = []
        self.preOrder(root, 0, ans)
        return ans