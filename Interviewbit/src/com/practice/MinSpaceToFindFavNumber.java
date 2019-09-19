package com.practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinSpaceToFindFavNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> fav = new HashSet<>();
		fav.add("314");
		fav.add("15926535897");
		fav.add("9323");
		fav.add("8462643383279");
		
		int op = findMinSpaces("3141592653589793238462643383279", fav);
//		int op = findMinSpaces("3141", fav);
		System.out.println(op-1);
	}

	public static int findMinSpaces(String str, Set<String> fav) {
//		int minSpaces = Integer.MAX_VALUE;
//		for(int i = 0 ; i < str.length() ; i++) {
//			if(!isValid(str.substring(0, i), fav)) {
//				continue;
//			}
//			
//			int count = findMinSpaces(str, i, fav);
//			if(count != -1 && count < minSpaces) {
//				minSpaces = count;
//			}
//		}
//		return minSpaces;
		return findMinSpaces(str, 0, fav, new HashMap<Integer, Integer>());
	}
	
	private static boolean isValid(String str, Set<String> fav) {
		if(str.length() == 0) {
			return true;
		}
		return fav.contains(str);
	}
	
	
	private static int findMinSpaces(String str, int index, Set<String> fav, Map<Integer, Integer> map) {
		int minSpaces = Integer.MAX_VALUE;
		if(index >= str.length()) {
			return 0;
		}
		for(int i = index ; i < str.length() ; i++) {
			if(!isValid(str.substring(index, i+1), fav)) {
				continue;
			}
			Integer count = map.get(index);
			if(count != null) {
				return map.get(index);
			}
			
			count = findMinSpaces(str, i+1, fav, map);
			if(count != -1 && count < minSpaces) {
				minSpaces = 1+count;
			}
		}
		
		int op = minSpaces == Integer.MAX_VALUE ? -1 : minSpaces;
		map.put(index, op);
		return op;
		
	}
}
