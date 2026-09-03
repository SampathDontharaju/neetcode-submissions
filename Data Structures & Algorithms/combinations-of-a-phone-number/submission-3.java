class Solution {
    Map<Character,String> digitsMap;

    

    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<String>();
        if(digits == null || digits.length()==0 ){
            return result;
        }

        digitsMap = new HashMap<>();
        digitsMap.put('2', "abc");
        digitsMap.put('3', "def");
        digitsMap.put('4', "ghi");
        digitsMap.put('5', "jkl");
        digitsMap.put('6', "mno");
        digitsMap.put('7', "pqrs");
        digitsMap.put('8', "tuv");
        digitsMap.put('9', "wxyz");

        



        helper(digits, new StringBuilder(), 0, result);

        return result;
    }

    private void helper(String digits, StringBuilder chosen, int index, List<String> result){

        if(chosen.length() == digits.length()){
            result.add(chosen.toString());
            return;
        }

        char digit = digits.charAt(index);

        char[] choices = digitsMap.get(digit).toCharArray();

        for(int i=0; i<choices.length; i++){
            char choice = choices[i];
            chosen.append(choice);
            helper(digits, chosen, index+1, result);
            chosen.deleteCharAt(chosen.length()-1);
        }
    }
}
