package com.practice;

public class SortedArrayToBST {
	
	class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) {
	      val = x;
	      left=null;
	      right=null;
	     }
	     
	 }
	
	private static TreeNode node(int i) {
		SortedArrayToBST sol = new SortedArrayToBST();
		TreeNode node = sol.new TreeNode(i);
		return node;
	}
	
	public static TreeNode formTree(int[] arr, int l , int r ) {
		if(l > r) {
			return null;
		}
		if( l== r ) {
			return node(arr[l]);
		}
		int mid = (l+r)/2;
		TreeNode node = node(arr[mid]);
		node.left = formTree(arr, l, mid-1);
		node.right = formTree(arr, mid+1, r);
		return node;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeNode node = formTree(new int[] {1,2,3,4,5}, 0, 5-1);
		System.out.println(node);
		

	}

}
