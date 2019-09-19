package com.practice;

public class KmpAlgo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int op = kmp("ABABABCABABABCABABABC", "ABABAC");
		System.out.println(op);
		
		
		System.out.println(kmp("AAAAAAAAAAAAAAAAAB","AAAAB"));
		System.out.println(kmp("AAAAAAAAAAAAAAAAAB","AAAA"));
		System.out.println(kmp("AAAAB","AAAA"));
	}
	
	public static int kmp(String str, String prefix) {
		String temp = prefix+"$"+str;
		char []arr = temp.toCharArray();
		int l = 0, r = 1;
		int[] op = new int[temp.length()];
		while( r < temp.length()) {
			if( arr[l] == arr[r] ) {
				op[r] = l+1;
				if(op[r] == prefix.length()) {
					return r-prefix.length()+1-(1+prefix.length());
				}
				l++;
				r++;
			}else if( l == 0 ) {
				op[r] = 0;
				r++;
			}else {
					while( arr[r] != arr[l] && l > 0) {
						l = op[l-1];
					}
			}
			
		}
		return -1;
	}
}
