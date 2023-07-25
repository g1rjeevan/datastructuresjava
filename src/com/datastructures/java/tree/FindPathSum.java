package com.datastructures.java.tree;

public class FindPathSum {

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

    public static void main(String[] args) {

        FindPathSum f = new FindPathSum();
        f.pathSum(f.new TreeNode(),8);

    }

    public int pathSum(TreeNode root, int targetSum) {

        return recursionPath(root, targetSum, 0, 0);


    }

    public int recursionPath(TreeNode root, int targetSum, int reachTargetSumCount, int reachTargetSum) {
        int sumLeft = root.val + reachTargetSum;
        int sumRight = root.val + reachTargetSum;
        if (sumLeft == targetSum) {
            reachTargetSumCount++;
            if (root.left != null) {
                return recursionPath(root.left, targetSum, reachTargetSumCount, 0);
            } else {
                return reachTargetSumCount;
            }

        }
        if (sumRight == targetSum) {
            reachTargetSumCount++;
            if (root.right != null) {
                return recursionPath(root.right, targetSum, reachTargetSumCount, 0);
            } else {
                return reachTargetSumCount;
            }
        }

        if (sumRight > targetSum || sumLeft > targetSum) {
            if (root.left != null) {
                return recursionPath(root.left, targetSum, reachTargetSumCount, 0);
            } else if (root.right != null) {
                return recursionPath(root.right, targetSum, reachTargetSumCount, 0);
            } else {
                return reachTargetSumCount;
            }
        }


        if (sumRight < targetSum && root.right != null) {
            return recursionPath(root.right, targetSum, reachTargetSumCount, sumRight);
        } else if (sumLeft < targetSum && root.left != null) {
            return recursionPath(root.left, targetSum, reachTargetSumCount, sumLeft);
        } else {
            return reachTargetSumCount;
        }
    }
}
