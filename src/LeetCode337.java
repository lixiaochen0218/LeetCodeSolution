public class LeetCode337 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

//    public int rob(TreeNode root) {
//        if (root == null) return 0;
//
//        int val = root.val;
//        int ll = 0, lr = 0, rl = 0, rr = 0;
//        if (root.left != null) {
//            if (root.left.left != null) {
//                ll = rob(root.left.left);
//            }
//            if (root.left.right != null) {
//                lr = rob(root.left.right);
//            }
//        }
//        if (root.right != null) {
//            if (root.right.left != null) {
//                rl = rob(root.right.left);
//            }
//            if (root.right.right != null) {
//                rr = rob(root.right.right);
//            }
//        }
//        return Math.max(val + lr + ll + rl + rr, rob(root.left) + rob(root.right));
//    }
    public int rob(TreeNode root) {
        if (root == null) return 0;
        return Math.max(robInclude(root), robExclude(root));
    }

    public int robInclude(TreeNode node) {
        if(node == null) return 0;
        return robExclude(node.left) + robExclude(node.right) + node.val;
    }

    public int robExclude(TreeNode node) {
        if(node == null) return 0;
        return rob(node.left) + rob(node.right);
    }
}
