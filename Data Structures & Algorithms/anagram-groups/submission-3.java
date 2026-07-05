class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> result = new ArrayList<List<String>>();
        Map<String, List<String>> anagramsMap = buildAnagramsMap(strs);
        for(String key: anagramsMap.keySet()){
            result.add(anagramsMap.get(key));
        }
        return result;
    }

    private Map<String, List<String>> buildAnagramsMap(String[] strs){

        Map<String, List<String>> anagramsMap = new HashMap<>();

        for(String str: strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedS = new String(chars);
            //sb.append(chars);
            if(anagramsMap.containsKey(sortedS)){
                List<String> anagrams = anagramsMap.get(sortedS);
                anagrams.add(str);
                anagramsMap.put(sortedS, anagrams);
            }else{
                List<String> anagrams = new ArrayList<String>();
                anagrams.add(str);
                anagramsMap.put(sortedS, anagrams);
            }
        }

        return anagramsMap;



    }
}
