class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        Arrays.sort(nums);

        List<List<Integer>>  result = new ArrayList<List<Integer>>();

        for(int i =0 ; i< nums.length; i++){

            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int l =i+1;
            int r = nums.length-1;
            
            while(l < r){
                
                int currSum = nums[i]+ nums[l]+nums[r];
                if(currSum == 0){
                    List<Integer> res = new ArrayList<>();
                    res.add(nums[i]);
                    res.add(nums[l]);
                    res.add(nums[r]);
                    result.add(res);
                    l++;
                    r--;

                    while(l<r && nums[l] == nums[l-1]){
                        l++;
                    }
                }else if( currSum <0){
                    l++;
                }else if(currSum > 0){
                    r--;
                }
            }

        }

        return result;
       

       



    }
}
