class Solution {
    public int longestConsecutive(int[] nums) {
    
        Set<Integer> set = new HashSet<Integer>();
        for(int n: nums){
            set.add(n);
        }
        int maxSequenceCount = 0;

        for(int i=0; i<nums.length; i++){
            if(!set.contains(nums[i]-1))
            {
                // found the starting of sequence
                int sequenceVal = nums[i];
                int count = 0;
                while(set.contains(sequenceVal)){
                    sequenceVal++;
                    count++;
                }
                maxSequenceCount = Math.max(maxSequenceCount, count);
            }
        }

        return maxSequenceCount;
    }
}
