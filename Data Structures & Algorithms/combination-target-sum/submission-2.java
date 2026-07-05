class Solution {
    public static List<List<Integer>> result;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        result = new ArrayList<List<Integer>>();
        combinationHelper(candidates, 0, new ArrayList<Integer>(), 0, target);
        return result;
    }

    public static void combinationHelper(int[] candidates, int sumSoFar, List<Integer> temp,
                                             int index, int target){

        if(sumSoFar > target){
            return;
        }

        if(sumSoFar == target){
            result.add(new ArrayList(temp));
            return;
        }

        for(int i = index; i<candidates.length; i++){
            int choice = candidates[i];
            sumSoFar += choice;
            temp.add(choice);
            combinationHelper(candidates, sumSoFar, temp, i, target);
            temp.remove(temp.size()-1);
            sumSoFar -= choice;
        }
    }
}