import java.util.Stack;

public class LeetCode173 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    Stack<TreeNode> stack;

    public LeetCode173(TreeNode root) {
        stack = new Stack();
        TreeNode cur = root;
        while(cur != null){
            stack.push(cur);
            if (cur.left != null){
                cur = cur.left;
            }else{
                break;
            }
        }
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        TreeNode cur = node;
        if(cur.right != null){
            cur = cur.right;
            while(cur != null){
                stack.push(cur);
                if (cur.left != null){
                    cur = cur.left;
                }else{
                    break;
                }
            }
        }
        return node.val;

    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
