class Solution {
    public void rotate(int[][] matrix) {
        
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j< matrix[0].length; j++){
                if(i==j || j>i){
                    continue;
                }
                else{
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }


        int midLen = matrix[0].length/2;
        int lastColIndx = matrix[0].length-1;
        for(int row=0; row< matrix.length; row++){
            for(int col=0; col<midLen; col++){
                int temp = matrix[row][col];
                matrix[row][col]= matrix[row][lastColIndx-col];
                matrix[row][lastColIndx-col] = temp;
            }
        }




    }
}
