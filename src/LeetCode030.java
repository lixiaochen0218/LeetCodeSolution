import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LeetCode030 {
    public List<Integer> findSubstring(String s, String[] words) {
        if (s == null || words == null || words.length == 0) return new ArrayList<>();

        List<Integer> res = new ArrayList<>();

        int number = words.length;
        int gap = words[0].length();
        HashMap<String, Integer> map = new HashMap();
        for (String str: words){
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        for ( int i=0;i<=s.length()-number * gap;i++){
            HashMap<String,Integer> copy = new HashMap<>(map);
            int n = number;
            int start = i;
            while (n > 0) {
                String str = s.substring(start,start+gap);
                if (!copy.containsKey(str) || copy.get(str) < 1){
                    break;
                }
                copy.put(str, copy.get(str) -1);
                start += gap;
                n--;
                if (n == 0){
                    res.add(i);
                }
            }

        }
        return res;
    }
}
