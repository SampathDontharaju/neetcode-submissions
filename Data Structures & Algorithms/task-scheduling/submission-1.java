class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        HashMap<Character,Integer> taskFreq = new HashMap<>();
        for(char ch: tasks){
            taskFreq.put(ch, taskFreq.getOrDefault(ch,0)+1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> (b-a));

        for(Character ch : taskFreq.keySet()){
            pq.add(taskFreq.get(ch));
        }

        int totaltime  = 0;
        while(!pq.isEmpty()){

            List<Integer> tempStore = new ArrayList<>();
            for(int i=0; i<n+1; i++){
                if(!pq.isEmpty()){
                    tempStore.add(pq.poll());
                }
            }

            for(int t: tempStore){
                if(--t>0){
                    pq.add(t);
                }
            }
            totaltime += pq.isEmpty() ? tempStore.size(): n+1;
        }

        return totaltime;
    }
}
