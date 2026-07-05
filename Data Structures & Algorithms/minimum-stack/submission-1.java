class MinStack {
    
    Stack<Integer> st;
    public MinStack() {
        st = new Stack<Integer>();
    }
    
    public void push(int val) {
        
        if(st.isEmpty()){
            st.push(val);
            st.push(val);
        }else{
            int currMin = getMin();
            int min = currMin < val ? currMin: val;
            st.push(val);
            st.push(min);
        }
    }
    
    public void pop() {
        if(!st.isEmpty()){
            st.pop();
            st.pop();
        }
    }
    
    public int top() {
        int topMin = st.pop();
        int top = st.peek();
        st.push(topMin);
        return top;

    }
    
    public int getMin() {
        return st.peek();
    }
}
