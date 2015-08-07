/**
 * 相比Palindrome Partitioning题，找出满足所有子串都是回文的最小切割
 * 题目地址：https://leetcode.com/problems/palindrome-partitioning-ii/
**/
public class Solution {
    //动态规划求解
    public int minCut(String s) {
        int len = s.length();
        int[] dp = new int[len];  //dp[i]代表s.substring(i)的最小分割
        boolean[][] p = new boolean[len][len];  //备忘录，代表s.substring(i,j+1)为回文串
        //自底向上迭代求解，即从字符串尾向字符串头进行切割
        for (int i = len-1; i >= 0; i--) {
            dp[i] = len-1-i;
            for (int j = i; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j-i < 2 || p[i+1][j-1]) { //s.substring(i, j+1)为回文串
                        p[i][j] = true;
                        if(j == len-1) dp[i] = 0;  //代表s.substring(i)为回文串，i为当前最小分割
                        else dp[i] = Math.min(dp[i], dp[j+1]+1);  //递归关系
                    }
                }
            }
        }
        return dp[0];
    }
}