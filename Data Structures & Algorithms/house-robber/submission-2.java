class Solution {
    public int rob(int[] nums) {
        

        if(nums.length== 0){
            return 0;
        }

        int[] maxProfit = new int[nums.length];

        maxProfit[0] = nums[0];
        
        if(nums.length>=2){
            maxProfit[1] = Math.max(nums[0], nums[1]);
        }
        

        for(int i=2; i<nums.length; i++){
            maxProfit[i] = Math.max(maxProfit[i-1], nums[i]+maxProfit[i-2]);
        }

        return maxProfit[nums.length-1];

    }
}
