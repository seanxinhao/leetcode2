/*
 * @lc app=leetcode id=103 lang=java
 *
 * [103] Binary Tree Zigzag Level Order Traversal
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Deque<TreeNode> q = new ArrayDeque<>();
        q.addLast(root);
        int counter = 0;
        while (!q.isEmpty()) {
            int s = q.size();
            Deque<Integer> print = new ArrayDeque<>();
            for (int i = 0; i < s; i++) {
                TreeNode curr = q.removeFirst();
                if (counter % 2 == 0) {
                    // left to right;
                    print.addLast(curr.val);
                } else {
                    // right to left;
                    print.addFirst(curr.val);
                }
                if (curr.left != null) {
                    q.addLast(curr.left);
                }
                if (curr.right != null) {
                    q.addLast(curr.right);
                }
            }
            counter++;
            ans.add(print.stream().collect(Collectors.toList()));
        }
        return ans;
    }
}
// @lc code=end
