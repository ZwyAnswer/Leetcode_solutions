/**
 * 给定一个数组，prices[i]代表第i天的股票价格。
 * 现在总共只能完成一次交易买卖，求最大收益
 * 题目地址：https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * 类似题目：Best Time to Buy and Sell Stock II、III、IV
**/
public class Solution {
    //只能完成一次交易，则需要用最高价减去最低价，迭代更新最低股票价格即可
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1) return 0;
        int min = prices[0];
        int profit=0;
        for(int i = 1; i < prices.length; i++){
            min = Math.min(min,prices[i]);
            profit = Math.max(profit, prices[i]-min);
        }
        return profit;
    }
}