class Solution {
    public int maxProfit(int[] prices) {
        
        int maxProfit = 0;

        int currMin = prices[0];

        for(int i=1; i<prices.length; i++){ 
            currMin = Math.min(prices[i], currMin); 
            if(prices[i]>= currMin){
                maxProfit= Math.max(maxProfit, prices[i]-currMin);
            }
        }
        return maxProfit;
    }
}
