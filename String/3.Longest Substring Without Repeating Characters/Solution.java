/**
 * 给定字符串，找出其中最长的不带重复字符的子串长度
 * 题目地址：https://leetcode.com/problems/longest-palindromic-substring/
 * 类似题目：Longest Substring with At Most Two Distinct Characters
**/
public class Solution {
    /**
     * 检查重复，使用HashTable---这里使用布尔数组
     * 使用两个指针遍历，末尾指针到字符串尾时结束遍历，遍历中保持更新长度变量。
    **/
    public int lengthOfLongestSubstring(String s) {
        boolean[] exist = new boolean[256];  //假设s中全是ascii码，故用256大小的布尔数组来当做检查重复的HashTable
        int i = 0, longest = 0;  //i,j分别为子串的首尾位置
        for( int j = 0; j < s.length(); j++ ) {
            while(exist[s.charAt(j)]) {  //发生重复，则更新子串初始位置
                exist[s.charAt(i)] = false;
                i++;
            }
            exist[s.charAt(j)] = true;  //跟新子串末尾
            longest = Math.max( j - i + 1, longest);  //每次遍历更新最大长度变量
        }
        return longest;
    }
}