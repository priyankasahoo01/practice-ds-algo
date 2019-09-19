package com.practice;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Candies135Leet {
	
	public static void main(String[] args) {
		int arr[] = {1,6,10,8,7,3,2};
		Candies135Leet sol = new Candies135Leet();
		int op = sol.candy(arr);
		System.out.println("op -> "+op);
	}
	
	class MyCandy{
        Integer index, val;
        
        MyCandy(int index, int val){
        	this.index = index;
        	this.val = val;
        }
        
    }
	
    public int candy(int[] rating) {
    	
    	int[] op = new int[rating.length];
    	PriorityQueue<MyCandy> pq = new PriorityQueue<Candies135Leet.MyCandy>(new Comparator<MyCandy>() {

			@Override
			public int compare(MyCandy o1, MyCandy o2) {
				// TODO Auto-generated method stub
//				return 0;
				if(o1 != o2) {
    				return o1.val.compareTo(o2.val);
    			}else return 0;
			}
		});
    	
    	
    	
        for(int i = 0 ; i < rating.length ; i++) {
        	pq.add(new MyCandy(i, rating[i]));
        }
        int sum = 0;
        for(int i = 0; i < op.length ; i++) {
        	MyCandy candy = pq.remove();
        	int index = candy.index;
        	int val = candy.val;
        	if(index > 0 && rating[index] > rating[index-1]) {
        		op[index] = op[index-1]+1;
        	}else if(index < rating.length-1 && rating[index] > rating[index+1]) {
        		op[index] = op[index+1]+1;
        	}else {
        		op[index] = 1;
        	}
        	sum = sum + op[index];
//        	op[index] = ((index > 0 && rating[index - 1] > rating[index] ) || (index < rating.length-1 && rating[index+1] > rating[index])) ?
        }
        System.out.println("op array");
        for( int i : op) {
        	System.out.print(i+"\t");
        }
        System.out.println();
        return sum;
    }

}
