class MedianFinder {
    
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        maxHeap = new PriorityQueue<Integer>((a,b) -> (b-a));
        minHeap = new PriorityQueue<Integer>((a,b) -> (a-b));

    }
    
    public void addNum(int num) {

        if(maxHeap.size()==0 || maxHeap.peek()> num){
            maxHeap.add(num);
        }else{
            minHeap.add(num);
        }

        if(maxHeap.size()> minHeap.size()+1){
            minHeap.add(maxHeap.remove());
        }else if(minHeap.size() > maxHeap.size()+1 ){
            maxHeap.add(minHeap.remove());
        }
    }
    
    public double findMedian() {
        
        if(minHeap.size()== maxHeap.size()){
            return (double) (minHeap.peek()+maxHeap.peek())/2;
        }else if(minHeap.size()> maxHeap.size()){
            return minHeap.peek();
        }else{
            return maxHeap.peek();
        }


    }
}
