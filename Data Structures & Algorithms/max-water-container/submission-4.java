class Solution {
    public int maxArea(int[] heights) {


        int l = 0;
        int r = heights.length-1;
        int maxArea = 0;

        while(l < r){
            int distance = r-l;
            //System.out.println("l height"+heights[l]+"right"+ heights[r]);
            int minHeight = Math.min(heights[l], heights[r]);
            maxArea = Math.max(distance*minHeight, maxArea);
            if(heights[l] < heights[r]){
                l++;
            }else{
                r--;
            }
        }
        return maxArea;
        
    }
}
