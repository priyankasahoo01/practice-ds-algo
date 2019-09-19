package com.practice;

public class MinCut {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinCut sol = new MinCut();
//		int op = sol.minCut("aba");
//		System.out.println("op -> "+op);
		String ip = "abab";
		test(sol, ip);
		test(sol, "ababb");
	}

	private static void test(MinCut sol, String ip) {
		int op = sol.minCut(ip);
		System.out.println("op -> "+op);
	}
	
	public int minCut(String A) {
        return find(A);
    }
    
    private int find(String str){//ababb
        if(str.length() == 1){
            return 1-1;
        }
        if(isPalindrome(str, str.length()-1)) {
        	return 0;
        }
        int i = 0;
        int min = Integer.MAX_VALUE;
        for (  i = 0 ; i < str.length() ; i++ ){
            if(isPalindrome(str, i)) {
                if(i == str.length()-1){
                    return 1-1;
                }
                
                int val = 1 + find(str.substring(i+1));
                min = Math.min(val, min);
//				return val;
            }
        }
        return Math.min(min, str.length()-1);
    }
    
    private boolean isPalindrome(String str, int end) {
        int i = 0 , j = end;
        while ( i <= j){
            if( str.charAt(i) != str.charAt(j)){
                return false;
            }
            i++;j--;
        }
        return true;
    }

}
