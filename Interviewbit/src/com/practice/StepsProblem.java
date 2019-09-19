package com.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class StepsProblem {

	public static void main(String[] args) {
		System.out.println("count -> "+count(3));
		
		
		List<List<Integer>> op = new ArrayList<>();;
		getSteps(3, new ArrayList<Integer>(), op );
		for( List<Integer> l : op) {
			for(Integer i : l) {
				System.out.print(i+" , ");
			}
			System.out.println();
		}
	}
	
	public static int count(int n) {
		if(n == 0) {
			return 1;
		}
		if( n < 0 ) {
			return 0;
		}
		return count(n-1)+count(n-2);
	}
	
	public static void getSteps(int n, List<Integer> curr, List<List<Integer>> op){
		if( n == 0 ) {
			op.add(curr);
		}
		if( n < 0 ) {
			return;
		}
		List<Integer> li1 = clone(curr);
		li1.add(1);
		getSteps(n-1, li1, op);
		List<Integer> li2 = clone(curr);
		li2.add(2);
		getSteps(n-2, li2, op);
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		pq.
		
		
	}

	private static List<Integer> clone(List<Integer> curr) {
		List<Integer> li = new ArrayList<>();
		for( Integer n : curr) {
			li .add(n);
		}
		return li;
	}

}
