class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length()!=t.length()){
                return false;
        }

        int[] store = new int[26];

        // char[] sArr = s.toCharArray();
        // Arrays.sort(sArr);
        // char[] tArr = t.toCharArray();
        // Arrays.sort(tArr);

        for(int i=0; i<s.length(); i++){
            store[s.charAt(i)-'a']++;
            store[t.charAt(i)-'a']--;
            // if(sArr[i]!= tArr[i]){
            //     return false;
            // }
        }

        for(int i=0; i<26; i++){
            if(store[i]!=0){
                return false;
            }
        }

        return true;
    }
}
