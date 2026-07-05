class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer,Integer> numsCount = new HashMap<>();
        for(int n: nums){
                numsCount.put(n, numsCount.getOrDefault(n,0)+1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) -> (numsCount.get(n2)- numsCount.get(n1)));
        for(int key: numsCount.keySet()){
            pq.add(key);
        }

        int indx = 0;
        int[] res = new int[k];
        while(k>0 && pq.size()>0){
            res[indx++] = pq.remove();
            k--;
        }
        return res;
    }
}
