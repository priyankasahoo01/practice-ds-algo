package com.practice;

import java.util.ArrayList;
import java.util.List;

public class CoinsChange {

	//1111,121, 13, 22
	public static void main(String[] args) {
		long[] coins = {1,2,3};
		
		findWays(3, coins);
		
	}
	static void findWays(long n , long[] coins) {
		List<List<Long>> op = new ArrayList<List<Long>>();
		List<Long> mylist = new ArrayList<>();
		findWays(n, coins, 0, mylist, op);
		System.out.println("---------op---------");
		for(List<Long> li : op) {
			for( Long l : li ) {
				System.out.print(l+" ");
			}
			System.out.println();
		}
		
		
	}
	static void findWays(long n , long[] coins, int start, List<Long> curr, List<List<Long>> op){
		if(n < 0) {
			return ;
		}
		if( n == 0 ) {
				op.add(curr);
			return;
			
		}
		for( int i = start ; i < coins.length ; i++ ) {
			if( coins[i] > n ) {
				break;
			}
			List<Long> l = clone(curr);
			l.add(coins[i]);
			findWays(n-coins[i], coins, i, l, op);
		}
	}
	
	private static List<Long> clone(List<Long> curr) {
		List<Long> li = new ArrayList<Long>();
		for(Long l : curr) {
			li.add(l);
		}
		return li ;
	}
	static long getWays(long n, long[] coins){
        long num = 0;
        
        long ways = getWays( n , coins , 0);
		num = num + ways;
        return num;
    }
    static long getWays(long n, long[] coins, int start) {
        if( n < 0l ){
            return 0l;
        }
        if( n== 0l ){
            return 1l;
        }
        long num = 0l;
        //f(3,0)
        for(int i = start ; i < coins.length; i++ ){
            if(coins[i] > n){
                break;
            }
            num = num + getWays(n-coins[i], coins , i);//0+f(4,0)->0+f(3,0)->0+f(2,0)->0+f(1,0)->0+1->
            										   //0+f()
        }
        return num;
    }

}
