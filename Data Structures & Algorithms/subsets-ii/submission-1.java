class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        helper(nums, new ArrayList<>(), 0);
        return result;
        
    }

    private void helper(int[] nums, List<Integer> chosen, int index){

        result.add(new ArrayList(chosen));

        for(int i = index; i<nums.length; i++){

            if(i> index && nums[i]==nums[i-1])
                continue;
            
            chosen.add(nums[i]);
            helper(nums, chosen, i+1);
            chosen.remove(chosen.size()-1);

        }

    }
}
