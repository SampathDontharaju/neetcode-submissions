class Solution {
    public List<List<Integer>> result;
    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<List<Integer>>();
        List<Integer> choices = new ArrayList<Integer>();
        for(int n : nums){
            choices.add(n);
        }
        permuteHelper(choices, new ArrayList<Integer>(), result);
        return result;
    }


    private void permuteHelper(List<Integer> choices, List<Integer> chosen, List<List<Integer>> result ){

        if(choices.size()==0){
            result.add(new ArrayList(chosen));
        }
        for(int i=0; i<choices.size(); i++){  
            int choice = choices.get(i);
            chosen.add(choice);
            choices.remove(i);
            permuteHelper(choices, chosen, result);
            choices.add(i, choice);
            chosen.remove(chosen.size()-1);
        }
    }
}
