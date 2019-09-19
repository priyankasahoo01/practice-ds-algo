package com.practice;

import java.util.HashMap;
import java.util.Map;

public class LargestSeqZeroSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LargestSeqZeroSum sol = new LargestSeqZeroSum();
		int[] op = sol.lszero(new int[] {1, 2, -3, 3 });
		print(op);
	}

	private static void print(int[] op) {
		// TODO Auto-generated method stub
		for( int i : op) {
			System.out.print(i+" , ");
		}
		System.out.println();
	}

	class Result {
	    
        int start; int end;
        Result(int start, int end){
            
            this.start = start;
            this.end = end;
        }
    }
    public int[] lszero(int[] A) {
        int[] sum = new int[A.length+1];
        sum[0] = 0;
        Map<Integer, Result> map = new HashMap<>();
        map.put(sum[0], new Result( -1, -1));
        
        // int start = -1, end = -1;
        int max = 0;
        
        for( int i = 0 ; i < A.length ; i++ ){
            sum[i+1] = sum[i]+A[i];
            Result res = map.get(sum[i+1]) ;
            if( res != null ){
                res.end = i;
                map.put(sum[i+1], res);
            }else{
                map.put(sum[i+1], new Result(i, i));
            }
        }
        
        Result maxRes = null;
        for(Integer num : map.keySet()){
            Result res = map.get(num);
            if((res.end - res.start != 0) && max < (res.end - res.start)){
                maxRes = res;
                max = res.end - res.start;
            }
            // else if((num == 0) && max < (res.end - res.start)){
            //     maxRes = res;
            // }
        }
        
        if( maxRes != null ){
            int []op = new int[maxRes.end-maxRes.start];
            int k = 0;
            for( int i = maxRes.start+1 ; i <= maxRes.end ; i++){
                op[k++] = A[i];
            }
            return op;
        }
        return new int[0];
    }
}
