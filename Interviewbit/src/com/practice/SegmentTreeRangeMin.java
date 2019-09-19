package com.practice;

import java.util.LinkedList;
import java.util.Queue;

public class SegmentTreeRangeMin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {-1,3,4,0,2,1};
		
		TreeNode node = createSegmentTree(arr, 0, arr.length-1);
		print(node);
		int min = find(node, 2,2);
		System.out.println(min);
	}
	
	private static void print(TreeNode node) {
		// TODO Auto-generated method stub
		Queue<TreeNode> q = new LinkedList<SegmentTreeRangeMin.TreeNode>();
		q.add(node);
		while(!q.isEmpty()) {
			TreeNode curr = q.poll();
			System.out.println(curr.lt+" , "+curr.rt+" , "+curr.val);
			if(curr.left!=null) {
				q.add(curr.left);
			}
			
			if(curr.right!=null) {
				q.add(curr.right);
			}
		}
	}
	
	static enum TYPE {
		PARTIAL,TOTAL,NO;
	}

	private static int find(TreeNode node, int i, int j) {
		// TODO Auto-generated method stub
		TYPE type = overlapKind(node, i, j);
		if(TYPE.NO.equals(type)) {
			return Integer.MAX_VALUE;
		}
		if(TYPE.TOTAL.equals(type)) {
			return node.val;
		}
		return Math.min(((node.left!=null)?find(node.left, i, j):Integer.MAX_VALUE) , (node.right!=null?find(node.right, i, j):Integer.MAX_VALUE));
	}

	private static TYPE overlapKind(TreeNode node, int lt, int rt) {
		// TODO Auto-generated method stub
		if(node.lt >= lt && node.lt <= rt) {
			if (node.rt >= lt && node.rt <= rt) {
				return TYPE.TOTAL;
			} 
		}
		if(node.lt < lt && node.rt < lt) {
			if(node.lt > rt && node.rt > rt) {
				return TYPE.NO;
			}
		}
		return TYPE.PARTIAL;
	}

	static TreeNode createSegmentTree(int[] arr, int lt, int rt){
		if(lt > rt) {
			return null;
		}
		int mid = (lt+rt)/2;
		TreeNode node = new TreeNode(lt, rt);
		if(lt == rt) {
			node.val = arr[lt];
			return node;
		}
		
		node.left = createSegmentTree(arr, lt, mid);
		node.right = createSegmentTree(arr, mid+1, rt);
		int leftmin = node.left == null ? Integer.MAX_VALUE : node.left.val;
		int rightmin = node.right == null ? Integer.MAX_VALUE : node.right.val;
		node.val = Math.min(leftmin, rightmin);
		
		return node;
	}
	
	static class TreeNode{
		TreeNode left;
		TreeNode right;
		int val;
		int lt;
		int rt;
		
		TreeNode(int lt, int rt){
			this.lt = lt;
			this.rt = rt;
		}
	}

}
