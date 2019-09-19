package com.practice;

import java.util.ArrayList;
import java.util.List;
/**
 * Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * @author priysaho
 *
 */
public class BuySellStock {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
	public static void main(String[] args) {
		BuySellStock sol = new BuySellStock();
//		int[] arr = {100, 180, 260, 310, 40, 535, 695};
		int[] arr = {1,2};
		int op = sol.maxProfit(arr);
		System.out.println(op);
	}
    class Result{
        Integer buy, sell;
    }
    public int maxProfit(final int[] ip) {
        List<Result> results = new ArrayList<>();
        
        if(ip == null || ip.length == 0 ){
            return 0;
        }
        int i = 0;
        int n = ip.length ;
        while(i<n-1){
            while(i<n-1 && ip[i] >= ip[i+1]){i++;};
            if( i == n-1){
                break;
            }
           
            Result res = new Result();
            res.buy = i;
            i++;
            while(i < n-1 && ip[i]<=ip[i+1]){i++;};
            res.sell = i;
            results.add(res);
            i++;
            
        }
        
        int op = 0;
        for ( Result r : results) {
            if(r.buy!=null && r.sell!=null)
            op = op + ip[r.sell]-ip[r.buy];
        }
        return op;
    }
    
}
