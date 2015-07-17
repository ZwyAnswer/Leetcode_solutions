/**
 * 给定两个代表数的字符串，返回其字符串形式的乘积结果(可以是很大的数，给定数为非负数)
 * 题目地址：https://leetcode.com/problems/multiply-strings/
 * 类似题目：Add Binary
**/
public class Solution {
    /**
     * 模仿乘法的实现，相乘后叠加结果，处理进位
     * 注意两个数相乘后，结果数的长度不超过两个数长度之和，例如99*99 = 9801
    **/
    public String multiply(String num1, String num2) {
        int len1 = num1.length(), len2 = num2.length();
        int[] result = new int[len1+len2];
        for(int i = len1 - 1; i >= 0; i--) {   //从乘数的个位开始处理
            for(int j = len2 - 1; j >= 0; j--) {
                int x1 = num1.charAt(i) - '0';
                int x2 = num2.charAt(j) - '0';
                result[i+j+1] += x1 * x2;  //同一位的结果叠加
            }
        }
        
        int carry = 0;
        for(int i = len1 + len2 - 1; i >= 0; i--) {  //处理进位叠加
            int sum = result[i] + carry;
            carry = sum / 10;
            result[i] = sum % 10;
        }
        
        StringBuilder s = new StringBuilder();
        for(int i : result) s.append(i);
        while(s.length() != 0 && s.charAt(0) == '0') s.deleteCharAt(0);  //删除结果数组中无效的0
        return s.length() != 0 ? s.toString() : "0";
    }
}