class Solution {
    public int rob(int[] nums) {

        if(nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }

        int first = getMaxProfit(nums, 0, nums.length-2);
        int second = getMaxProfit(nums, 1, nums.length-1);

        return Math.max(first,second);
    }


    public int getMaxProfit(int[] nums, int left, int right){

       int[] dp = new int[nums.length-1];

        int indx=0;
        for(int i=left; i<=right; i++){
            if(i==left){
                dp[indx++] = nums[left];
            }else if(i==left+1){
                dp[indx++] = Math.max(nums[i-1], nums[i]);
            }else{
                dp[indx] = Math.max(nums[i]+dp[indx-2], dp[indx-1]);
                indx++;
            }
            
        }

        return dp[dp.length-1];
       
    }
}
