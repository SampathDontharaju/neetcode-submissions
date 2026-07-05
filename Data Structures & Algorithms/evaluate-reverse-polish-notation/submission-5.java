class Solution {
    public int evalRPN(String[] tokens) {
        
        
        Stack<Integer> st = new Stack<Integer>();

        for(String token : tokens){
            
            if(token.equals("*") || token.equals("-") || token.equals("+") || token.equals("/")){
                Integer top1 = st.pop();
                Integer top2 = st.pop();
                if(token.equals("*")){
                    st.push(top1 * top2);
                }else if(token.equals("-")){
                    st.push(top2 - top1);
                }else if(token.equals("+")){
                    st.push(top1 + top2);
                }else if(token.equals("/")){
                    st.push(top2 / top1);
                }
            }else{
                st.push(Integer.parseInt(token));
            }
        }

        return st.peek();


    }
}
