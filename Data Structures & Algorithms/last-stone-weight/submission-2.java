class Solution {
    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((n1, n2) -> (n2-n1));

        for(int stone : stones){
            maxHeap.offer(stone);
        }

        while(maxHeap.size()>1){
            int top1 = maxHeap.remove();
            int top2 = maxHeap.remove();
            
            maxHeap.offer(Math.abs(top1-top2));
            
        }

        return maxHeap.peek();
    }
}
