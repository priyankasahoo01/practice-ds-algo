package com.practice;

public class LongesPalindSubstring {
	
	public String longestPalindrome(String s) {
		  
        String dp = dp(s);
        
		System.out.println(dp);
        
		return dp;
    }
	
	private String dp(String str){
        int n = str.length();
        boolean[][] dp = new boolean[str.length()][str.length()];
        int op = 1;
        int a=-1,b=-1;
        int k = 0;
//        int j 
        for( int len = 1 ; len <= str.length() ; len++) {
        	for(int i = 0 ; i < str.length() && i+len-1 < str.length(); i++) {
        		int j = i+len-1;
        		if( i == j){
                    dp[i][j] = true;
                }else if (j-i == 1){
                    dp[i][j] = (str.charAt(i) == str.charAt(j));
                }else{
                    if(str.charAt(i) == str.charAt(j)) {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
                if(dp[i][j]){
                    a = i; b = j;
                    // op = Math.max(op, j-1+1);
                    
                }
        	}
        }
//        for( int j = 0 ; j < n ; j++){
//        	for( int i = 0 ; i < n-j ; i++){
//        		if( i == j){
//                    dp[i][j] = true;
//                }else if (j-i == 1){
//                    dp[i][j] = (str.charAt(i) == str.charAt(j));
//                }else{
//                    if(str.charAt(i) == str.charAt(j)) {
//                        dp[i][j] = dp[i+1][j-1];
//                    }
//                }
//                if(dp[i][j]){
//                    a = i; b = j;
//                    // op = Math.max(op, j-1+1);
//                    
//                }
//        	}
//        }
//        for( int i = 0 ; i < n ; i++){
//            for(int j = i+k ; j < n ; j++){
//                if( i == j){
//                    dp[i][j] = true;
//                }else if (j-i == 1){
//                    dp[i][j] = (str.charAt(i) == str.charAt(j));
//                }else{
//                    if(str.charAt(i) == str.charAt(j)) {
//                        dp[i][j] = dp[i+1][j-1];
//                    }
//                }
//                if(dp[i][j]){
//                    a = i; b = j;
//                    // op = Math.max(op, j-1+1);
//                    
//                }
//            }
//        }
        return str.substring(a, b+1);
    }
    
    private String func(String s){
        if(s.length() <= 1){
            return s;
        }
        if(s.charAt(0) == s.charAt(s.length()-1)){
            return s.charAt(0)+func(s.substring(1,s.length()-1))+s.charAt(s.length()-1);
        }
        String s1 = func(s.substring(1));//abad -> bad , aba->
        String s2 = func(s.substring(0, s.length()-1));
        if( s1.length() > s2.length() ){
            return s1;
        }
        return s2;
            
        
    }
    public static void main(String[] args) {
    	
    	
    	
    	
		LongesPalindSubstring sol = new LongesPalindSubstring();
//		String op = sol.longestPalindrome("babad");
//		System.out.println(op);
//		 op = sol.longestPalindrome("abcda");
//		System.out.println(op);
		
		
		String op = sol.dp("babad");
		System.out.println(op);
		
	}

}
