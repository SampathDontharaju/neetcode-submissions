class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

       int[] res = new int[temperatures.length];
       Stack<Integer> st = new Stack<Integer>();

       for(int i=0; i<temperatures.length; i++){
        if(st.isEmpty()){
            st.push(i);
            continue;
        }

        if(!st.isEmpty() && (temperatures[i] < temperatures[st.peek()])){
            st.push(i);
        }

        while(!st.isEmpty() && (temperatures[i] > temperatures[st.peek()])){
            int indx = st.pop();
            res[indx] = i-indx;
        }
        st.push(i);
       }
        return res;
        
    }
}
