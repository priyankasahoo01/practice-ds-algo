package com.practice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PowerSet {
	public static void main(String[] args) {
		
		List<List<Integer>> result = powerset(3);
		for(List<Integer> l : result) {
			for(Integer n : l) {
				System.out.print(n+" ");
			}
			System.out.println();
		}
	}

	private static List<List<Integer>> powerset(int n) {
		List<List<Integer>> result = new ArrayList<>();
		result.add(new ArrayList<Integer>());
		
		for(int i = 1; i <= n ; i++) {
			powerset(i, result);
		}
		return result;
		
	}

	private static void powerset(int n, List<List<Integer>> result) {
		// TODO Auto-generated method stub
//		for (Iterator iterator = result.iterator(); iterator.hasNext();) {
//			List<Integer> list = (List<Integer>) iterator.next();
//			List<Integer> l = cloenAndappend(list, n);
//			
//			
//		}
		List<List<Integer>> temp = new ArrayList<>();
		for(List<Integer> li : result) {
			List<Integer> l = cloenAndappend(li, n);
			temp.add(l);
		}
		result.addAll(temp);
	}

	private static List<Integer> cloenAndappend(List<Integer> li, int n) {
		// TODO Auto-generated method stub
		List<Integer> l = new ArrayList<>();
		for(Integer i : li) {
			l.add(i);
		}
		l.add(n);
		return l;
	}

}
