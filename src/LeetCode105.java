public class LeetCode105 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(inorder, preorder, 0, inorder.length - 1, 0);
    }

    private TreeNode helper(int[] inorder, int[] preorder, int inStart, int inEnd, int preStart) {
        if (inStart > inEnd)
            return null;


        TreeNode root = new TreeNode(preorder[preStart]);

        //find the index of the root from inorder. Iterating from the end.
        int index = inStart;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == preorder[preStart]) {
                index = i;
                break;
            }
        }

        root.left = helper(inorder, preorder, inStart, index - 1, preStart + 1);
        root.right = helper(inorder, preorder, index + 1, inEnd, preStart + index - inStart + 1);
        return root;
    }
}
