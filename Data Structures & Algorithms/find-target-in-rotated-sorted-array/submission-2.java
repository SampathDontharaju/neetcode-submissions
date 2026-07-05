class Solution {
    public int search(int[] nums, int target) {
        
        int minIndex = getMinIndex(nums);
        System.out.println("minIndex :"+minIndex);
        if(target == nums[minIndex]){
            return minIndex;
        }
        if(target >= nums[minIndex] && target <= nums[nums.length-1]){
            return search(nums, minIndex, nums.length-1, target);
        }else{
            return search(nums, 0, minIndex, target);
        }
    }


    public int search(int[] nums, int minIndex, int end, int target){
        int start = minIndex;
        
        while(start <= end){
            int mid = start+ (end-start)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]> target){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }

        return -1;
    }


    public int getMinIndex(int[] nums){

        int start =0;
        int end = nums.length-1;
        int n = nums.length;
        int res = -1;
        int minIndex = -1;
        while(start<=end){
            if(nums[start]<= nums[end]){
                return start;
            }

            int mid = start+(end-start)/2;

            if(nums[mid]<= nums[(mid+n-1)%n] && nums[mid]<= nums[(mid+1)%n]){
                res = nums[mid];
                minIndex = mid;
                break;
            }else if(nums[mid]<= nums[end]){
                end= mid-1;
            }else if(nums[start]<= nums[mid]){
                start = mid+1;
            }
    
        }
        return minIndex;
    }
}
