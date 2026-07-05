class Solution {
    public int orangesRotting(int[][] grid) {
        
        int rotten = 0;
        int fresh = 0;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]==2){
                    rotten++;
                    int[] point = {i , j};
                    q.add(point);
                }else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }

        int target = rotten + fresh;

        int minutes = 0;

        while(!q.isEmpty()){
            int size = q.size();

             if(rotten == target)
                return minutes;

            for(int i=0; i<size; i++){
                int[] rottenIndex = q.remove();
                int[][] neighbors = {{-1,0}, {1,0}, {0,1}, {0,-1}};

                for(int[] choice : neighbors){
                    int[] newPoint = { choice[0]+rottenIndex[0], choice[1]+ rottenIndex[1] };
                    if(newPoint[0]<0 || newPoint[0]>= grid.length || newPoint[1]<0 || newPoint[1]>=grid[0].length){
                        continue;
                    }
                    if(grid[newPoint[0]][newPoint[1]] == 1){
                        q.add(newPoint);
                        grid[newPoint[0]][newPoint[1]] = 2;
                        rotten++;
                        fresh--;
                    }
                }
            }
            minutes++;
        }

        return fresh > 0 ? -1: minutes;

        // if(fresh>0)
        //     return -1;
        // return minutes;
    }
}