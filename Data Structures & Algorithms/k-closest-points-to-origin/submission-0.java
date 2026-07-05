class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> ( (a[0]*a[0]+a[1]*a[1]) -(b[0]*b[0]+b[1]*b[1]) ));


        for(int[] point: points){
            pq.add(point);
        }

        int[][] closest = new int[k][2];
        int x = 0;
        while(x<k){
            closest[x] = pq.remove();
            x++;
        }

        return closest;
    }
}
