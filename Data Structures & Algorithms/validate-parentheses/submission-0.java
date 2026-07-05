class Solution {
    public boolean isValid(String s) {
        

        Map<Character, Character> bracketLookup = new HashMap<>(3);

        bracketLookup.put(')', '(');
        bracketLookup.put('}', '{');
        bracketLookup.put(']', '[');

        Stack<Character> st = new Stack<>();


        for(int i=0; i<s.length(); i++){

            char ch = s.charAt(i);

            if(bracketLookup.containsKey(ch) ){
                if(!st.isEmpty() && st.peek()==bracketLookup.get(ch)){
                    st.pop();
                }else{
                    return false;
                }
            }else{
                st.push(ch);
            }
        }

        return st.isEmpty();

        




    }
}
