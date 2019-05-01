import java.util.ArrayList;
import java.util.List;

public class LeetCode077 {
    List<List<Integer>> res = new ArrayList();
    public List<List<Integer>> combine(int n, int k) {
        if(n == 0 || k == 0) return res;
        helper(new ArrayList(),1,n,k);
        return res;
    }

    public void helper(List<Integer> list, int low, int high, int k){
        if(list.size()==k){
            res.add(new ArrayList(list));
            return;
        }
        for(int i=low;i<=high;i++){
            list.add(i);
            helper(list,i+1,high,k);
            list.remove(list.size()-1);
        }
    }
}
