class Solution {
    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((n1,n2)->(n1-n2));
        

        for(int n : nums){
            pq.add(n);
            if(pq.size()>k){
                pq.remove();
            }
        }

        return pq.peek();


    }
}
