class Solution {

    List<List<Integer>> result;

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        result = new ArrayList<List<Integer>>();
        List<Integer> chosen = new ArrayList<>();
        combinationSumHelper(nums, target, 0, 0, chosen);
        return result;
    }

    private void combinationSumHelper(int[] nums, int target, int index, int sumSoFar, List<Integer> chosen){

        
        if(sumSoFar > target){
            return;
        }
        
        if(sumSoFar == target){
            result.add(new ArrayList(chosen));
            return;
        }

        for(int i=index; i<nums.length; i++){
            int choice = nums[i];
            sumSoFar += choice;
            chosen.add(choice);
            combinationSumHelper(nums, target, i, sumSoFar, chosen);
            sumSoFar -= choice; 
            chosen.remove(chosen.size()-1);    
        }
    
    }
}
