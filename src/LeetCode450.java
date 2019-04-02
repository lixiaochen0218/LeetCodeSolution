public class LeetCode450 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return root;
        }
        if(root.val > key){
            root.left = deleteNode(root.left,key);
        }else if(root.val < key){
            root.right = deleteNode(root.right,key);
        }else{
            if(root.left == null){
                return root.right;
            }else if (root.right == null){
                return root.left;
            }

            TreeNode node = root.right;
            while(node.left != null){
                node = node.left;
            }
            root.val = node.val;
            root.right = deleteNode(root.right,root.val);

        }
        return root;
    }
}
