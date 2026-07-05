class Solution {

    Map<Character,String> digitsMap;

    List<String> allCombinations;

    public List<String> letterCombinations(String digits) {

        digitsMap = new HashMap<>();
        digitsMap.put('2', "abc");
        digitsMap.put('3', "def");
        digitsMap.put('4', "ghi");
        digitsMap.put('5', "jkl");
        digitsMap.put('6', "mno");
        digitsMap.put('7', "pqrs");
        digitsMap.put('8', "tuv");
        digitsMap.put('9', "wxyz");

        allCombinations = new ArrayList<String>();

        if(digits.length()==0)
            return allCombinations;

        helper(digits, 0, new StringBuilder(), allCombinations );
        return allCombinations;
    }



    private void helper(String digits, int index, StringBuilder chosen, List<String> allCombinations){
        
   

        if(chosen.length()== digits.length()){
            allCombinations.add(chosen.toString());
            return;
        }
        char[] digitsArray = digits.toCharArray();
        Character digitChoice = digitsArray[index];
        String choices = digitsMap.get(digitChoice);

        System.out.println("choices :"+choices);

        for(int i=0; i<choices.length(); i++){
            char charChosen = choices.charAt(i);
            chosen.append(charChosen);
            helper(digits, index+1, chosen, allCombinations);
            chosen.deleteCharAt(chosen.length()-1);
        }
    }
}
