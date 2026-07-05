class Solution {
    public boolean checkValidString(String s) {
        
        int leftMin=0;
        int leftMax=0;

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='('){
                leftMin = leftMin+1;
                leftMax = leftMax+1;
            }else if(s.charAt(i)==')'){
                leftMin = Math.max(0, leftMin-1);
                leftMax = leftMax -1;
                if(leftMax<0){
                    return false;
                }
            }else{
                leftMax = leftMax+1;
                leftMin = Math.max(0, leftMin-1);
            }
        }

        return leftMin==0;
    }
}
