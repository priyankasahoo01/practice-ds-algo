package com.practice;

public class QuickSort {
	
	public static void main(String[] args) {
		QuickSort sort = new QuickSort();
		int[] arr = {2, 1, 5, 0, 0, 8, 7, 6, 3};
		sort.sort(arr);
		printarr(arr);
	}
	
	private static void printarr(int[] arr) {
		for(int n : arr) {
			System.out.print(n+" , ");
		}
		System.out.println();
	}
	public void sort(int[] arr) {
		quicksort(arr, 0, arr.length-1);
	}

	private void quicksort(int[] arr , int l, int r) {
		if( l == r) {
			return;
		}
		int index = partition(arr, l, r);
		if(l < index-1)
		quicksort(arr, l, index-1);
		if(r > index+1)
		quicksort(arr, index+1, r);
	}

	private int partition(int[] arr, int l, int r) {
		// TODO Auto-generated method stub
		int pivot = arr[r];
		int i = l, j = r-1;
		while( i <= j ) {
			while(arr[i] < pivot) {
				i++;
			}
			
			while(arr[j] > pivot) {
				j--;
			}
			
			if( i < j) {
				swap(arr, i, j);
				i++;
				j--;
			}
			
		}
		swap(arr, i, r);
		return i;
	}

	private void swap(int[] arr, int i, int j) {
		// TODO Auto-generated method stub
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;		
	}
}
