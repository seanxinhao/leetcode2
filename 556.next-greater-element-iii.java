/*
 * @lc app=leetcode id=556 lang=java
 *
 * [556] Next Greater Element III
 */

// @lc code=start
class Solution {
    public int nextGreaterElement(int n) {
        char[] numbers = Integer.toString(n).toCharArray();
        int s = numbers.length;
        for (int i = s - 2; i >= 0; i--) {
            if (Character.getNumericValue(numbers[i]) < Character.getNumericValue(numbers[i + 1])) {
                int j = s - 1;
                while (j > i && Character.getNumericValue(numbers[j]) <= Character.getNumericValue(numbers[i])) {
                    j--;
                }
                char temp = numbers[j];
                numbers[j] = numbers[i];
                numbers[i] = temp;
                Arrays.sort(numbers, i + 1, s);
                String resStr = new String(numbers);
                try {
                    return Integer.parseInt(resStr);
                } catch (Exception e) {
                    return -1;
                }
            }
        }
        return -1;
    }
}
// @lc code=end
