class Solution {
    public int maxProfit(int[] prices) {
        

        int[] minSoFar = new int[prices.length];
        int len = prices.length;
        int maxProfit = 0;

        minSoFar[0] = prices[0];

        for(int i=1; i<prices.length; i++){
            minSoFar[i] = Math.min(prices[i], minSoFar[i-1]);
        }
     
        for(int i=0; i<prices.length; i++){
            maxProfit = Math.max(maxProfit, (prices[i]-minSoFar[i]));
        }
        
        return maxProfit;
    }
}
