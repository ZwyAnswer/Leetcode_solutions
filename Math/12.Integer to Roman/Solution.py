class Solution:
    # @return a string
    def intToRoman(self, num):
        value = [ 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1]
        roman = [ "M", "CM", "D","CD", "C","XC","L","XL","X","IX","V","IV","I" ]
        result = ""
        for i in range(0, len(value)):
            while num >= value[i]:
                num -= value[i]
                result += roman[i]
        return result 