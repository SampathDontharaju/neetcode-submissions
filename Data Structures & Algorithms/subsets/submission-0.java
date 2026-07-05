class Solution {

    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        backTrack(nums, 0, new ArrayList<>());
        return result;
    }

    private void backTrack(int[] nums, int i, List<Integer> sublist){
        if(i==nums.length){
            result.add(new ArrayList(sublist));
            return;
        }
        sublist.add(nums[i]);
        backTrack(nums, i+1, sublist);
        sublist.remove(sublist.size()-1);
        backTrack(nums, i+1, sublist);
    }
}
