package com.practice;

import java.util.Comparator;
import java.util.PriorityQueue;

public class NDigitSum {
	public static void main(String[] args) {
		NDigitSum sol = new NDigitSum();
		int op = sol.solve(3, 4);
		System.out.println("op "+op);
	}
	public int solve(int N, int sum) {
        //n = 2, sum =3
		Comparator<Customer> com = new Comparator<Customer>() {

			@Override
			public int compare(Customer o1, Customer o2) {
				// TODO Auto-generated method stub
				return 0;
			}
		};
        PriorityQueue<Customer> q = new PriorityQueue<>(com);
//        q.add(e)
        int op = 0;
        for(int i = 1 ; i <= 9 ; i++){
            if(i <= sum ){
                op = op + solve1(N-1, sum -i);
            }
        }
        return op;
        
        
    }
    //1,2 //1,1 //1,0
    public int solve1(int N, int sum) {
        if(N*9 < sum){
            return 0;
        }
        if(N == 1){
            if(sum > 9 || sum < 0){
                return 0;
            }
            else return 1;
        }
        int op = 0;
        for(int i = 0 ; i <= 9 ; i++){
            
            if(i <= sum ){
                op = op + solve1(N-1, sum -i);
            }
            
        }
        return op;
    }
}
