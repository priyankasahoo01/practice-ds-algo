package com.practice;

/**
 * Find the closest pair from two sorted arrays
Given two sorted arrays and a number x, find the pair whose sum is closest to x and the pair has an element from each array.
We are given two arrays ar1[0…m-1] and ar2[0..n-1] and a number x, we need to find the pair ar1[i] + ar2[j] such that absolute value of (ar1[i] + ar2[j] – x) is minimum.

Example:

Input:  ar1[] = {1, 4, 5, 7};
        ar2[] = {10, 20, 30, 40};
        x = 32      
Output:  1 and 30

Input:  ar1[] = {1, 4, 5, 7};
        ar2[] = {10, 20, 30, 40};
        x = 50      
Output:  7 and 40
 * 
 *
 */
public class ClosesPairInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 = {1, 4, 5, 7};
		int[] arr2 = {10, 20, 30, 40};
		int val = 32;
		closest(arr1, arr2, val);
		closest(arr1, arr2, 50);


	}

	private static void print(int[] op) {
		System.out.println("op - > "+op[0]+" , "+op[1]);
	}

	private static int[] closest(int[] arr1, int[] arr2, int val) {
		// TODO Auto-generated method stub
		int l = 0, r = arr2.length-1;
		int diffmin = Integer.MAX_VALUE;
		int[] op = new int[2];
		
		while(l < arr1.length && r >= 0) {
			int currSum = arr1[l]+arr2[r];
			int diff = Math.abs(val - currSum);
			if(diff == 0) {
				op[0] = arr1[l];
				op[1] = arr2[r];
				return op;
			}
			if(diff < diffmin) {
				diffmin = diff;
				op[0] = arr1[l];
				op[1] = arr2[r];
			}
			if(currSum > val) {
				r--;
			}else {
				l++;
			}
		}
		print(op);
		return op;
	}

}
