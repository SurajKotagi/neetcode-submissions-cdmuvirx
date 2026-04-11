class Solution {
    public int maxProfit(int[] p) {
        int minBuy = p[0];
        int maxP = 0;
        
        for (int i = 1; i < p.length; i++) {
            maxP = Math.max(maxP, p[i] - minBuy);
            minBuy = Math.min(minBuy, p[i]);
        }
        return maxP;
    }
}
