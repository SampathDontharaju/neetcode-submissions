class Solution {
    public boolean isPalindrome(String s) {
        
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<s.length(); i++){
            if(Character.isDigit(s.charAt(i)) || Character.isLetter(s.charAt(i))){
                sb.append(s.charAt(i));
            }
        }

        int i = 0;
        int j = sb.length()-1;

        while(i<j){
            if(Character.toLowerCase(sb.charAt(i++)) != Character.toLowerCase(sb.charAt(j--))){
                return false;
            }

        }
        return true;

        
    }
}
