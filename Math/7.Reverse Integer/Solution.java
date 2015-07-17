/**
 * 逐位反转给定int型整数并返回
 * 需要注意的地方：1.若反转后溢出，则返回0
 * 2.1000反转后应是1而非0001（故不宜转换成String再反转）
 * 3.负数反转后已然返回负数
 * 题目地址：https://leetcode.com/problems/reverse-integer/
 * 类似题目：String to Integer (atoi)
**/
public class Solution {
    /**
     * 利用对10取余依次从个位取起，然后对x和result迭代
     * 注意判断溢出，int型的数值范围为-2147483648（-2^31) ~ 2147483647(2^31-1)
    **/
    public int reverse(int x) {
        int result = 0;
        while( x != 0 ) {
            //防止溢出，即若result的绝对值大于214748364时，乘10必定溢出
            if( Math.abs(result) > (Integer.MAX_VALUE / 10)) {  
                return 0;
            }
            result = result * 10 + x % 10;
            x = x / 10;
        }
        return result;
    }
}