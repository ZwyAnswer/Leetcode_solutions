/**
 * 168题的逆问题，把Excel表的字母列号转为数字列号
 * 题目地址：https://leetcode.com/problems/excel-sheet-column-number/
**/
public class Solution {
	//给定字符串从后向前计算
    public int titleToNumber(String s) {
        int result = 0, n = 0;
        for(int i = s.length()-1; i >= 0; i--) {
            int num = s.charAt(i) - 'A' + 1;  //当前字母对应数值
            result += Math.pow(26, n++) * num;
        }
        return result;
    }

    //给定字符串从前向后计算
    public int titleToNumber2(String s) {
        int result = 0;
        for(int i = 0; i < s.length(); i++) {
            result = result * 26 + (s.charAt(i) - 'A' + 1);
        }
        return result;
    }
}