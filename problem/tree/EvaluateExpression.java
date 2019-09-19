package com.problem.tree;

public class EvaluateExpression {
    class Node{
        Node left;
        Node right;
        String data;
        Node(String data){
            this.data = data;
        }
    }
    static Node node(String data) {
        EvaluateExpression exp = new EvaluateExpression();
        return exp.new Node(data);
    }
    
    

    public static void main(String[] args) {

        Node n1 = node("*");
        Node n2 = node("+");
        Node n3 = node("+");
        n1.left=n2;
        n1.right=n3;
        Node n4 = node("3");
        Node n5 = node("2");
        n2.left=n4;
        n2.right=n5;
        Node n6 = node("4");
        Node n7 = node("5");
        n3.left=n6;
        n3.right=n7;
        Integer op = evaluate(n1);
        System.out.println("output --> "+op);
    }
    
    static boolean isLeafNode(Node node) {
        if(node!=null && node.left==null && node.right==null) {return true;}
        return false;
    }
    
    static Integer evaluate(Node root) {
        if(root == null) {return null;}
        if(isLeafNode(root)) {return Integer.parseInt(root.data);}
        return operate(evaluate(root.left), evaluate(root.right), root.data);
    }
    
    static Integer operate(Integer n1, Integer n2, String op) {
        switch(op) {
        case "+":
            return n1+n2;
        case "-":
            return n1-n2;
        case "*":
            return n1*n2;
        case "/":
            return n1/n2;
        }
        return -1;
    }

}
