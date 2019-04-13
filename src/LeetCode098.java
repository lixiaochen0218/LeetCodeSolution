public class LeetCode098 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isValidBST(TreeNode root) {
        return helper(root,null,null);
    }

    private boolean helper(TreeNode root, Integer max, Integer min){
        if(root == null)
            return true;
        if(min != null && root.val <= min){
            return false;
        }
        if(max != null && root.val >= max){
            return false;
        }

        return helper(root.left, root.val, min) && helper(root.right, max, root.val);
    }
}
