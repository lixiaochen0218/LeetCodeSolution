import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class LeetCode692 {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap();
        for(String str:words){
            map.put(str, map.getOrDefault(str,0)+1);
        }
        List<String> ans = new ArrayList(map.keySet());
        Collections.sort(ans, (w1, w2) -> map.get(w1).equals(map.get(w2))?w1.compareTo(w2):map.get(w2) - map.get(w1) );
        return ans.subList(0,k);

    }
}
