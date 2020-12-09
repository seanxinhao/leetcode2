/*
 * @lc app=leetcode id=1530 lang=java
 *
 * [1530] Number of Good Leaf Nodes Pairs
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int counts = 0;

    public int countPairs(TreeNode root, int distance) {
        traverse(root, distance);
        return counts;
    }

    private List<Integer> traverse(TreeNode root, int d) {
        if (root == null) {
            return new ArrayList<>();
        }
        if (root.left == null && root.right == null) {
            List<Integer> res = new ArrayList<>();
            res.add(0);
            return res;
        }
        List<Integer> left = traverse(root.left, d);
        for (int i = 0; i < left.size(); i++) {
            left.set(i, left.get(i) + 1);
        }
        List<Integer> right = traverse(root.right, d);
        for (int i = 0; i < right.size(); i++) {
            right.set(i, right.get(i) + 1);
        }
        for (int i = 0; i < left.size(); i++) {
            for (int j = 0; j < right.size(); j++) {
                if (left.get(i) + right.get(j) <= d) {
                    counts++;
                }
            }
        }
        List<Integer> leaves = new ArrayList<>();
        leaves.addAll(left);
        leaves.addAll(right);
        return leaves;
    }
}
// @lc code=end
