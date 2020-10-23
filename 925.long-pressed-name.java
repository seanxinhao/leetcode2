/*
 * @lc app=leetcode id=925 lang=java
 *
 * [925] Long Pressed Name
 */

// @lc code=start
class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int j = 0;
        for (int i = 0; i < name.length(); i++) {
            int counter1 = 1;
            while (i < name.length() - 1 && name.charAt(i) == name.charAt(i + 1)) {
                counter1++;
                i++;
            }
            int counter2 = 0;
            while (j < typed.length() && typed.charAt(j) == name.charAt(i)) {
                counter2++;
                j++;
            }
            if (counter2 < counter1) {
                return false;
            }
        }
        if (j != typed.length()) {
            return false;
        }
        return true;
    }
}
// @lc code=end
