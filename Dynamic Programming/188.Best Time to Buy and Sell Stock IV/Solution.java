/**
 * 可以最多完成k次交易，求最大收益
 * 题目地址：https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
**/
public class Solution {
    /**
     * 动态规划
     * t[k][i]表示在前i个交易日完成了k次交易的最大收益
     * 递推公式：f[k, ii] = max(f[k, ii-1], prices[ii] - prices[jj] + f[k-1, jj]) { jj in range of [0, ii-1] }
     *                   = max(f[k, ii-1], prices[ii] + max(f[k-1, jj] - prices[jj]))
     * 初始化：f[0, ii] = 0; f[k, 0] = 0;
    **/
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if(prices == null || len < 2) return 0;
        if (k >= len / 2) return greedy(prices);  //注意，如果k很大，会产生OutOfMemoryError: Java heap space

        int[][] t = new int[k + 1][len];
        for (int i = 1; i <= k; i++) {
            int tmpMax =  -prices[0];
            for (int j = 1; j < len; j++) {
                t[i][j] = Math.max(t[i][j - 1], prices[j] + tmpMax);
                tmpMax =  Math.max(tmpMax, t[i - 1][j - 1] - prices[j]);
            }
        }
        return t[k][len - 1];
    }

    //此时k大，可以利用122题的贪心策略
    public int greedy(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) 
            profit += Math.max(0, prices[i] - prices[i - 1]);
        return profit;
    }
}