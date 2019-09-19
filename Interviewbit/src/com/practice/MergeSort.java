package com.practice;

public class MergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {10, 80, 30, 90, 40, 50, 70 };
		testsort(arr);
		int[] arr1 = {2, 1, 5, 0, 0, 8, 7, 6, 3};
		testsort(arr1);

	}

	private static void testsort(int[] arr) {
		MergeSort sort = new MergeSort();
		sort.mergesort(arr);
		printarr(arr);
	}

	private static void printarr(int[] arr) {
		for(int n : arr) {
			System.out.print(n+" , ");
		}
		System.out.println();
	}
	
	public void mergesort(int[] arr) {
		mergesort(arr, 0, arr.length-1);
	}

	private void mergesort(int[] arr, int l, int r) {
		// TODO Auto-generated method stub
		if( l >= r) {
			return;
		}
		int mid = l+(r-l)/2;
		mergesort(arr, l, mid);
		mergesort(arr, mid+1, r);
		
		merge(arr, l, mid, r);
	}

	private void merge(int[] arr, int l, int mid, int r) {
		// TODO Auto-generated method stub
		
		int i = l, j = mid+1;
		int end1 = mid, end2 = r; 
		int[] op = new int[r-l+1];
		int k = 0;
		while(i <= end1 && j <= end2) {
			if(arr[i] <= arr[j]) {
				op[k++] = arr[i++];
			}else {
				op[k++] = arr[j++];
			}
		}
		
		while( i <= end1) {
			op[k++] = arr[i++];
		}
		while( j <= end2){ 
			op[k++] = arr[j++];
		}
		
		//copy arr
		k = 0;
		for( int t = l ; t <= r; t++) {
			arr[t] = op[k++];
		}
		
	}

}
