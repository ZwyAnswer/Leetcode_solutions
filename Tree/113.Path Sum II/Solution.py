class Solution:
    # @param root, a tree node
    # @param sum, an integer
    # @return a list of lists of integers
    def pathSum(self, root, sum):
        ans = []
        if not root: return []
        self.dfs(root, root.val, [root.val], sum, ans)
        return ans
        
        
    def dfs(self, root, tmpsum, tmplist, sum, ans):
        if root.left == None and root.right == None:
            if tmpsum == sum: 
                ans.append(tmplist)
        if root.left:
            self.dfs(root.left, tmpsum + root.left.val, tmplist+[root.left.val], sum, ans)
        if root.right:
            self.dfs(root.right, tmpsum + root.right.val, tmplist+[root.right.val], sum, ans)