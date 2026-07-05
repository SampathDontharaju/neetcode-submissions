class Solution {

    List<List<Integer>> result;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        result = new ArrayList<>();
        Arrays.sort(nums);
        backTrack(nums, 0, new ArrayList<>());
        return result;
    }

    private void backTrack(int[] nums, int indx, List<Integer> subset){

        if(indx == nums.length){
            result.add(new ArrayList<>(subset));
            return ;
        }
        subset.add(nums[indx]);
        backTrack(nums, indx+1, subset);
        subset.remove(subset.size()-1);
        while(indx+1 < nums.length && nums[indx]== nums[indx+1]){
            indx++;
        }
        backTrack(nums, indx+1, subset);
    }
}
