import java.util.*;

public class LeetCode049 {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> map = new HashMap<String, List>();
        for(String s:strs){
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if(!map.containsKey(key)){
                map.put(key, new ArrayList());
            }
            map.get(key).add(s);
        }
        return new ArrayList(map.values());
    }

    public List<List<String>> groupAnagrams2(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> map = new HashMap<String, List>();
        int[] counts = new int[26];
        for(String s:strs){
            Arrays.fill(counts, 0);
            char[] chars = s.toCharArray();

            for(char c:chars) counts[c - 'a']++;

            StringBuilder sb = new StringBuilder("");

            for(int i=0;i<26;i++){
                sb.append('#');
                sb.append(counts[i]);
            }
            String key = sb.toString();
            if(!map.containsKey(key)){
                map.put(key, new ArrayList());
            }
            map.get(key).add(s);
        }
        return new ArrayList(map.values());
    }
}
