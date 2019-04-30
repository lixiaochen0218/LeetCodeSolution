import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode040 {
    List<List<Integer>> ans = new ArrayList();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(candidates == null || candidates.length==0) return ans;
        Arrays.sort(candidates);
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
            if(i != index && candidates[i] == candidates[i-1]) continue; //remove duplicate combinations.
            list.add(candidates[i]);
            helper(list,i+1,candidates,target-candidates[i]);
            list.remove(list.size()-1);
        }
    }
}
