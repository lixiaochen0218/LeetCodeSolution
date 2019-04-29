import java.util.ArrayList;
import java.util.List;

public class LeetCode095 {
    public List<TreeNode> generateTrees(int n) {
        return helper(1,n);
    }

    public List<TreeNode> helper(int min,int max){
        List<TreeNode> ans = new ArrayList();
        if(min>max) return ans;
        for(int i=min;i<=max;i++){
            List<TreeNode> leftNode = helper(min,i-1);
            List<TreeNode> rightNode = helper(i+1,max);
            if(leftNode.size() == 0 && rightNode.size() ==0){
                TreeNode node = new TreeNode(i);
                ans.add(node);
            }else if(leftNode.size() == 0 && rightNode.size() >0){
                for(TreeNode right:rightNode ){
                    TreeNode node = new TreeNode(i);
                    node.right = right;
                    ans.add(node);
                }
            }else if(leftNode.size() > 0 && rightNode.size() == 0){
                for(TreeNode left:leftNode ){
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    ans.add(node);
                }
            } else {
                for(TreeNode right:rightNode ){
                    for(TreeNode left:leftNode ){
                        TreeNode node = new TreeNode(i);
                        node.left = left;
                        node.right = right;
                        ans.add(node);
                    }
                }
            }
        }
        return ans;
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
