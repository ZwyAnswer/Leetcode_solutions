/**
 * 给定两个字符串，找到第二个字符串在第一个字符串中第一次出现的位置
 * 题目地址：https://leetcode.com/problems/implement-strstr/
**/
public class Solution {
	// brute force  复杂度O(mn)  以下写法不必为特殊case增加新的测试代码
    public int strStr(String haystack, String needle) {
        for( int i = 0; ; i++) {
            for( int j = 0; ; j++) {
                if( j == needle.length()) return i;  //匹配完成，返回index
                if( i+j == haystack.length()) return -1;  //无法匹配，返回-1
                if( needle.charAt(j) != haystack.charAt(i+j)) break;  //目前不匹配，跳出本次循环，从i+1开始
            }
        }
    }
}