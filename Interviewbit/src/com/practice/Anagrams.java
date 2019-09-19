package com.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagrams {

	public int[][] anagrams(final String[] A) {
        Map<String, List<Integer>> map = new HashMap<>();
        for( int i = 0 ; i < A.length ; i++ ){
            String str = sort(A[i]);
            List<Integer> li = map.get(str);
            if( li == null){
                li = new ArrayList<>();
            }
            li.add(i);
            map.put(str, li);
        }
        
        int[][] op = new int[map.size()][];
        int k = 0;
        for(String str : map.keySet()){
            List<Integer> li = map.get(str);
            op[k] = new int[li.size()];
            int j = 0;
            for(int n : li){
                op[k][j++] = n+1;
            }
            k++;
        }
        return op;
    }
    
    private String sort(String str) {
        char arr[] = str.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Anagrams sol = new Anagrams();
		String[] arr = new String[] { "abbbaabbbabbbbabababbbbbbbaabaaabbaaababbabbabbaababbbaaabbabaabbaabbabbbbbababbbababbbbaabababba", "abaaabbbabaaabbbbabaabbabaaaababbbbabbbaaaabaababbbbaaaabbbaaaabaabbaaabbaabaaabbabbaaaababbabbaa", "babbabbaaabbbbabaaaabaabaabbbabaabaaabbbbbbabbabababbbabaabaabbaabaabaabbaabbbabaabbbabaaaabbbbab", "bbbabaaabaaaaabaabaaaaaaabbabaaaabbababbabbabbaabbabaaabaabbbabbaabaabaabaaaabbabbabaaababbaababb", "abbbbbbbbbbbbabaabbbbabababaabaabbbababbabbabaaaabaabbabbaaabbaaaabbaabbbbbaaaabaaaaababababaabab", "aabbbbaaabbaabbbbabbbbbaabbababbbbababbbabaabbbbbbababaaaabbbabaabbbbabbbababbbaaabbabaaaabaaaaba", "abbaaababbbabbbbabababbbababbbaaaaabbbbbbaaaabbaaabbbbbbabbabbabbaabbbbaabaabbababbbaabbbaababbaa", "aabaaabaaaaaabbbbaabbabaaaabbaababaaabbabbaaaaababaaabaabbbabbababaabababbaabaababbaabbabbbaaabbb"};

		int[][] op = sol.anagrams(arr);
		for(int i = 0 ; i < op.length ; i++) {
			for(int j = 0 ; j < op[i].length ; j++) {
				System.out.print(op[i][j]+" , ");
			}
			System.out.println();
		}

	}

}
