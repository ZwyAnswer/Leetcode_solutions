/**
 * 给定只含有'('和')'的字符串，找到字符串中最长的有效括号组合
 * 题目地址：https://leetcode.com/problems/longest-valid-parentheses/
**/
public class Solution {
    public int longestValidParentheses(String s) {
        int[] dp = new int[s.length()];  //dp[i]代表截止到i，最长有效括号长度
        Arrays.fill(dp, 0);
        int leftCount = 0, longest = 0;  //分别代表'('括号数，和最长结果
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') leftCount++;
            if(c == ')' && leftCount > 0) {
                dp[i] = dp[i-1] + 2;  //加上已匹配的一对()长度
                int prev = i - dp[i];  //去掉已匹配的(),之前还有有效括号
                if(prev > 0) dp[i] += dp[prev];
                leftCount--;
            }
            longest = Math.max(longest, dp[i]);
        }
        return longest;
    }
}