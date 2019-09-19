package com.practice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class TreeVerticalOrdering {
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
	
	public int[][] verticalOrderTraversal(TreeNode node) {
		PriorityQueue<Integer> q = new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}
		});
        List<List<Integer>> op = new ArrayList<>();
        int left = findLeftIndex(node);
        int right = findRightIndex(node);
        initList(op, left+right+1);
        path(node,op, left);
        return convertListToArr(op);
    }
    
    private void initList(List<List<Integer>> op, int n) {
    	for(int i = 0 ; i < n; i++) {
    		op.add(new ArrayList<>());
    	}
		
	}

	private int findRightIndex(TreeNode node) {
    	TreeNode curr = node;
        int level = -1;
        while(curr != null){
            level++;
            curr = curr.right;
        }
        return level;
	}

	private int[][] convertListToArr(List<List<Integer>> op) {
        int[][] arr = new int[op.size()][];
        for(int i = 0 ; i < op.size(); i++){
            arr[i] = new int[op.get(i).size()];
            for(int j = 0 ; j < op.get(i).size(); j++){
                arr[i][j] = op.get(i).get(j);
            }
        }
        return arr;
    }
    
    private int findLeftIndex(TreeNode node){
        TreeNode curr = node;
        int level = -1;
        while(curr != null){
            level++;
            curr = curr.left;
        }
        return level;
    }
    private void path(TreeNode node, List< List<Integer>> op, int level){
        
        // int right = findRightIndex(node);
        if(node == null){
            return;
        }
        if(level == op.size()){
            List<Integer> li = new ArrayList<>();
            li.add(node.val);
            op.add(li);
        }
        else if(op.get(level) == null){
            List<Integer> li = new ArrayList<>();
            li.add(node.val);
            op.set(level,li);
        }else{
            op.get(level).add(node.val);
        }
        path(node.left, op, level-1);
        path(node.right, op, level+1);
    }

	public static void main(String[] args) {

		TreeNode node = node(5);
		node.left = node(1000);
		node.right = node(200);
		
		
		
		TreeVerticalOrdering sol = new TreeVerticalOrdering();
		int[][] op = sol.verticalOrderTraversal(node);
		print2dArray(op);
		
		System.out.println("Test2");
		//create test2
		TreeNode node1 = node(123);
		node1.right = node(181);
		node1.right.left = node(7279);
		node1.right.right = node(529);
		op = sol.verticalOrderTraversal(node1);
		print2dArray(op);
		
		//test 3
		TreeNode node2 = node(2715);
		node2.left = node(8913);
		node2.left.left = node(930);
		node2.left.left.left = node(2809);
		op = sol.verticalOrderTraversal(node2);
		print2dArray(op);
	}

	private static void print2dArray(int[][] op) {
		System.out.println("size : "+op.length);
		for(int i = 0 ; i < op.length ; i++) {
			for(int j = 0 ; j < op[i].length; j++) {
				System.out.print(op[i][j]+" , ");
			}
			System.out.println("----- row"+i+" ends ------");
		}
	}
	
	private static TreeNode node(int i) {
		TreeVerticalOrdering sol = new TreeVerticalOrdering();
		TreeNode node = sol.new TreeNode(i);
		return node;
	}

}
