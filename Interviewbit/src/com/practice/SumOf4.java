package com.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumOf4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SumOf4 sol = new SumOf4();
		int[][] op = sol.fourSum(new int[] {1, 0, -1, 0, -2, 2}, 0);
		print(op);
		
	}
	
	private static void print(int[][] op) {
		// TODO Auto-generated method stub
		for( int i = 0 ; i < op.length ; i++ ) {
			for( int j = 0; j < 4; j++ ) {
				System.out.print(op[i][j]+" , ");
			}
			System.out.println();
		}
	}

	public int[][] fourSum(int[] A, int B) {
        Arrays.sort(A);
        List<List<Integer>> op = new ArrayList<>();
        
        for(int i = 0 ; i < A.length ; i++){
            
            int sum = 0;
            if(A[i] > B){
                break;
            }
            
            sum = sum + A[i];
            for( int j = i+1 ; j < A.length; j++){
                if(A[i]+A[j] > B){
                    break;
                }
                for(int k = j+1 ; k < A.length ; k++){
                    if(A[i]+A[j]+A[k] > B){
                        break;
                    }
                    
                    for( int l = k+1 ; l < A.length ; l++){
                        if(A[i]+A[j]+A[k]+A[l] > B){
                            break;
                        }else if( A[i]+A[j]+A[k]+A[l] == B) {
                        	List<Integer> res = new ArrayList<>();
                        	res.add(A[i]);
                        	res.add(A[j]);
                        	res.add(A[k]);
                            res.add(A[l]);
                            op.add(res);
                        }
                        
                    }
                }
            }
        }
        return getList(op);
    }
    
    private int[][] getList(List<List<Integer>> list){
        int[][] arr = new int[list.size()][4];
        int i = 0;
        for( List<Integer> li : list ){
            int j = 0;
            for( Integer n : li ){
                arr[i][j++] = n;
            }
            i++;
        }
        return arr;
    }

}
