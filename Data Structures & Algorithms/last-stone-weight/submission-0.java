class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b)->(b-a) );
        for(int n : stones){
            pq.add(n);
        }
        while(pq.size()>2){
            int stone1 = pq.remove();
            int stone2 = pq.remove();
            if(stone1!=stone2){
                pq.add(Math.abs(stone1-stone2));
            }
        }
        if(pq.size()==2){
            return Math.abs(pq.remove()-pq.remove());
        }else if(pq.size()==1){
            return pq.remove();
        }
        return 0;
    }
}
