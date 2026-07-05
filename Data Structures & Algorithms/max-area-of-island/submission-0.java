class Solution {
        public int maxAreaOfIsland(int[][] grid) {
        int maxCount = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        System.out.println("helloworld --");
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]==1){
                    //System.out.println("helloworld");
                    int count = exploreGrid(grid, visited, i, j);
                    maxCount = Math.max(count ,maxCount);
                }
            }
        }
        return maxCount;
    }

        private int exploreGrid(int[][] grid, boolean[][] visited, int i, int j){

        //System.out.println("exploring: i: "+i +"j :"+j);
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || visited[i][j] || (grid[i][j]==0)){
            return 0;
        }

        // if(grid[i][j]==1){
        //     count++;
        // }

        visited[i][j] = true;

        //System.out.println("hello world");

        int val =  1 + exploreGrid(grid, visited, i+1, j) + 
        exploreGrid(grid, visited, i-1, j) + 
        exploreGrid(grid, visited, i, j+1) +
        exploreGrid(grid, visited, i, j-1);

        //visited[i][j] = false;
        return val;
    }


}
