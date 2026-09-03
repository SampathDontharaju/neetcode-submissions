class Solution {
    public boolean exist(char[][] board, String word) {

        for(int i=0; i< board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j] == word.charAt(0)){
                    if(explore(board, i, j, word, 0)){
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean explore(char[][] board, int i, int j, String word, int index) {

        //System.out.println("i .. "+i+ "...j.."+j+"... index "+index);


        // if(sb.length() > word.length() || index == word.length()){
        //     return false;
        // }

        if(i<0 || i >= board.length || j < 0 || j >= board[0].length){
            return false;
        }

        //System.out.println("char exploring .. "+ board[i][j]);
        
        if(board[i][j] != word.charAt(index)){
            //System.out.println("returing false "+ board[i][j]);
            return false;
        }
           

        //sb.append(board[i][j]);

        if(index == word.length()-1){
            return true;
        }

        char temp = board[i][j];
        board[i][j] = '#';
        boolean found = explore(board, i+1, j+0, word, index+1) ||  explore(board, i-1, j+0, word, index+1) || explore(board, i+0, j+1, word, index+1) ||  explore(board, i+0, j-1, word, index+1);

        board[i][j] = temp;

        return found;
    }
}
