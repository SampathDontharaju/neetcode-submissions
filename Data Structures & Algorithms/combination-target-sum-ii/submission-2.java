class Solution {

    List<List<Integer>> result;
    public List<List<Integer>> combinationSum2(int[] candidates, int target){
        
        result = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        helper(candidates, target, new ArrayList<>(), 0, 0);
        return result;
    }

    private void helper(int[] candidates, int target, List<Integer> chosen, int index, int sumSoFar){

        if(target == sumSoFar){
            //System.out.println("found sol");
            result.add(new ArrayList(chosen));
        }

        if(sumSoFar > target){
            return;
        }
        
        for(int i=index; i<candidates.length; i++){

             // Skip duplicate choices at this recursion level
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }

            int choice = candidates[i];
                //System.out.println("choice .. "+choice+" index"+index);
            chosen.add(choice);
            sumSoFar += choice;
            helper(candidates, target, chosen, i+1, sumSoFar);
            sumSoFar -= choice;
            chosen.remove(chosen.size()-1);
        }
    }
}
