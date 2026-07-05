class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int left = 1;

        int right = piles[0];

        for(int pile: piles){
            right = Math.max(right,pile);
        }

        System.out.println("right :"+right);

        int ans = right;

        while(left <= right){
            int mid = left + (right-left)/2;

            if(canEatBananas(mid, piles, h)){
                right = mid-1;
                ans = mid;
            }else{
                left = mid+1;
            }
        }

        return ans;
    }

    public boolean canEatBananas(int mid, int[] piles, int h){
        
        long totalHours = 0;
        for(int pile : piles){
            totalHours +=  Math.ceil((double) pile/mid);
        }
        return totalHours<=h? true: false;
    }
}
