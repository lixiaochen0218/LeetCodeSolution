import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode078 {
    List<List<Integer>> set = new ArrayList();
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        helper(new ArrayList(),0,nums);
        return set;
    }

    public void helper(List<Integer> list, int start, int[] nums){
        set.add(new ArrayList<>(list));
        for(int i = start; i < nums.length; i++){
            list.add(nums[i]);
            helper(list, i + 1, nums);
            list.remove(list.size() - 1);
        }
    }
}
