class Solution {
    public int findMin(int[] nums) {
    
        int l = 0;
        int r = nums.length-1;
        int n = nums.length;

        while(l<r){
            int mid = l + (r-l)/2;
            if(nums[mid] > nums[r]){
                System.out.println("mid : "+ mid);
                l = mid + 1;
            }else {
                r = mid;
            }
        }

        return nums[l];

    }
}
