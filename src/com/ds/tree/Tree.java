package com.ds.tree;

import java.security.InvalidParameterException;

public class Tree {

    public enum TraverseType {
        INORDER, PREORDER, POSTORDER, PARALLEL
    }

    public Node root;

    public void add(int data) {
        Node node = new Node(data);
        if (root == null) {
            root = node;
        } else {
            Node local = root;
            while (local != null) {
                if (data < local.data) {
                    if (local.left == null) {
                        local.left = node;
                        break;
                    }
                    local = local.left;
                }
                if (data > local.data) {
                    if (local.right == null) {
                        local.right = node;
                        break;
                    }
                    local = local.right;
                }
            }

        }
    }

    public void traverse(TraverseType traverseType) {
        System.out.println("Traversing tree with traverse type: " + traverseType);
        if (traverseType == TraverseType.INORDER) {
            inOrderTraverse(root);
        } else if (traverseType == TraverseType.PREORDER) {
            preOrderTraverse(root);
        } else if (traverseType == TraverseType.POSTORDER) {
            postOrderTraverse(root);
        } else if (traverseType == TraverseType.PARALLEL) {
            System.out.println(root.data);
            parallelTraverse(root);
        } else {
            throw new InvalidParameterException("Traverstype " + traverseType + " is not supported");
        }

    }

    private void parallelTraverse(Node node) {
        if (node == null) {
            return;
        }
//        System.out.print(node.data + "\t");
        System.out.print((node.left==null?"":node.left.data)+"\t "+(node.right==null?"":node.right.data));
        parallelTraverse(node.left);
        parallelTraverse(node.right);
        System.out.println("\n");
    }

    private void preOrderTraverse(Node current) {
        if (current == null) {
            return;
        }
        if (isLeafNode(current)) {
            System.out.println(current.data);
            return;
        }
        System.out.println(current.data);
        inOrderTraverse(current.left);
        inOrderTraverse(current.right);
    }

    private void inOrderTraverse(Node current) {
        if (current == null) {
            return;
        }
        if (isLeafNode(current)) {
            System.out.println(current.data);
            return;
        }
        inOrderTraverse(current.left);
        System.out.println(current.data);
        inOrderTraverse(current.right);
    }

    private void postOrderTraverse(Node current) {
        if (current == null) {
            return;
        }
        if (isLeafNode(current)) {
            System.out.println(current.data);
            return;
        }
        inOrderTraverse(current.left);
        inOrderTraverse(current.right);
        System.out.println(current.data);
    }

    private boolean isLeafNode(Node local) {
        return (local.left == null) && (local.right == null);
    }

    public int depthOfTree() {
        return depth(root);
    }

    public int depth(Node node) {
        if (node == null) {
            return 0;
        }
        // if(node.left == null && node.right ==null){
        // return 1;
        // }
        return 1 + Math.max(depth(node.left), depth(node.right));
    }

    class Node {
        Node left;
        Node right;
        private int data;

        public Node(int data) {
            super();
            this.data = data;
        }

    }

}
