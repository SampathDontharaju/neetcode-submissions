class Solution {
    public int trap(int[] height) {
    
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];

        int lMax = height[0];
        for(int i=0; i<height.length; i++){
            lMax = Math.max(lMax, height[i]);
            leftMax[i] =lMax;
        }

        int rMax = height[height.length-1];
        for(int j=height.length-1; j>0; j--){
            rMax = Math.max(rMax, height[j]);
            rightMax[j] = rMax;
        }

        int trappedWater = 0;
        for(int i=1; i<height.length-1; i++){
            trappedWater +=  Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return trappedWater;
    }
}
