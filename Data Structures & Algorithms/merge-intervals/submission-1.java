class Solution {
    public int[][] merge(int[][] intervals) {
        
        if (intervals == null || intervals.length == 0) {
            return new int[0][];
        }

        // The one required addition: Sort intervals by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();
        merged.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            
            int[] currInterval = merged.getLast(); // Java 21+
            int[] nextInterval = intervals[i];

            // overlap logic
            if (nextInterval[0] <= currInterval[1]) {
                currInterval[1] = Math.max(nextInterval[1], currInterval[1]);
            } else {
                merged.add(nextInterval);
            }
        }

        // Your exact array conversion
        int[][] res = new int[merged.size()][2];
        for (int i = 0; i < merged.size(); i++) {
            res[i] = merged.get(i);
        }

        return res;
    }

    
}
