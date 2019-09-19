package com.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PartitionLabels sol = new PartitionLabels();
		List<Integer> op = sol.partitionLabels("ababcbacadefegdehijhklij");
		for(int n : op) {
			System.out.print(op+" ");
		}

	}
	
	public List<Integer> partitionLabels(String S) {
        Map<Character, Integer> map = new HashMap<>();
        
        for( int i = 0 ; i < S.length(); i++){
            char ch = S.charAt(i);
            map.put(ch, i);
        }
        
        int index = 0;
        List<Integer> op = new ArrayList<>();
        while(index < S.length()){
            index = makeString(S, map, index, op);
        }
        return op;
        
    }
    
    private int makeString(String str, Map<Character, Integer> map, int start, List<Integer> op){
        int end = map.get(str.charAt(start));
        for( int i = start ; i <= end ; i++){
            char ch = str.charAt(i);
            end = Math.max(end, map.get(ch));
        }
        op.add(end-start+1);
        return end+1;
    }

}
