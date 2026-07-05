class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();
    
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2; i++){
            if(i>0 && nums[i]== nums[i-1]){
                continue;
            }
            int j = i+1;
            int k = nums.length-1;
            while(j < k){
                //System.out.println(" j "+j +" k "+k);
                int threeSum = nums[i]+nums[j]+nums[k];
                if(threeSum == 0){
                    System.out.println(nums[i]+ " .."+ nums[j]+".."+nums[k]);
                   result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                   j++;
                   while(j>0 && j<=k && (nums[j] == nums[j-1])){
                        j++;
                    }
                    //j++;
                    k--;
                }else if(threeSum > 0){
                    k--;
                }else if(threeSum < 0){
                    j++;
                }
            }
        }

        return result;

    }
}
