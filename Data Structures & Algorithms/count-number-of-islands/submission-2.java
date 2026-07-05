class Solution {
    public int numIslands(char[][] grid) {
        
        int islands = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]=='1'){
                    dfsHelper(grid, i, j);
                    islands++;
                }

            }
        }
        return islands;
        
    }

    private void dfsHelper(char[][] grid, int i, int j){

        if(i<0 || j<0 || i>= grid.length || j>= grid[0].length){
            return ; 
        }

        if(grid[i][j]=='0'){
            return;
        }


        if(grid[i][j]=='1'){
            grid[i][j] = '0';
        }

         dfsHelper(grid, i+1,j); 
          dfsHelper(grid, i-1,j);
         dfsHelper(grid, i, j-1);
         dfsHelper(grid, i, j+1);
        
    }
}
