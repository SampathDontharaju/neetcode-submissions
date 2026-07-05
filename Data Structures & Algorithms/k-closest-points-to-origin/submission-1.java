class Solution {
    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>((int[] n1, int[] n2) ->
         ( (n1[0]*n1[0] + n1[1]*n1[1]) - (n2[0]* n2[0] + n2[1]*n2[1]) ));

        for(int[] point: points){
            minHeap.offer(point);
        }
        
        int[][] result = new int[k][2];
        int index = 0;

        while(index < k){
            result[index++] = minHeap.remove();
        }

        return result;

    }
}
