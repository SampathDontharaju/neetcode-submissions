class Solution {
    public static List<List<Integer>> result;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        

        result = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        combinationHelper(candidates, 0, new ArrayList<Integer>(), 0, target);
        return result;
    }

        public static void combinationHelper(int[] candidates, int sumSoFar, List<Integer> temp,
                                             int index, int target){

        if(sumSoFar > target){
            return;
        }

        if(sumSoFar == target && !result.contains(temp)){
            result.add(new ArrayList(temp));
            return;
        }

        for(int i = index; i<candidates.length; i++){
            int choice = candidates[i];
            sumSoFar += choice;
            temp.add(choice);
            combinationHelper(candidates, sumSoFar, temp, i+1, target);
            int size = temp.size();
            temp.remove(size-1);
            sumSoFar -= choice;
        }
    }
}
