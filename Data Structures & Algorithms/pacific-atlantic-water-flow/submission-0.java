class Solution {
    private static final int[][] DIRECTIONS = new int[][] { {0,1}, {1,0}, {-1,0}, {0,-1}};
    private int numRows;
    private int numCols;

    private int[][] heights;


    List<List<Integer>> res;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        
        res = new ArrayList<List<Integer>>();

        this.heights = heights;
    
        if(heights == null || heights.length==0){
            return res;
        }

        numRows =heights.length;
        numCols = heights[0].length;

        Queue<int[]> pacificQueue = new LinkedList<>();
        Queue<int[]> atlanticQueue = new LinkedList<>();

        for(int i=0; i<numRows; i++){
            pacificQueue.add(new int[] {i,0});
            atlanticQueue.add(new int[] {i, numCols-1});
        }

        for(int i=0; i<numCols; i++){
            pacificQueue.add( new int[] {0, i});
            atlanticQueue.add( new int[]{numRows-1, i});
        }

        boolean[][] pacificReachable = bfsExplore(pacificQueue);
        boolean[][] atlanticReachable = bfsExplore(atlanticQueue);

        for(int i=0; i<pacificReachable.length; i++){
            for(int j=0; j<pacificReachable[0].length; j++){
                if(pacificReachable[i][j] &&  atlanticReachable[i][j]){
                    res.add(List.of(i,j));
                }
            }
        }

        return res;
        
    }

    private boolean[][] bfsExplore(Queue<int[]> q){


        boolean[][] reachable = new boolean[numRows][numCols];


        while(!q.isEmpty()){
            int[] node = q.poll();
            int row = node[0];
            int col = node[1];

            reachable[row][col] = true;


            for(int[] choice : DIRECTIONS){

                int newRow = row+ choice[0];
                int newCol = col + choice[1];

                if(newRow<0 || newRow>= numRows || newCol <0 || newCol >= numCols){
                    continue;
                }

                if(reachable[newRow][newCol]){
                    continue;
                }

                if(heights[row][col] <= heights[newRow][newCol]){
                    q.offer(new int[]{newRow, newCol});
                }
            }
        }
        return reachable;
    }
}