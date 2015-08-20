/**
 * 给定一字符串，按词反转。例如 "the sky is blue"-->"blue is sky the"
 * 题目地址：https://leetcode.com/problems/reverse-words-in-a-string/
 * 类似题目：Reverse Words in a String II
**/
public class Solution {
    //根据空白符分割单词，然后从后到前把单词插入新的字符串中（给定字符串首尾可以含有空白符）
    public String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
        int i = s.length();  //j和i分别为单词的首尾
        for( int j = s.length() - 1; j >= 0 ; j-- ) {
            if( s.charAt(j) == ' ') { //更新单词尾，实际上i为单词尾后的一个空格
                i = j;
            } else if ( j == 0 || s.charAt(j-1) == ' ') {
                if( result.length() != 0 ){  //单词之间加入空格
                    result.append(' ');
                }
                result.append(s.substring(j,i));
            }
        }
        return result.toString();
    }
}