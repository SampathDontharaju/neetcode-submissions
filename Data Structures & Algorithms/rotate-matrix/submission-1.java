class Solution {
    public void rotate(int[][] matrix) {

        int r = matrix.length;
        int c = matrix[0].length;

        //transpose 
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(i!=j && i<j){
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }

        for(int i=0; i<r; i++){
            for(int j=0; j<c/2; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][c-j-1];
                matrix[i][c-j-1] = temp;
            }
        }

    }
}
