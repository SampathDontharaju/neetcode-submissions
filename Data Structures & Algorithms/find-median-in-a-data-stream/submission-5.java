class MedianFinder {

    List<Double> nums;
    PriorityQueue<Double> minHeap;
    PriorityQueue<Double> maxHeap;
    public MedianFinder() {
       minHeap = new PriorityQueue<Double>();
       maxHeap = new PriorityQueue<Double>((n1,n2) -> Double.compare(n2, n1));
    }
    
    public void addNum(int num) {
        if(maxHeap.isEmpty() || num < maxHeap.peek()){
            maxHeap.add(Double.valueOf(num));
        }else{
            minHeap.add(Double.valueOf(num));
        }
       

       // reorder
        System.out.println("maxHeap "+maxHeap.size()+"minHeap"+minHeap.size());
        if(maxHeap.size() - minHeap.size() > 1) {
            double val = maxHeap.remove();
            System.out.println("re balancing ..." +val);
            minHeap.offer(val);
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
