package com.practice;

/**
 Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

Example :

Given the below binary tree and sum = 22,
 @author priysaho
 *
 */
public class PathSum {
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
		 
	
	private boolean isLeaf(TreeNode node){
        return node!= null && node.left == null && node.right == null;
    }
    public int hasPathSum(TreeNode node, int sum) {
        if(node == null){
            if(sum == 0){
                return 1;
            }
            return 0;
        }
        // if(node == null && sum == 0){
        //     return 0;
        // }
        // if(sum < 0){
        //     return 0;
        // }
        // if(node == null && sum > 0 ){
        //     return 0;
        // }
        if(isLeaf(node) ){
            return (node.val == sum) ? 1 : 0;
        }
        boolean isPresent = (hasPathSum(node.left, sum-node.val)==1 || hasPathSum(node.right, sum-node.val)==1);
        return isPresent ? 1 : 0;
    }
    

	public static void main(String[] args) {
		
		TreeNode node = node(5);
		node.left = node(1000);
		node.right = node(200);
		PathSum sol = new PathSum();
		int op = sol.hasPathSum2(node, 1000);
		System.out.println("op -> "+op);

		char in = 'a'+1-1;
		System.out.println(new Character(in).toString());
	}
	private static TreeNode node(int i) {
		PathSum sol = new PathSum();
		TreeNode node = sol.new TreeNode(i);
		return node;
	}
	
	public int hasPathSum2(TreeNode A, int B) {
        return hasPathSum1(A, B) ? 1 : 0;
    }
    public boolean hasPathSum1(TreeNode A, int B) {
        if(A == null ){
            return false;
        }
        if((A.left == null && A.right == null)){
            return B==A.val;
        }
        return hasPathSum1(A.left, B-A.val) || hasPathSum1(A.right, B- A.val);
    }

}
