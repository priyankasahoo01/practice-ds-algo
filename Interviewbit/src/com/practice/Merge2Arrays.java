package com.practice;

public class Merge2Arrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		int[] arr1 = {1,2,3,4,11,19};
//		int[] arr2 = {0,6,7,8,9,12, 13, 15};
//		int[] arr = merge(arr1, arr2);
//		for( int i : arr) {
//			System.out.print(i+" , ");
//		}
		System.out.println();
		System.out.println(Math.pow(2, 32));
		System.out.println(Math.pow(2, 12));
		
	}
	
	public static int[] merge(int[] arr1, int[] arr2) {
		int i = 0, j = 0;
		int[] op = new int[arr1.length+arr2.length];
		int k = 0;
		while( i < arr1.length && j < arr2.length) {
			if(arr1[i] <= arr2[j]) {
				op[k++] = arr1[i++];
			}else {
				op[k++] = arr2[j++];
			}
		}
		while( i < arr1.length) {
			op[k++] = arr1[i++];
		}
		
		while( j < arr2.length ) {
			op[k++] = arr2[j++];
		}
		return op;
	}

}
