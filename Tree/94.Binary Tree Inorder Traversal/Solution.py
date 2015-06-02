class Solution:
    # @param root, a tree node
    # @return a list of integers
	
	# 递归法 run time:148 ms
    def inorderTraversal(self, root):
        inorder = []
        if root:
            left = self.inorderTraversal(root.left)
            inorder.extend(left)
            
            inorder.append(root.val)
            
            right = self.inorderTraversal(root.right)
            inorder.extend(right)
        return inorder
		
	# 迭代法 run time:120 ms
	def inorderTraversal2(self, root):
        inorder = []
        stack = []
        while root or stack:
            if root:
                stack.append(root)
                root = root.left
            else:
                root = stack.pop()
                inorder.append(root.val)
                root = root.right
        return inorder