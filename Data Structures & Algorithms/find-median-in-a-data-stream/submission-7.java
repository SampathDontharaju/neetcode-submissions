class MedianFinder {

    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    public MedianFinder() {
       minHeap = new PriorityQueue<Integer>();
       maxHeap = new PriorityQueue<Integer>((n1,n2) ->(n2-n1));
    }
    
    public void addNum(int num) {
        if(maxHeap.isEmpty() || num < maxHeap.peek()){
            maxHeap.add(num);
        }else{
            minHeap.add(num);
        }
       // reorder
        System.out.println("maxHeap "+maxHeap.size()+"minHeap"+minHeap.size());
        if(maxHeap.size() - minHeap.size() > 1) {
            minHeap.offer(maxHeap.remove());
        }
        if(minHeap.size() > maxHeap.size()){
            maxHeap.offer(minHeap.remove());
        }
    }
    
    public double findMedian() {
         if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else {
            return maxHeap.peek();
        }

    }
}
