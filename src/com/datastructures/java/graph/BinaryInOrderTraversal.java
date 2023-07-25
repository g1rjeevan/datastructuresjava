package com.datastructures.java.graph;

import java.util.ArrayList;
import java.util.List;

public class BinaryInOrderTraversal {
    public static void main(String[] args) {
        BinaryInOrderTraversal binaryInOrderTraversal = new BinaryInOrderTraversal();
        TreeNode treeNode = binaryInOrderTraversal.new TreeNode(1);
        treeNode.right = binaryInOrderTraversal.new TreeNode(2);
        treeNode.right.left = binaryInOrderTraversal.new TreeNode(3);
        binaryInOrderTraversal.inorderTraversal(treeNode).forEach(System.out::println);

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inOrder = new ArrayList<>();
        addInOrder(root, inOrder);
        return inOrder;
    }

    public static void addInOrder(TreeNode root, List<Integer> inOrderTree) {
        if (root == null) {
            return;
        }
        addInOrder(root.left, inOrderTree);
        inOrderTree.add(root.val);
        addInOrder(root.right, inOrderTree);
    }
}
