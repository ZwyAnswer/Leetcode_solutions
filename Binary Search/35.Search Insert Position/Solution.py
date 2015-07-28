class Solution:
    # @param A, a list of integers
    # @param target, an integer to be inserted
    # @return integer
    def searchInsert(self, A, target):
        left = 0
        right = len(A) - 1
        while left <= right:
            mid = (left + right) // 2
            if target == A[mid]:
                return mid
            elif target < A[mid]:
                right = mid - 1
            else:
                left = mid + 1
        return left