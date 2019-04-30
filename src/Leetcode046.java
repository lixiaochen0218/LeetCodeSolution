import java.util.ArrayList;
import java.util.List;

public class Leetcode046 {
    List<List<Integer>> res = new ArrayList();
    public List<List<Integer>> permute(int[] nums) {
        helper(new ArrayList(),nums);
        return res;
    }

    public void helper(List<Integer> list, int[] nums){
        if(list.size() == nums.length){
            res.add(new ArrayList(list));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(list.contains(nums[i])) continue;
            list.add(nums[i]);
            helper(list,nums);
            list.remove(list.size()-1);
        }
        return;
    }
}
