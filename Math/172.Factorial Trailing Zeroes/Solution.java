/**
 * 给定整数n，找出n!中尾部所含0的个数
 * 题目地址：https://leetcode.com/problems/factorial-trailing-zeroes/
 * 类似题目：Number of Digit One
**/
public class Solution {
	/**
	 * 从1~n中，计算5的幂的个数。例如126，
	 * 首先，5,10,15,20...即除5的余数乘以2或者本身都构成了1个0
	 * 其次，5的幂，如25,125...除去之前在5,25中计算的一个0，还会多一个0.
	 * 递增5的幂指数，直至n除以其的商为0。
	**/ 
    public int trailingZeroes(int n) {
        int result = 0, exp = 1;
        while(n / Math.pow(5, exp)> 0) {
            result += n / Math.pow(5, exp);
            exp++;
        }
        return result;
    }
}