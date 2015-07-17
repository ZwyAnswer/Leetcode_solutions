/**
 * 实现两个int整数的除法，不能使用*，/, %。若溢出返回MAX_VALUE
 * 题目地址：https://leetcode.com/problems/divide-two-integers/
**/
public class Solution {
    public int divide(int dividend, int divisor) {
        long result = divideLong(dividend, divisor);
        return result > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int)result;
    }

    /**
     * 转换为long来处理溢出
     * 使用减法来实现除法，dividend为除数，divisor为被除数。
     * 为了加快算法，给每次减去的被除数加倍(因不能使用*，故用左移)
    **/
    public long divideLong(long dividend, long divisor) {
        boolean negative = dividend < 0 != divisor < 0;  //判断正负 
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        long result = 0;
        
        while( dividend >= divisor) {  //每次从被除数的1倍开始减
            long temp = divisor, i = 1;
            while(dividend >= temp) {  //每次减去被除数的倍数
                dividend -= temp;
                result += i;
                temp <<= 1;  //利用左移，对被减数加倍
                i <<= 1;  
            }
        }
        return negative ? -(result) : result;
    }
}