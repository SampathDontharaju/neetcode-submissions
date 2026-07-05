class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        int n = nums.length;
        int[] output = new int[n - k + 1];
        Deque<Integer> q = new LinkedList<>();
        int l = 0, r = 0;

        while(r < n){
            System.out.println("index r :"+r);
            while(!q.isEmpty() && nums[q.getLast()] < nums[r] ){
                System.out.println("index q.getLast()"+q.getLast()
                +" value:"+nums[q.getLast()]);
                q.removeLast();
            }

            q.addLast(r);

            if (l > q.getFirst()) {
                System.out.println("getFirst() index"+q.getFirst());
                q.removeFirst();
            }

            if(r+1>=k){
                output[l]= nums[q.getFirst()];
                System.out.println("build o/p q.getFirst()"+q.getLast()+ ".."+nums[q.getLast()]);
                l++;
            }
            r++;
        }
        return output;
    }
}
