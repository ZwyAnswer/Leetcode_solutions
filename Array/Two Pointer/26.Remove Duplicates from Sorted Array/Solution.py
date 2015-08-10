class Solution:
    # @param a list of integers
    # @return an integer
    def removeDuplicates(self, A):
        if len(A) < 2:
            return len(A)
        slow = 0
        for fast in range(1, len(A)):
            if A[fast] != A[slow]:
                A[fast], A[slow+1] = A[slow+1], A[fast]
                slow += 1
        return slow + 1