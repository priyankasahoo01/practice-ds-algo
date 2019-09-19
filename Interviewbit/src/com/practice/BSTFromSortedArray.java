package com.practice;

public class BSTFromSortedArray {
	
	class Node {
		Node left;
		Node right;
		Integer val;
		Node(Integer val){
			this.val = val;
		}
	}
	static Node node(Integer val) {
		BSTFromSortedArray sol = new BSTFromSortedArray();
		Node node = sol.new Node(val);
		return node;
	}
	
	Node formBST(int[] arr, int i, int j) {
		if( i > j) {
			return null;
		}
		int mid = i+(j-i)/2;
		Node root = node(arr[mid]);
		root.left = formBST(arr, i, mid-1);
		root.right = formBST(arr, mid+1, j);
		return root;
	}
	
	public static void main(String[] args) {
//		formBST()
		
	}

}
