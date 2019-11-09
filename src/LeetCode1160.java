import java.util.HashMap;

public class LeetCode1160 {
    public int countCharacters(String[] words, String chars) {
        char[] charArray = chars.toCharArray();
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(char c:charArray){
            map.put(c, map.getOrDefault(c, 0) +1);
        }
        int ans = 0;
        for(String word: words) {
            HashMap<Character, Integer> copy = new HashMap<Character, Integer>(map);
            char[] chs = word.toCharArray();
            for(int i=0;i<chs.length;i++){
                if (copy.containsKey(chs[i]) && copy.get(chs[i]) > 0){
                    copy.put(chs[i], copy.get(chs[i]) -1);
                } else {
                    break;
                }
                if (i == chs.length-1){
                    ans += word.length();
                }
            }
        }
        return ans;
    }
}
