package com.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraverse {
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

	class Node{
        TreeNode node;
        int level;
        Node(TreeNode node,int level){
            this.node = node;
            this.level = level;
        }
    }
    public int[][] levelOrder(TreeNode A) {
        
    	List<List<Integer>> result = path(new Node(A, 0));
        return convert(result);
    }
    
    private List<List<Integer>> path(Node node){
    	List<List<Integer>> op = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        op = new ArrayList<>();
        
        while(!q.isEmpty()){
            Node curr = q.poll();
            if(op.size()-1 < curr.level){
                List<Integer> li = new ArrayList<>();
                li.add(curr.node.val);
                op.add(li);
            }else {
                op.get(curr.level).add(curr.node.val);
            }
            if(curr.node.left!=null){
                q.add(new Node(curr.node.left, curr.level+1));
            }
            if(curr.node.right!=null){
                q.add(new Node(curr.node.right, curr.level+1));
            }
        }
        return op;
    }
    
    private int[][] convert(List<List<Integer>> op){
        int[][] arr = new int[op.size()][];
        int i = 0;
        for(List<Integer> li : op){
            arr[i] = new int[li.size()];
            int j = 0;
            for(Integer n : li){
                arr[i][j++] = n;
            }
            i++;
        }
        return arr;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LevelOrderTraverse sol = new LevelOrderTraverse();
		TreeNode node = node(1);
		node.left = node(2);
		node.right = node(3);
		node.left.left = node(80);
		node.left.right = node(19);
		node.right.left = node(8);
		node.right.right = node(9);
		int[][] op = sol.levelOrder(node);
		System.out.println("---------");
		for( int i = 0 ; i < op.length ; i++) {
			for( int j = 0 ; j < op[i].length ; j++) {
				System.out.print(op[i][j]+" ");
			}
			System.out.println();
		}
		
		System.out.println("---------");
	}

	private static TreeNode node(int val) {
		LevelOrderTraverse sol = new LevelOrderTraverse();
		TreeNode node = sol.new TreeNode(val);
		return node;
	}

}
