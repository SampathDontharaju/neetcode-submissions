class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        Stack<int[]> st = new Stack<>();

        int[] res = new int[temperatures.length];

        for(int i=0; i<temperatures.length; i++){
            if(st.isEmpty()){
                st.push(new int[]{temperatures[i], i});
            }else {
                while(!st.isEmpty() && st.peek()[0]< temperatures[i]){
                    int[] topElement = st.pop();
                    int diff = i -topElement[1] ;
                    res[topElement[1]] = diff;
                }
                st.push(new int[]{temperatures[i], i});
            }
        }

        while(!st.isEmpty()){
            int[] topElement = st.pop();
            res[topElement[1]] = 0;
        }

        return res;
    }
}
