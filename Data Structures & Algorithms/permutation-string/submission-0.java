class Solution {
   public boolean checkInclusion(String s1, String s2) {

        Map<Character,Integer> s1Map = new HashMap<Character,Integer>();

        for(char ch: s1.toCharArray()){
            s1Map.put(ch, s1Map.getOrDefault(ch,0)+1);
        }

        int l = 0;
        int r = 0;
        int maxLen = 0;

        while(r <= s2.length()-1){
            if((s1Map.containsKey(s2.charAt(r))) ){
                Map<Character,Integer> s2Map = new HashMap<Character,Integer>();
                while(r<=s2.length()-1 && s1Map.containsKey(s2.charAt(r))){
                    char ch = s2.charAt(r);
                    s2Map.put(ch, s2Map.getOrDefault(ch,0)+1);
                    if(r-l+1 == s1.length()){
                        if(compareMaps(s1Map, s2Map)){
                            return true;
                        }else{
                            if(s2Map.get(s2.charAt(l))==1){
                                s2Map.remove(s2.charAt(l));
                            }else{
                                s2Map.put(s2.charAt(l), s2Map.get(s2.charAt(l))-1);
                            }
                            l++;
                            r++;
                        }
                    }else{
                        r++;
                    }
                }
                l=r;
            }else{
                l++;
                r++;
            }
        }
        return false;

    }


    private boolean compareMaps(Map<Character,Integer> s1Map,
                                Map<Character,Integer> s2Map){
        if(s1Map.size()!= s2Map.size()){
            return false;
        }    

        for(char ch: s1Map.keySet()){
            if(!s2Map.containsKey(ch) || s2Map.get(ch)!= s1Map.get(ch)){
                return false;
            }
        }   
        return true;                    
    }
}
