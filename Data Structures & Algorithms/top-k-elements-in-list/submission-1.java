class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        int[] res = new int[k];

        HashMap<Integer,Integer> countMap = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            countMap.put(nums[i], countMap.getOrDefault(nums[i],0)+1);
        }

        PriorityQueue<Integer> pq = new 
            PriorityQueue<Integer>((n1,n2)->(countMap.get(n2)-countMap.get(n1)));

        for(int x: countMap.keySet()){
            pq.add(x);
        }

        int index = 0;
        while(k>0 && !pq.isEmpty()){
          res[index] = pq.remove();
          index++;
          k--;
        }

        return res;
    }
}
