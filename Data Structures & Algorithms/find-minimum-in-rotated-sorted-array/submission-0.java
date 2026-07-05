class Solution {
    public int findMin(int[] nums) {
        
        int start =0;
        int end = nums.length-1;
        int n = nums.length;
        int res = -1;
        while(start<=end){
            if(nums[start]<= nums[end]){
                return nums[start];
            }

            int mid = start+(end-start)/2;

            if(nums[mid]<= nums[(mid+n-1)%n] && nums[mid]<= nums[(mid+1)%n]){
                res = nums[mid];
                break;
            }else if(nums[mid]<= nums[end]){
                end= mid-1;
            }else if(nums[start]<= nums[mid]){
                start = mid+1;
            }
    
        }
        return res;
    }
}
