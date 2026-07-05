class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    q.add(new int[] { i, j , 0});
                }
            }
        }

        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        int rowLen = grid.length;
        int colLen = grid[0].length;


        while(q.size()>0){

            int[] node = q.remove();

            //System.out.println("node value :"+node[0]+"..."+node[1]);

            for(int[] dir : dirs){

                int r = node[0] + dir[0];
                int c = node[1] + dir[1];

                if(r >= rowLen || c >= colLen || r < 0 || c < 0){
                    continue;
                }

                if(grid[r][c] == 2147483647){
                    //System.out.println("hello.."+r+".."+c);
                    grid[r][c] = node[2] + 1;

                    //System.out.println(grid[r][c]);
                    q.add(new int[]{ r, c, grid[r][c]});
                }
            }

        }
        
    }
}
