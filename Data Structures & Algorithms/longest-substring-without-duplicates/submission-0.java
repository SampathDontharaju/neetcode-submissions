class Solution {
    public int lengthOfLongestSubstring(String s) {

        Map<Character,Integer> charMap = new HashMap<>();

        int l = 0;
        int r = 0;
        int maxLen = 0;

        while(r < s.length()){
            char currchar = s.charAt(r);
            if(charMap.containsKey(currchar)){
                // remove from left 
                charMap.put(currchar, charMap.getOrDefault(currchar,0)+1);
                while(charMap.get(currchar)>1){
                    char leftChar = s.charAt(l);
                    int leftcount = charMap.get(leftChar);
                    if(leftcount == 1){
                        charMap.remove(leftChar);
                    }else{
                        charMap.put(leftChar, leftcount-1);
                    } 
                    l++;
                }
                //charMap.put(currchar, 1);
                maxLen = Math.max(maxLen, r-l+1);
                r++;
            }else if(!charMap.containsKey(currchar)){
                charMap.put(currchar, 1);
                maxLen = Math.max(maxLen, r-l+1);
                r++;
            }
            
        }

        return maxLen;  
    }
}
