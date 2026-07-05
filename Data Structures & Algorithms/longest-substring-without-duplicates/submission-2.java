class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        


        int i = 0;
        int j = 0;
        int maxLen = 0;
        HashSet<Character> set = new HashSet<Character>();

        while(i<=j && j<s.length()){
            if(set.contains(s.charAt(j))){
                set.remove(s.charAt(i));
                i++;
            }else{
                set.add(s.charAt(j));
                maxLen = Math.max(maxLen, j-i+1);
                j++;
            }
        }

        return maxLen;

    }
}
