import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=872 lang=java
 *
 * [872] Leaf-Similar Trees
 */

// @lc code=start
class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> s1 = new ArrayList<>();
        List<Integer> s2 = new ArrayList<>();
        getLeafSequence(s1, root1);
        getLeafSequence(s2, root2);
        if (s1.size() != s2.size()) {
            return false;
        }
        for (int i = 0; i < s1.size(); i++) {
            if (s1.get(i) != s2.get(i)) {
                return false;
            }
        }
        return true;
    }

    private void getLeafSequence(List<Integer> sequence, TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            sequence.add(root.val);
        } else {
            getLeafSequence(sequence, root.left);
            getLeafSequence(sequence, root.right);
        }
    }
}
// @lc code=end
