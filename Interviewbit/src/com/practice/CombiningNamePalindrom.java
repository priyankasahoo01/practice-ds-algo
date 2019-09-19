package com.practice;

import java.util.HashMap;
import java.util.Map;

public class CombiningNamePalindrom {

	public static void main(String[] args) {
		String fullName = "ava aavl";
//		System.out.println('y'+"abc"+'p');
		System.out.println(getCorrectName(fullName));
	}

	private static String getCorrectName(String fullName) {
		Map<Character, Integer> map = new HashMap<>();
		for(int i = 0 ; i < fullName.length(); i++) {
			char ch = fullName.charAt(i);
			if(ch != ' ') {
				if(map.get(ch) != null) {
					map.put(ch, map.get(ch)+1);
				}else {
					map.put(ch, 1);
				}
			}
		}
		
		char mid = ' ';
		String res = "";
		for(char ch : map.keySet()) {
			if(map.get(ch) != 1) {
				StringBuilder sb = new StringBuilder(ch);
				for(int k = 0 ; k < map.get(ch)/2; k++) {
					sb.append(ch);
				}
				res = sb.toString()+res+sb.toString();
			}else {
				mid = ch;
			}
			
		}
		int indexOfSpace = fullName.indexOf(" ");
		if(mid != ' ') {
			res = res.substring(0, res.length()/2)+mid+res.substring(res.length()/2);
		}
		
		return res.substring(0, indexOfSpace)+" "+res.substring(indexOfSpace);
	}
}
