package com.java.codingtest.leetcode;

/**
 * Given the root of a binary tree, return its maximum depth.
 * A binary tree's maximum depth :
 * the number of nodes along the longest path from the root node down to the farthest leaf node.
 */
public class Q104_MaximumDepthOfBinaryTree {
    public static class TreeNode {
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

    // 후위 탐색 방식
    public int maxDepth(TreeNode root) {
        if (root == null) return 0; // null인 노드를 방문하면 0 리턴

        // 왼쪽 먼저 재귀로 끝까지 탐색
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
}
