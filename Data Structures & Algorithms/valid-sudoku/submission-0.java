class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        Map<Integer,Set<Integer>> rows = new HashMap<>();
        Map<Integer,Set<Integer>> cols = new HashMap<>();
        Map<Integer,Set<Integer>> boxes = new HashMap<>();

         for(int row = 0; row< board.length; row++){
            for(int col = 0; col< board[0].length; col++){
                char currval = board[row][col];
                if(currval != '.'){

                    int val = currval - '0';

                    int boardIndx = row/3 * 3 + col/3;

                    if(rows.containsKey(row) && rows.get(row).contains(val)){
                        return false;
                    }else if(rows.containsKey(row) && !rows.get(row).contains(val)){
                        Set<Integer> st = rows.get(row);
                        st.add(val);
                        rows.put(row, st);
                    }else{
                        Set<Integer> st = new HashSet<Integer>();
                        st.add(val);
                        rows.put(row, st);
                    }

                    if(cols.containsKey(col) && cols.get(col).contains(val)){
                        return false;
                    }else if(cols.containsKey(col) && !cols.get(col).contains(val)){
                        Set<Integer> st = cols.get(col);
                        st.add(val);
                        cols.put(col, st);
                    }else{
                        Set<Integer> st = new HashSet<Integer>();
                        st.add(val);
                        cols.put(col, st);
                    }

                    if(boxes.containsKey(boardIndx) && boxes.get(boardIndx).contains(val)){
                        return false;
                    }else if(boxes.containsKey(boardIndx) && !boxes.get(boardIndx).contains(val)){
                        Set<Integer> st = boxes.get(boardIndx);
                        st.add(val);
                        boxes.put(boardIndx, st);
                    }else{
                        Set<Integer> st = new HashSet<Integer>();
                        st.add(val);
                        boxes.put(boardIndx, st);
                    }


                }



            }
         }

         return true;

    }
}