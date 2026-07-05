class Solution {
    public boolean hasDuplicate(int[] nums) {
        
    //   Set<Integer> s = new HashSet<Integer>(); 
    //   for(int i=0; i<nums.length; i++){
    //     if(!s.add(nums[i])){
    //         return true;
    //     }
    //   }
    //   return false;

    Arrays.sort(nums);

    for(int i=0; i<nums.length-1; i++){
        if(nums[i] == nums[i+1]){
            return true;
        }
    }

    return false;
        
    }
}