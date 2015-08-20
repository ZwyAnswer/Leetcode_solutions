class Solution:
    # @param prices, a list of integer
    # @return an integer
    def maxProfit(self, prices):
        if not prices: return 0
        cheapest = prices[0]
        mostprofit = 0
        for i in range(len(prices)):
            if prices[i] < cheapest:
                cheapest = prices[i]
            mostprofit = max(mostprofit,prices[i]-cheapest)
        return mostprofit