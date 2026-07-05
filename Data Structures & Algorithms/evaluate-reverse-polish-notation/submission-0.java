class Solution {
    public int evalRPN(String[] tokens) {
        
        Stack<Integer> st = new Stack<>();

        for(String s : tokens){
            if(s.equals("+")){
                int sum = st.pop() + st.pop();
                st.push(sum);
            }else if(s.equals("-")){
                int x = st.pop();
                int y = st.pop();
                st.push(y-x);
            }else if(s.equals("*")){
                int mul = st.pop() * st.pop();
                st.push(mul);
            }else if (s.equals("/")){
                int top = st.pop();
                int secondTop = st.pop();
                st.push(secondTop/top);
            }else{
                st.push(Integer.parseInt(s));
                System.out.println(st.peek());
            }
            
        }
        return st.peek();
    }
}
