class Solution {
    public int trap(int[] height) {


        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        int totalWaterTrapped = 0;

        int len = height.length;
        leftMax[0] = height[0];
        rightMax[len-1] = height[len-1];

        for(int i=1; i<height.length; i++){
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }

        for(int i=len-2; i>=0; i--){
            rightMax[i] = Math.max(rightMax[i+1], height[i]);
        }

        for(int i=0; i<len; i++){
            int minHeight = Math.min(leftMax[i],rightMax[i]);
            if(minHeight > height[i]){
                totalWaterTrapped += minHeight - height[i];
            }
        }

        return totalWaterTrapped;

        
    }
}
