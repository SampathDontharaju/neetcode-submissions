class Solution {

    List<List<Integer>> result;
    public List<List<Integer>> permute(int[] nums) {
        
        result = new ArrayList<List<Integer>>();
        List<Integer> choices = new ArrayList<>();
        for(int n: nums){
            choices.add(n);
        }
        helper(choices, result, new ArrayList<>());   
        return result;
    }

    private void helper(List<Integer> choices, List<List<Integer>> result, List<Integer> chosen){
        if(choices.size()== 0){
            result.add(new ArrayList(chosen));
        }else{
            for(int i=0; i<choices.size(); i++){
                int choice = choices.get(i);
                choices.remove(i);
                chosen.add(choice);
                helper(choices, result, chosen);
                chosen.remove(chosen.size()-1);
                choices.add(i, choice);
            }
        }


    }
}
