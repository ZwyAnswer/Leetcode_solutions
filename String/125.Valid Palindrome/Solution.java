/**
 * 判断一个字符串是否是回文字符串，忽略非字母数字，忽略大小写
 * 题目地址：https://leetcode.com/problems/valid-palindrome/
 * 相似题目：Palindrome Linked List
**/
public class Solution {
    /**
     * 字符串可以按地址访问字符，故用下标遍历判断即可，不需要使用额外空间。
     * 利用Java String API跳过所有非字母数字，去掉大写字符。
     * 分别从第一个字符向前和最后一个字符向后开始遍历
    **/
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while(i < j) {
            while( i < j && !Character.isLetterOrDigit(s.charAt(i))) i++;  //跳过所有非字母数字
            while( i < j && !Character.isLetterOrDigit(s.charAt(j))) j--;
            if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j)))  //去大写
                return false;
            i++; j--;  //更新索引
        }
        return true;
    }
}