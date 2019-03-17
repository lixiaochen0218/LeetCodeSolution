import java.util.*;

public class LeetCode106 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, postorder, 0, inorder.length - 1, postorder.length - 1);
    }

    private TreeNode buildTree(int[] inorder, int[] postorder, int inStart, int inEnd, int postEnd) {
        if (inStart > inEnd)
            return null;


        TreeNode root = new TreeNode(postorder[postEnd]);

        //find the index of the root from inorder. Iterating from the end.
        int index = inStart;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == postorder[postEnd]) {
                index = i;
                break;
            }
        }

        root.left = buildTree(inorder, postorder, inStart, index - 1, postEnd - (inEnd - index) - 1);
        root.right = buildTree(inorder, postorder, index + 1, inEnd, postEnd - 1);
        return root;
    }

}
