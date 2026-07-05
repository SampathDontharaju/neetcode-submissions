class Solution {
    public int[][] merge(int[][] intervals) {
        
        Arrays.sort(intervals, (a,b)-> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();

        result.add(intervals[0]);

        for(int i=1; i< intervals.length;i++){
            int lastIndex = result.size()-1;

            int[] lastInterval = result.get(lastIndex);

            int[] currInterval = intervals[i];

            if(currInterval[0] > lastInterval[1]){
                result.add(currInterval);
            }else{
                int finalInterval = Math.max(lastInterval[1],currInterval[1]);
                int start = Math.min(lastInterval[0], currInterval[0]);
                int[] newInterval = {start, finalInterval};
                result.remove(lastIndex);
                result.add(newInterval);
            }
        }

        int[][] arr = new int[result.size()][2];
        arr = result.toArray(arr);

        return arr;
       



    }
}
