/**
 * 把String转换为对应的int，需要考虑许多特殊的输入情形
 * 题目地址：https://leetcode.com/problems/string-to-integer-atoi/
 * 类似题目：Reverse Integer，Valid Number
**/
public class Solution {

    private static final int maxdiv10 = Integer.MAX_VALUE / 10;  //214748364
    
    /**
     * 需要考虑如下输入情形：
     * 1.字符串中的前后空白符需舍弃
     * 2.保留正负号
     * 3.只取是数字的字符进行转换，未转换则返回0
     * 4.处理溢出
    **/
    public int atoi(String str) {
        int i = 0;
        int n = str.length();
        while( i < n && Character.isWhitespace(str.charAt(i))) i++;  //跳过开头的空白符
        
        int sign = 1;
        if( i < n && str.charAt(i) == '+' ) {   //处理正负号
            i++;
        } else if( i < n && str.charAt(i) == '-' ) {
            sign = -1;
            i++;
        }
        
        int num = 0;
        while ( i < n && Character.isDigit(str.charAt(i))) {  //是有效数字字符，则进行转换
            int digit = Character.getNumericValue(str.charAt(i));   //字符转数值
            if ( num > maxdiv10 || ( num == maxdiv10 && digit >= 8)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;  //处理溢出
            }
            num = num * 10 + digit;
            i++;
        }
        return sign * num;  //保留正负号返回
    }
}