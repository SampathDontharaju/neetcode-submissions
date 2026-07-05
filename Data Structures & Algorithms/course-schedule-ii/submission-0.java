class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
             

      int[] indegree = new int[numCourses];
      int count = 0;
      Queue<Integer> queue = new LinkedList<Integer>();
      int[] result = new int[numCourses];
      int index = 0;

      Map<Integer, List<Integer>> adjMap = getAdjacencyList(numCourses, prerequisites, indegree);
      for(int i=0; i<indegree.length; i++){
        if(indegree[i] == 0){
          queue.add(i);
          result[index] = i;
          index++;
          count++;
        }
      }

      while(queue.size()>0){
        int course = queue.remove();
        for(int v : adjMap.get(course)){
          indegree[v]--;
          if(indegree[v]==0){
            queue.add(v);
            result[index] = v;
            index++;
            count++;
          }
        }
      }
       
     return count == numCourses ?  result :  new int[0];

    }


    private  Map<Integer, List<Integer>> getAdjacencyList(int numCourses, int[][] prerequisites, int[] indegree){

      Map<Integer, List<Integer>> adjMap = new HashMap<Integer, List<Integer>>();

      for(int i = 0; i < numCourses; i++){
        adjMap.putIfAbsent(i, new ArrayList<Integer>());
      }

      for(int[] prerequisite : prerequisites){
        int required = prerequisite[1];
        int nextCourse = prerequisite[0];
        List<Integer> courses = null ;
          // pre[1] -> pre[0]
        indegree[prerequisite[0]]++;

        courses = adjMap.get(required);
        courses.add(nextCourse);
        adjMap.put(required, courses);
        
      }
      return adjMap;
    } 



}
