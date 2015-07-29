/**
 * 寻找最长回文串（算法导论 15-2)，类似问题：LCS，即寻找两个字符串的最长子字符串
 * 属于最优解问题（题目已明确只有一个最优解），由于Brute Force复杂度为O(N^3),而N = 1000,容易导致TLE
 * 故使用动态规划（另也有对应的优化）
 * 题目地址：https://leetcode.com/problems/longest-palindromic-substring/
 * 类似问题：Shortest Palindrome
**/
public class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int start = 0, longest = 1;
        boolean[][] dp = new boolean[n][n];  // dp[i][j]为True表示子串substring(i,j+1)是一个回文串
        
        for(int i = 0; i < n; i++)
            dp[i][i] = true;   //dp的初始化，所有单个字符，为回文串
        for(int i = 0; i < n-1; i++) {
            if(s.charAt(i) == s.charAt(i+1)) {  //dp的初始化2
                dp[i][i+1] = true;
                start = i;
                longest = 2;
            }
        }
        
        for( int i = n-3; i >= 0; i--) {
            for( int j = i+1; j < n; j++) {
				// 最优子结构，从dp[i+1][j-1] 两边扩展得dp[i][j]
                if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1] ) {
                    dp[i][j] = true;
                    if( longest < j-i+1){  //更新记录当前最长回文串的起始处和长度
                        start = i;
                        longest = j-i+1;
                    }
                }
            }
        }
        return s.substring(start, start+longest);
    }
}