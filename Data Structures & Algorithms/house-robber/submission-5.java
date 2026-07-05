class Solution {
    public int rob(int[] nums) {

        
        if(nums.length==1){
            return nums[0];
        }

        int[] maxProfit = new int[nums.length];
        maxProfit[0] = nums[0];
        maxProfit[1] = Math.max(nums[1], nums[0]);
        for(int i=2; i<nums.length; i++){
            maxProfit[i] = Math.max(maxProfit[i-1], maxProfit[i-2]+nums[i]);
        }
        return maxProfit[nums.length-1];
    }
}
