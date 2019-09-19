package com.practice;

public class IndexEqualSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("start");
//		System.out.println(indexEqualsValueSearch(new int[]{-8,0,1,3,5}));
		System.out.println("done");
		int i = indexEqualsValueSearch(new int[] {-5,0,3,4,10,18,27});
		System.out.println("i -> "+i);
	}

	  static int indexEqualsValueSearch(int[] arr) {
		  return search(arr, 0, arr.length);
//		return -1;
		  
	  }

	private static int search(int[] arr, int l, int r) {
		if( l > r) {
			return -1;
		}
		while( l < r) {
//			int mid = l+(r-l)/2;
			int mid = (l+r)/2;
			if( mid == arr[mid]) {
				r = mid;
			}else if( arr[mid] > mid) {
				r = mid-1;
			}else {
				l = mid+1;
			}
		}
		
		return ((arr[l] == l )? l : -1);
	}
}
