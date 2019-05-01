import java.util.ArrayList;
import java.util.List;

public class LeetCode216 {
    List<List<Integer>> res = new ArrayList();
    public List<List<Integer>> combinationSum3(int k, int n) {
        if(n == 0 || k == 0) return res;
        helper(new ArrayList(),1,9,k,n);
        return res;
    }

    public void helper(List<Integer> list, int low, int high, int k, int sum){
        if(sum < 0 || list.size()>k) return;
        if(list.size()==k && sum == 0){
            res.add(new ArrayList(list));
            return;
        }
        for(int i=low;i<=high;i++){
            list.add(i);
            helper(list,i+1,high,k,sum-i);
            list.remove(list.size()-1);
        }
    }
}
