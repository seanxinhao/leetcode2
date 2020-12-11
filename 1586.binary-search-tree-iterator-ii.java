class BSTIterator {
  private Deque<TreeNode> stack = new ArrayDeque<>();
  private List<Integer> history = new ArrayList<>();
  private int next = -1;
  
  public BSTIterator(TreeNode root) {
      TreeNode p = root;
      while (p != null) {
          stack.addLast(p);
          p = p.left;
      }
  }
  
  public boolean hasNext() {
      return !stack.isEmpty() || next < history.size() - 1;
  }
  
  public int next() {
      if (next == history.size() - 1) {
          TreeNode ans = stack.removeLast();
          if (ans.right != null) {
              TreeNode p = ans.right;
              while (p != null) {
                  stack.addLast(p);
                  p = p.left;
              }
          }
          history.add(ans.val);
          next++;
          return ans.val;
      } else {
          next++;
          int ans = history.get(next);
          return ans;
      }
  }
  
  public boolean hasPrev() {
      return next - 1 >= 0;
  }
  
  public int prev() {
      next--;
      int ans = history.get(next);
      return ans;
  }
}