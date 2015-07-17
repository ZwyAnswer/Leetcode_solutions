class Solution:
    # @return a boolean
    def reverse(self, x):
        a = 0
        b = x if x >= 0 else -x
        while b:
            a = a * 10 + b % 10
            b = b / 10
        return a if x >= 0 else -a
        
    def isPalindrome(self, x):
        if x < 0: return False
        rx = self.reverse(x)
        return x == rx