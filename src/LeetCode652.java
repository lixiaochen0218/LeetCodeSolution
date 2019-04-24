import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode652 {
    Map<String, Integer> map;
    List<TreeNode> list;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        map = new HashMap();
        list = new ArrayList();
        DFS(root);
        return list;
    }

    public String DFS(TreeNode node) {
        if (node == null) return "#";
        String str = node.val + ',' + DFS(node.left) + ',' + DFS(node.right);
        map.put(str, map.getOrDefault(str, 0) + 1);
        if (map.get(str) == 2) list.add(node);

        return str;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
