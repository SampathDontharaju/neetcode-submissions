class Solution {
    public boolean exist(char[][] board, String word) {
        
        boolean result = false;

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j] == word.charAt(0)){
                    boolean[][] visited = new boolean[board.length][board[0].length];
                    result = result || explore(word, board, visited, 0, i, j);
                }
            }
        }

        return result;
    }

    private boolean explore(String word, char[][] board, boolean[][] visited, int index, int i, int j){

        if(i<0 || i>= board.length || j<0 || j>=board[0].length || visited[i][j]){
            return false;
        }

        if(word.charAt(index)!= board[i][j]){
            return false;
        }

        visited[i][j] = true;
        index++;

        if(index==word.length()){
            return true;
        }

        boolean l = explore(word, board, visited, index, i-1, j);
        boolean r = explore(word, board, visited, index, i+1, j);
        boolean t = explore(word, board, visited, index, i, j+1);
        boolean d = explore(word, board, visited, index, i, j-1);

        visited[i][j] = false;
        return l || r || t || d;
    }
}
