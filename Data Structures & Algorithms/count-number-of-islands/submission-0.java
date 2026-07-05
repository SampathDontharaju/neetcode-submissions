class Solution {
    public int numIslands(char[][] grid) {

        int count = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == '1'){
                    exploreIslands(grid, i, j, visited);
                    count++;
                }
            }
        }

        return count;
    }


    public void exploreIslands(char[][] grid, int row, int col, boolean[][] visited){


        if(row < 0 || col <0 || row >=grid.length || col >= grid[0].length || 
                visited[row][col] || grid[row][col]=='0'){
            return ;
        }

        visited[row][col] = true;

        if(grid[row][col]=='1'){
            grid[row][col] = '0';
        }
        exploreIslands(grid, row+1, col, visited);
        exploreIslands(grid, row-1, col, visited);
        exploreIslands(grid, row, col+1, visited);
        exploreIslands(grid, row, col-1, visited);

        visited[row][col] = false;
    }


    
}
