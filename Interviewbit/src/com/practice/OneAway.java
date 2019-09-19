package com.practice;

public class OneAway {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "pale";
		String s2 = "ple";
		//
		test(s1, s2);
		test("pales","pale");
		test("pale","bale");
		test("pale","bake");

	}

	private static void test(String s1, String s2) {
		boolean oneaway = isOneAway(s1, s2);
		System.out.println(s1+" "+s2+" -> "+oneaway);
	}

	private static boolean isOneAway(String s1, String s2) {
		// TODO Auto-generated method stub
		int diff = Math.abs(s1.length()-s2.length());
		if(diff > 1) {
			return false;
		}
		boolean replace = false, mod = false;
		if(diff == 0){
			replace = true;
		}else {
			mod = true;
		}
		if(replace) {
			int i = 0 , j = 0;
			int mismatch = 0;
			while(i < s1.length() && j < s2.length()) {
				if(mismatch > 1) {
					return false;
				}
				if(s1.charAt(i) != s2.charAt(j)) {
					mismatch++;
					
				}
				i++;j++;
			}
			
			return mismatch <= 1;
		}
		String large = (s1.length() > s2.length())?s1:s2;
		String small = (s1.length() < s2.length())?s1:s2;
		int i = 0 , j = 0;
		int mismatch = 0;
		while(i < large.length() && j < small.length()) {
			if(mismatch > 1) {
				return false;
			}
			if(large.charAt(i) != small.charAt(j)) {
				i++;mismatch++;
			}else {
				i++;j++;
			}
		}
		return mismatch <= 1;
	}

}
