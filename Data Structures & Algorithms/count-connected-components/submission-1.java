class Solution {
    public int countComponents(int n, int[][] edges) {
        
        
        HashMap<Integer,List<Integer>> graph = new HashMap<Integer,List<Integer>>();
        HashSet<Integer> seen = new HashSet<Integer>();
        
        for(int i=0 ; i<n ;i++){
            graph.put(i, new ArrayList<Integer>());
        }
        
        for(int[] edge: edges){
            
            List<Integer> nodes = graph.get(edge[0]);
            nodes.add(edge[1]);
            graph.put(edge[0], nodes);
            
            List<Integer> nodes1 = graph.get(edge[1]);
            nodes1.add(edge[0]);
            graph.put(edge[1], nodes1);
        }
        
        int count =0;
        for(int node: graph.keySet()){
            
            if(!seen.contains(node)){
                count++;
                Queue<Integer> q = new LinkedList<Integer>();
                q.add(node);
                seen.add(node);
                while(!q.isEmpty()){
                    List<Integer> neighbors = graph.get(q.remove());
                    
                    for(int i:  neighbors){
                        if(!seen.contains(i)){
                            q.add(i);
                            seen.add(i);
                        }
                    }
                }
            }

        }
        
        return count;
        
    }
}