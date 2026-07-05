class Solution {
    public int numDecodings(String s) {
        Integer[] dp = new Integer[s.length()];
        return solve(0,s, dp);
    }

    private int solve(int i, String s, Integer[] dp){

        if(i==s.length()) return 1;

        if(s.charAt(i)=='0'){
            return 0;
        }

        if(dp[i]!=null){
            return dp[i];
        }

        int result = solve(i+1, s, dp);
        if(i+1<s.length()){
            if(s.charAt(i)=='1' ||  s.charAt(i) == '2' && s.charAt(i+1) <= '6')
            result += solve(i+2, s, dp);
        }

        dp[i] = result;
        return result;
    }
}
