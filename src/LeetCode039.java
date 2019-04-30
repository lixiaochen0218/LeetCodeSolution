import java.util.ArrayList;
import java.util.List;

public class LeetCode039 {
    List<List<Integer>> ans = new ArrayList();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates == null || candidates.length==0) return ans;
        helper(new ArrayList(),0,candidates,target);
        return ans;
    }

    public void helper(List<Integer> list, int index, int[] candidates, int target){
        // System.out.println(index + " " + target);
        if(target < 0) return;
        if(target == 0){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=index;i<candidates.length;i++){
            list.add(candidates[i]);
            helper(list,i,candidates,target-candidates[i]);
            list.remove(list.size()-1);
        }
    }
}

