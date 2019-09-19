package com.practice;

public class VersionComparator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] arr = "1.2.3".split("\\.");
		System.out.println(arr.length);

		VersionComparator sol = new VersionComparator();
		System.out.println(sol.compare("8.8.100.8", "8.8") == 1);
		System.out.println(sol.compare("8.8.0.8", "8.8") == 1);
		System.out.println(sol.compare("8.8.0.0", "8.8") == 0);
		System.out.println(sol.compare("8.9.0.8", "8.8") == 1);
		System.out.println(sol.compare("8.8", "8.8") == 0);
		System.out.println(sol.compare("9.0", "8.8") == 1);
		System.out.println(sol.compare("8.7.8", "8.8") == -1);
	}
	
	public int compare(String ver1, String ver2) {
		String[] arr1 = ver1.split("\\.");
		String[] arr2 = ver2.split("\\.");
		int i = 0;
		for( i = 0 ; i < Math.min(arr1.length, arr2.length) ; i++) {
			int comp = comp(arr1[i], arr2[i]);
			if(comp != 0) {
				return comp;
			}
		}
		if(allAreZero(((arr1.length < arr2.length)?arr2:arr1), i)) {
			return 0;
		}
		return (arr1.length>arr2.length)?1:0;
	}

	private boolean allAreZero(String[] arr, int index) {
		for( int i = index ; i < arr.length ; i++) {
			if(Integer.valueOf(arr[i]) != 0) {
				return false;
			}
		}
		return true;
	}

	private int comp(String s1, String s2) {
		for( int i = 0 ; i < Math.min(s1.length(), s2.length()) ; i++) {
			if(s1.charAt(i) > s2.charAt(i)) {
				return 1;
			}
			else if(s1.charAt(i) < s2.charAt(i)) {
				return -1;
			}
		}
		return 0;
	}

}
