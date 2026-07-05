class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        


        int diff =0;
        int startIndx = 0;
        int res = 0;

        for(int i=0; i<gas.length; i++){
            diff += gas[i] - cost[i];
            res += gas[i] - cost[i];
            if(res < 0){
                startIndx = i+1;
                res = 0;
            }
        }

        if(diff<0 || startIndx >=gas.length) return -1;

        return startIndx;
    }
}
