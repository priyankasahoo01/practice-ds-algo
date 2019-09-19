package com.practice;

public class DominoTrominoTiling {

	public static void main(String[] args) {
		int op = numTilings(4);
		System.out.println(op);
	}
	
	public static int numTilings(int N) {
        if(N == 0){
            return 1;
        }
        if( N == 1 ){
            return 1;
        }
        if( N == 2 ){
            return 2;
        }
        int count = 0;
        if(N - 1  >= 0){
            count = count + numTilings(N-1);
        }
        if( N-2 >= 0 ){
            count = count + numTilings(N-2);
        }
        if( N-3 >= 0 ){
            count = count + 2*numTilings(N-3);
        }
        return count;
    }

}
