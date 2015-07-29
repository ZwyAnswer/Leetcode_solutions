/**
 * 变换给定字符串为指定行数的zigzag链式格式，然后输出按行顺序遍历的字符串
 * 题目地址：https://leetcode.com/problems/zigzag-conversion/
**/
public class Solution {
    public String convert(String s, int numRows) {
        if(s == null) return null;
        if(s.length() <= 1 && numRows <=1) return s;
        int len = s.length();
        StringBuilder[] zigzag = new StringBuilder[numRows];  //zigzag转换后每行的结果
        for(int i = 0; i < numRows; i++) zigzag[i] = new StringBuilder(); //初始化
        
        int i = 0;
        while( i < len) {  //计算原字符属于的zigzag位置
            for(int row = 0; row < numRows && i < len; row++) 
                zigzag[row].append(s.charAt(i++));
            for(int col = numRows - 2; col >=1 && i < len; col--)
                zigzag[col].append(s.charAt(i++));
        }
        
        StringBuilder result = new StringBuilder();
        for(int j = 0; j < numRows; j++) {  //合并结果
            result.append(zigzag[j]);
        }
        return result.toString();
    }
}