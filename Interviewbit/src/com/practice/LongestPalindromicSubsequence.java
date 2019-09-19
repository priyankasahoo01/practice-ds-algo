package com.practice;

public class LongestPalindromicSubsequence {
	public static void main(String[] args) {
		System.out.println(dp("bbbab"));
	}
	
	public static int dp(String s){
        int[][] dp = new int[s.length()][s.length()];
        int len = 1;
        int op = 0;
        while(len <= s.length()){
            // for( int j = 0 ; i < s.length() ; j++){
                for( int i = 0 ; i < s.length() && i+len-1 < s.length(); i++){
                    int j = i+len-1;
                    if( i == j){
                        dp[i][j] = 1;
                    }
                    else if(j-i == 1){
                        if(s.charAt(i) == s.charAt(j)){
                            dp[i][j] = 2;
                        }else{
                            dp[i][j] = 1;
                        }
                    }
                    else{
                        if(s.charAt(i) == s.charAt(j)){
                            
                            dp[i][j] = 2+ ((i+1 >= s.length() || j-1 < 0) ? 1 :dp[i+1][j-1]);
                        }else{
                            dp[i][j] = Math.max((i+1 >= s.length() ?dp[i+1][j]: 1), (j-1 >= 0 ? dp[i][j-1]:1));
                        }
                    }
                    op = Math.max(op, dp[i][j]);
                    
                }
            // }
            len++;
        }
        return op;
    }

}
