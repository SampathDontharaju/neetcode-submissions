class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        

        List<List<String>> result = new ArrayList<List<String>>();
        Map<String, List<String>> ans = new HashMap<>();

        for(String s: strs){
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String key = Arrays.toString(ch);
            if(ans.containsKey(key)){
                List<String> res = ans.get(key);
                res.add(s);
                ans.put(key, res);
            }else{
                List<String> res = new ArrayList<>();
                res.add(s);
                ans.put(key, res);
            }
        }


        for(String k : ans.keySet()){
                result.add(ans.get(k));
        }

        return result;

    }
}
