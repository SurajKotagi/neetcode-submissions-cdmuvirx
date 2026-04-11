class Solution {
    public int maxProfit(int[] prices) {
        int minTillNow = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            int curProfit = prices[i] - minTillNow;
            if(curProfit > maxProfit) maxProfit = curProfit;
            if(prices[i] < minTillNow) minTillNow = prices[i];
        }
        return maxProfit;
    }
}
