public class LeetCode236 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return helper(root,p,q);
    }

    public TreeNode helper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (root.val == p.val || root.val == q.val) {
            return root;
        }

        TreeNode left = helper(root.left,p,q);
        TreeNode right = helper(root.right,p,q);

        if (left != null && right != null) {
            return root;
        }

        if (left == null && right != null )
            return right;

        if (left != null && right == null )
            return left;
        return null;
    }
}
