class Solution {
    public boolean canJump(int[] nums) {
        
        int maxReachablePos = 0;
        for(int i=0; i<nums.length; i++){
            if(i > maxReachablePos){
                return false;
            }
            maxReachablePos = Math.max(maxReachablePos, i+nums[i]);

            if(maxReachablePos >= nums.length-1){
                return true;
            }
        }

        return false;


    }
}
