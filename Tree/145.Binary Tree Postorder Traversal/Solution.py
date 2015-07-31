class Solution:
    # @param root, a tree node
    # @return a list of integers
    def postorderTraversal(self, root):
        postorder = []
        if not root:
            return []
        stack = [root]
        while stack:
            root = stack.pop()
            postorder.append(root.val)
            if root.left:
                stack.append(root.left)
            if root.right:
                stack.append(root.right)
        return postorder[::-1]

    def postorderTraversal2(self, root):
        postorder = []
        if root:
            left = self.postorderTraversal(root.left)
            postorder.extend(left)
            
            right = self.postorderTraversal(root.right)
            postorder.extend(right)
            
            postorder.append(root.val)
        return postorder