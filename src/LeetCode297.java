/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class LeetCode297 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = helpSerialize(new StringBuilder(""), root);
        sb.deleteCharAt(sb.length() - 1); //delete last comma
        return sb.toString();
    }

    StringBuilder helpSerialize(StringBuilder sb, TreeNode root){
        if(root == null){
            sb.append("#,");
            return sb;
        }
        sb.append(root.val+",");
        helpSerialize(sb, root.left);
        helpSerialize(sb, root.right);
        return sb;
    }


    private int index = 0;

    public TreeNode deserialize(String data) {
        String[] array = data.split(",");
        index = 0;
        return helperDeserialize(array);
    }

    TreeNode helperDeserialize(String[] array) {
        if(array[index].equals("#")){
            return null;
        }
        int val = Integer.parseInt(array[index]);
        TreeNode node = new TreeNode(val);
        index++;
        node.left = helperDeserialize(array);
        index++;
        node.right = helperDeserialize(array);

        return node;


    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));


