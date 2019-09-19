package com.practice;

import java.util.ArrayList;
import java.util.List;

public class ShortestCommonSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ShortestCommonSubstring sol = new ShortestCommonSubstring();
		int op = sol.solve(new String[] {"qfgxmuvgfaj", "lfvenhyuhuor", "osamibdnj", "beyhkbso"});
		System.out.println(op);
	}

	public int solve(String[] A) {
        String op = solve1(A);
        if( op == null){
            return 0;
        }
        return op.length();
    }
    
    public String solve1(String[] A) {
        if(A == null){
            return null;
        }
        if(A.length == 1){
            return A[0];
        }
        
        String op = A[0];//abc
        List<String> li = new ArrayList<>();
        for(int i = 1 ; i < A.length ; i++){
            String s = A[i];
            li.add(s);
        }
        
        while(li.size() > 0){
            int minsize = Integer.MAX_VALUE;
            int in = -1;
            String tempop= "";
            for(int i = 0 ; i < li.size() ; i++){
                String str = li.get(i);
                String res = solve(op, str);
                if(res.length() < minsize){
                    minsize = Math.min(minsize, res.length());
                    in = i;
                    tempop = res;
                }
            }
            li.remove(in);
            op = tempop;
        }
        return op;
    }
    public String solve(String str1, String str2) {
        String large = null, small = null;
        if(str1.length() >= str2.length()){
            large = str1;
            small = str2;
        }else{
            large = str2;
            small = str1;
        }
        
        if(large.contains(small)){
            return large;
        }
        //find index of substr;
        int index = findindex(large, small);
        if(index == -1){
            if(large.charAt(0) == small.charAt(small.length()-1)){
                return small.substring(0, small.length()-1) + large;
            }else if(small.charAt(0) == large.charAt(large.length()-1)){
                return large.substring(0, large.length()-1) + small;
            }else{
                return large+small;
            }
        }
        //end of finding index
        else{
            return large.substring(0,index)+small;
        }

    }
    
    private int findindex(String large, String small){
        int j = 0;
        int index = -1;
        for( int i = 0 ; i < large.length() ; i++){
            if(large.charAt(i) == small.charAt(j)){
                if(j == small.length()-1){
                    return index;
                }
                
                if( j == 0){
                    index = i;
                }
                j++;
                
            }else{
                index = -1;
                j = 0;
            }
        }
        return index;
    }
}
