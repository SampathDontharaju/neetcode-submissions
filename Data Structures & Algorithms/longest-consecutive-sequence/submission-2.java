class Solution {
    public int longestConsecutive(int[] nums) {
        

        Set<Integer> numSet = new HashSet<Integer>();

        for(int n: nums){
            numSet.add(n);
        }
       
        int longestStreak = 0;

        for(int i=0; i<nums.length; i++){

            //if(!numSet.contains(nums[i]-1)){

                int currNum = nums[i];
                int currStreak = 1;

                while(numSet.contains(currNum+1)){
                    currStreak++;
                    currNum++;
                }
                longestStreak = Math.max(currStreak, longestStreak);
            //}
        }
        return longestStreak;
    }
}
