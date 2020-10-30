import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/*
 * @lc app=leetcode id=94 lang=java
 *
 * [94] Binary Tree Inorder Traversal
 */

// @lc code=start
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> answers = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            // Move to the left all the way down and push every node into stack.
            if (current != null) {
                stack.addLast(current);
                current = current.left;
            } else {
                // If there is no left branch, trace back, print and move right if possible.
                TreeNode node = stack.removeLast();
                answers.add(node.val);
                current = node.right;
            }
        }
        return answers;
    }
}

// @lc code=end
