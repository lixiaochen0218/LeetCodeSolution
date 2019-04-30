import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode047 {
    List<List<Integer>> res = new ArrayList();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        helper(new ArrayList(), nums, new boolean[nums.length]);
        return res;
    }

    public void helper(List<Integer> list, int[] nums, boolean[] used){
        if(list.size()==nums.length){
            res.add(new ArrayList(list));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(used[i] || i>0 && nums[i] == nums[i-1] && !used[i-1]) continue;  //remove duplicated permutations
            list.add(nums[i]);
            used[i] = true;
            helper(list, nums,used);
            list.remove(list.size()-1);
            used[i] = false;
        }
        return;
    }
}
