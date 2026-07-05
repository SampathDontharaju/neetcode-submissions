class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> result = new ArrayList<List<String>>();

        Map<String, List<String>> anagramsMap = new HashMap<>();

        for(String str: strs){
            char[] chars = str.toCharArray();

            Arrays.sort(chars);

            StringBuilder sb = new StringBuilder();
            sb.append(chars);

            if(anagramsMap.containsKey(sb.toString())){

                List<String> anagrams = anagramsMap.get(sb.toString());
                anagrams.add(str);
                anagramsMap.put(sb.toString(), anagrams);
            }else{
                List<String> anagrams = new ArrayList<String>();
                anagrams.add(str);
                anagramsMap.put(sb.toString(), anagrams);
            }
        }

        for(String key: anagramsMap.keySet()){
            result.add(anagramsMap.get(key));
        }

        return result;
    }
}
