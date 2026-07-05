class Solution {
    public int orangesRotting(int[][] grid) {
        

        int fresh = 0;
        int rotten = 0;
        Queue<int[]> q = new LinkedList<int[]>();
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]==1){
                    fresh++;
                }else if(grid[i][j]==2){
                    rotten++;
                    q.add(new int[]{i,j});
                }
            }
        }
        int expectedRotten = rotten+fresh;

        int[][] dirs = {{0,1}, {1,0}, {-1,0}, {0,-1}};
        int minutes = 0;
        while(!q.isEmpty() && fresh > 0){
            int size = q.size();
            for(int i=0 ; i<size; i++){
                int[] cell = q.remove();
                for(int[] dir : dirs){
                    int nr = dir[0]+cell[0];
                    int nc = dir[1]+cell[1];

                    if(nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] == 1){
                        grid[nr][nc] = 2;
                        rotten++;
                        fresh--;
                        q.add(new int[]{nr,nc});
                    }
                }
            }
            minutes++;
        }
        
        return fresh == 0 ? minutes : -1;
    }
}
