package com.practice;

public class MaxSumPathBinaryTree {
	static class TreeNode{
		TreeNode left, right;
		int val;
		TreeNode(int val){
			this.val = val;
		}
	}
	
	static Result maxPath(TreeNode root) {
		if(root == null) {
			return new Result();
		}
		Result left = null;
		Result right = null;
		int totalval =  root.val;//max(left.total, right.total, (left.maxSide+root.val), root.val, (right.maxSide+root.val), (root.val+right.maxSide+left.maxSide));
		Integer maxSide = Integer.MIN_VALUE;
		if(root.left != null) {
			left = maxPath(root.left);
			totalval =  max(left.total,  (left.maxSide+root.val), root.val);
			maxSide = left.maxSide;
		}
		
		if(root.right != null) {
			right = maxPath(root.right);
			totalval =  max(right.total,  root.val , root.val+right.maxSide, (left!=null ? root.val+right.maxSide+left.maxSide : Integer.MIN_VALUE), totalval);
			maxSide = max(maxSide, right.maxSide);
		}
		
		Result result = new Result();
		result.total = totalval;
		result.maxSide = max(root.val, root.val+((maxSide == Integer.MIN_VALUE) ? 0 : maxSide));
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Integer.MIN_VALUE);
		MaxSumPathBinaryTree sol = new MaxSumPathBinaryTree();
		TreeNode node = node(1);
		TreeNode node2 = node(2);
		TreeNode node3 = node(3);
		TreeNode node4 = node(4);
		TreeNode node5 = node(5);
		TreeNode node6 = node(6);
		TreeNode node7 = node(7);
		
		node.left = node2;
		node.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node3.right = node7;
//		Result max = sol.maxPath(node);
//		System.out.println(" max path : "+Math.max(max.maxSide, max.total));
		
		
		test1();
	}
	
	private static void test1() {
		System.out.println("test starts");
		TreeNode node = node(-1);
		TreeNode node2 = node(5);
		TreeNode node3 = node(4);
		TreeNode node4 = node(2);
		TreeNode node5 = node(-4);
		node.left = node2;
		node2.left = node3;
		node3.right = node4;
		node4.left = node5;
		Result max = maxPath(node);
		System.out.println(" max path : "+Math.max(max.maxSide, max.total));
		System.out.println("test ends");
		
	}

	private static void test() {
		System.out.println("test starts");
		TreeNode node = node(-10);
		TreeNode node2 = node(9);
		TreeNode node3 = node(20);
		TreeNode node4 = node(15);
		TreeNode node5 = node(7);
		node.left = node2;
		node.right = node3;
		node3.left = node4;
		node3.right = node5;
		Result max = maxPath(node);
		System.out.println(" max path : "+Math.max(max.maxSide, max.total));
		System.out.println("test ends");
		
	}
	private static TreeNode node(int i) {
		// TODO Auto-generated method stub
		
		return new TreeNode(i);
	}
//	
//	static Result maxPath(TreeNode root) {
//		if(root == null) {
//			return new Result();
//		}
//		Result left = null;
//		Result right = null;
//		int totalval =  root.val;//max(left.total, right.total, (left.maxSide+root.val), root.val, (right.maxSide+root.val), (root.val+right.maxSide+left.maxSide));
//		Integer maxSide = Integer.MIN_VALUE;
//		if(root.left != null) {
//			left = maxPath(root.left);
//			totalval =  max(left.total,  (left.maxSide+root.val), root.val);
//			maxSide = left.maxSide;
//		}
//		
//		if(root.right != null) {
//			right = maxPath(root.right);
//			totalval =  max(right.total,  root.val , root.val+right.maxSide, (left!=null ? root.val+right.maxSide+left.maxSide : Integer.MIN_VALUE), totalval);
//			maxSide = max(maxSide, right.maxSide);
//		}
//		if(left != null) {
//			
//		}
//		
//		Result result = new Result();
//		result.total = totalval;
//		result.maxSide = max(root.val+((maxSide == Integer.MIN_VALUE) ? 0 : maxSide));
//		return result;
//	}
	
	static int max (int ...arr) {
		int max = arr[0];
		for(int i : arr) {
			if(i > max) {
				max = i;
			}
		}
		return max;
	}

	static class Result{
		int total ;
		int maxSide ;
	}
}
