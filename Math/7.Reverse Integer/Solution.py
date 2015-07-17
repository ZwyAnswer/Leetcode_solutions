class Solution:
    # @return an integer
    def reverse(self, x):
        a = 0
        b = x if x >= 0 else -x
        while b:
            a = a * 10 + b % 10
            b = b / 10
        return a if x >= 0 else -a

    # 利用字符列表反转
    def reverse2(self, x):
        if x > 0 :
            symbol = 1
        else:
            symbol = -1
        s = str(abs(x))
        rx = int(s[::-1])
        return symbol * rx