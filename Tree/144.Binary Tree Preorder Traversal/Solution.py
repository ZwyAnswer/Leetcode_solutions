class Solution:
    # @param root, a tree node
    # @return a list of integers
    # 迭代
    def preorderTraversal(self, root):
        preorder = []
        if not root:
            return []
        stack = [root]
        while stack:
            root = stack.pop()
            preorder.append(root.val)
            if root.right:
                stack.append(root.right)
            if root.left:
                stack.append(root.left)
        return preorder

    class Solution:
    # @param root, a tree node
    # @return a list of integers
    # 递归
    def preorderTraversal(self, root):
        preorder = []
        if root:
            preorder.append(root.val)
            
            left = self.preorderTraversal(root.left)
            preorder.extend(left)
            
            right = self.preorderTraversal(root.right)
            preorder.extend(right)
            
        return preorder