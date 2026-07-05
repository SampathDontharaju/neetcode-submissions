class Solution {
    public boolean isValid(String s) {
        
        HashMap<Character,Character> charMap = new HashMap<Character, Character>();


        charMap.put(']','[');
        charMap.put('}','{');
        charMap.put(')','(');

        Stack<Character> st = new Stack<Character>();

        for(char c: s.toCharArray()){

            if(charMap.containsKey(c)){
                if(!st.isEmpty() && st.peek()==charMap.get(c)){
                    st.pop();
                }else{
                    return false;
                }
            }else{
                st.push(c);
            }
        }

        return st.isEmpty();
    }




}
