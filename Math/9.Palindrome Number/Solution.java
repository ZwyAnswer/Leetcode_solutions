/**
 * 判断给定整数是否是回文数，不能使用额外的空间
 * 几个问题： 1.负数是否是回文数？-不是
 * 2. 不能使用额外空间，故不能转化为String来处理
 * 3. 可以将int值反转，注意溢出。
 * 4.
 * 题目地址：https://leetcode.com/problems/palindrome-number/
 * 类似题目：Reverse Integer
**/
public class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        return x == reverseInt(x);
    }
    
    public int reverseInt(int x) {
        int result = 0;
        while( x != 0) {
            if(Math.abs(result) > (Integer.MAX_VALUE / 10)) return 0;
            result = result * 10 + x % 10;
            x /= 10;
        }
        return result;
    }
}