class KthLargest {
    int size;
    PriorityQueue<Integer> minHeap;
    public KthLargest(int k, int[] nums) {
        this.size = k;
        minHeap = new PriorityQueue<Integer>((n1,n2)-> (n1- n2));
        for(int n: nums){
            minHeap.add(n);
            if(minHeap.size() > k){
                minHeap.remove();
            }
        }
    }
    
    public int add(int val) {
       minHeap.add(val);
       if(minHeap.size()> this.size){
        minHeap.remove();
       }
       return minHeap.peek();
        
    }
}
