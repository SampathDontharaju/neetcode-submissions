/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
    
        Collections.sort(intervals, Comparator.comparingInt(i -> i.start));
        PriorityQueue<Interval> pq = new PriorityQueue<Interval>((a,b) -> (a.end-b.end));

        if(intervals.size()==0){
            return 0;
        }

        pq.add(intervals.get(0));

        for(int i=1; i<intervals.size(); i++){

            Interval curr = intervals.get(i);
            Interval peek = pq.peek();

            if(curr.start >= peek.end){
                int newstart = Math.min(curr.start, peek.start);
                int newend = Math.max(curr.end, peek.end);
                Interval mergedInterval = new Interval(newstart, newend);
                pq.remove();
                pq.add(mergedInterval);

            }else{
                pq.add(curr);
            }
        }

        return pq.size();
    }
}
