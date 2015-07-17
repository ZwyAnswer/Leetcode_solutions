class Solution:
    # @param {string} s
    # @return {integer}
    def romanToInt(self, s):
        roman = { 'I':1, 'V':5, 'X':10, 'L':50, 'C':100, 'D':500, 'M':1000 }
        lstring = list(s)
        result = prev = 0
        for i in range(0, len(lstring)):
            curr = roman[lstring[i]]
            if curr > prev:
                result += curr - 2*prev
            else:
                result += curr
            prev = curr
        return result