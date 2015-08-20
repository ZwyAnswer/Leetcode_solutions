/**
 * 最多可完成2次交易，求最大收益（可扩展至k次）
 * 题目地址：https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
**/
public class Solution {
    //动态规划，参考188题 k = 2的情况
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(prices == null || n < 2) return 0;
        int[][] dp = new int[3][n];
        for(int i = 0; i <= 2; i++) dp[i][0] = 0;
        for(int j = 0; j < n; j++) dp[0][j] = 0;
        for(int t = 1; t <= 2; t++) {
            int tmpMax = dp[t][0] - prices[0];
            for(int i = 1; i < n; i++) {
                dp[t][i] = Math.max(dp[t][i-1], tmpMax + prices[i]);
                tmpMax = Math.max(tmpMax, dp[t-1][i] - prices[i]);
            }
        }
        return dp[2][n-1];
    }
}