/**
 * 判断给定字符串是否是有效数字，依然要考虑所有有效输入
 * 题目地址：https://leetcode.com/problems/valid-number/
 * 类似题目：String to Integer (atoi) 
**/
public class Solution {
    /**
     * 从头到尾遍历字符串，是有效数则继续遍历，看能否遍历到最后一个字符
     * 需要考虑的有效数：
     * 1.正负整数
     * 2.正负小数
     * 3.科学计数法表示的数
    **/
    public boolean isNumber(String s) {
        int i = 0, n = s.length();
        while(i < n && Character.isWhitespace(s.charAt(i))) i++;  //跳过开头的空白符
        if( i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) i++;  //处理正负号
        boolean isnumber = false;  //默认非数字
        while( i < n && Character.isDigit(s.charAt(i))) {  //处理最前面的有效数字
            i++;
            isnumber = true;
        }
        if( i < n && s.charAt(i) == '.') {  //处理小数
            i++;
            while( i < n && Character.isDigit(s.charAt(i))) {
                i++;
                isnumber = true;
            }
        }
        if( isnumber && i < n && s.charAt(i) == 'e') {  //处理科学计数法表示的数
            i++;
            isnumber = false;
            if( i < n && ( s.charAt(i) == '+' || s.charAt(i) == '-')) i++;
            while( i < n && Character.isDigit(s.charAt(i))) {
                i++;
                isnumber = true;
            }
        }
        while( i < n && Character.isWhitespace(s.charAt(i))) i++;  //跳过结尾空白符
        return isnumber && i == n ;  
    }
}