/**
 * 现在可以完成不限次数的交易，但买股票之前，必须卖掉之前持有的股票。
 * 题目地址：https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
**/
public class Solution {
	//既然不限交易次数，则每次有差价的时候都进行买卖，贪心策略。
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) 
            profit += Math.max(0, prices[i] - prices[i - 1]);
        return profit;
    }
}