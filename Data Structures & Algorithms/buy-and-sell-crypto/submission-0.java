class Solution {
    public int maxProfit(int[] prices) {

        
        if(prices==null){
            return 0;
        }
        int maxProfit = 0;

        int currMin = prices[0];

        for(int i=1; i<prices.length; i++){
            
            
            maxProfit = Math.max(maxProfit, prices[i]- currMin);
            currMin = Math.min(prices[i], currMin);
            

        }

        return maxProfit;


    }
}
