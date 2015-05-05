class Solution:
    # @param {integer[]} digits
    # @return {integer[]}
	# 由于Python列表可以插入和原处修改，故可以同Java的第二种解法
    def plusOne(self, digits):
		for i in range(len(digits)-1, -1, -1):
            if digits[i] < 9:
                digits[i] += 1
                return digits
            else:
                digits[i] = 0
        
        digits.append(0)
        digits[0] = 1
        return digits