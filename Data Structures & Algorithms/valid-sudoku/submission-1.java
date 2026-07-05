class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        Map<Integer,HashSet<Character>> rowMap = new HashMap<>();
        Map<Integer,HashSet<Character>> colMap = new HashMap<>();
        Map<Integer,HashSet<Character>> gridMap = new HashMap<>();

        for(int i=0; i<board.length; i++){
            rowMap.put(i, new HashSet<Character>());
            colMap.put(i, new HashSet<Character>());
            gridMap.put(i, new HashSet<Character>());
        }


        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j] != '.'){
                    
                    HashSet<Character> rowSet = rowMap.get(i);
                    if(rowSet.add(board[i][j]))
                    {
                        rowMap.put(i, rowSet);
                    }else{
                        return false;
                    }

                    HashSet<Character> colSet = colMap.get(j);

                    if(colSet.add(board[i][j])){
                        colMap.put(j, colSet);
                    }else{
                        //System.out.println("i :"+i+"j :"+j+"..."+board[i][j]);
                        return false;
                    }

                    int gridIndex = i/3*3 + j/3;
                    HashSet<Character> gridSet = gridMap.get(gridIndex);

                    if(gridSet.add(board[i][j])){
                        gridMap.put(gridIndex, gridSet);
                    }else{
                        return false;
                    }
                    //rowMap.put(i,  )
                }

            }
        }
        return true;
    }
}
