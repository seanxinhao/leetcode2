import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/*
 * @lc app=leetcode id=145 lang=java
 *
 * [145] Binary Tree Postorder Traversal
 */

// @lc code=start
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> answers = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode previous = null;
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            // Move to the left all the way down and push every node into stack.
            if (current != null) {
                stack.addLast(current);
                current = current.left;
            } else {
                // If there is no left branch, trace back, check if the right node is previous
                // processed node.
                TreeNode node = stack.getLast();
                if (node.right == null || previous == node.right) {
                    // Process the top node if so.
                    stack.removeLast();
                    previous = node;
                    answers.add(node.val);
                    current = null;
                } else {
                    // Process the right sub-tree if no so.
                    current = node.right;
                }
            }
        }
        return answers;

        // Solution 2
        // Reverse the pre-order traverse statements and reverse output the results
        // using deque.
    }
}
// @lc code=end
