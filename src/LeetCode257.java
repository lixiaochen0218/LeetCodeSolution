import java.util.ArrayList;
import java.util.List;

public class LeetCode257 {
    private List<String> list = new ArrayList();
    public List<String> binaryTreePaths(TreeNode root) {
        if (root != null)
            helper(list,root,"");
        return list;
    }

    private void helper(List<String> list, TreeNode root, String path){
        if (root.left == null && root.right == null) {
            list.add(path + root.val);
        }
        if (root.left != null) {
            helper(list, root.left, path + root.val + "->");
        }
        if (root.right != null) {
            helper(list, root.right, path + root.val + "->");
        }
    }
}
