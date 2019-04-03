public class LeetCode235 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val > root.val && q.val > root.val){
            return lowestCommonAncestor(root.right, p, q);
        }else if (p.val < root.val && q.val < root.val){
            return lowestCommonAncestor(root.left, p, q);
        }else{
            return root;
        }
    }
}
