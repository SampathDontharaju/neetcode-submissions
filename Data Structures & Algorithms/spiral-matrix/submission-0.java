class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
    
        int rowStart = 0;
        int colStart = 0;
        int colEnd = matrix[0].length-1;
        int rowEnd = matrix.length-1;

        int maxSize = matrix.length * matrix[0].length;

        List<Integer> spiralDisplay = new ArrayList<>();

        while(spiralDisplay.size() < maxSize){
            for(int i=colStart;  i<=colEnd && spiralDisplay.size() < maxSize; i++){
                spiralDisplay.add(matrix[rowStart][i]);
            }
            rowStart++;

            for(int i=rowStart; i<=rowEnd && spiralDisplay.size() < maxSize; i++){
                spiralDisplay.add(matrix[i][colEnd]);
            }
            colEnd--;

            System.out.println("colEnd is "+colEnd);


            if(colStart < colEnd){
                for(int i=colEnd; i>=colStart && spiralDisplay.size() < maxSize; i--){
                    
                    spiralDisplay.add(matrix[rowEnd][i]);
                }
                rowEnd--;
            }
            if(rowStart<= rowEnd){
                for(int i=rowEnd; i>=rowStart && spiralDisplay.size() < maxSize; i--){
                    spiralDisplay.add(matrix[i][colStart]);
                }
                colStart++;
            }

        }

        return spiralDisplay;
    }
}