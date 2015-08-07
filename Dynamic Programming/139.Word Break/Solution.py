class Solution:
    # @param s, a string
    # @param dict, a set of string
    # @return a boolean
    def wordBreak(self, s, dict):
        n = len(s)
        i = n-1
        A = [ False for i in range(n) ]
        while i >= 0:
            if s[i:n] in dict:
                A[i] = True
            else:
                for j in xrange(i+1, n):
                    if s[i:j] in dict and A[j]:
                        A[i] = True
                        break
            i -= 1
        return A[0]