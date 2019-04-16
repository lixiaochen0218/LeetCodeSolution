import java.util.*;

public class LeetCode336 {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ans = new ArrayList();
        Map<String,Integer> map = new HashMap();
        for(int i=0;i<words.length;i++){
            map.put(words[i],i);
        }
        for(int i=0;i<words.length;i++){
            for(int j=0;j<=words[i].length();j++){
                String str1 = words[i].substring(0,j);
                String str2 = words[i].substring(j);
                if(isPalindrome(str1)){
                    String str2rev = new StringBuilder(str2).reverse().toString();
                    if(map.containsKey(str2rev) && map.get(str2rev) != i ){
                        ans.add(Arrays.asList(map.get(str2rev),i));
                    }
                }
                if(str2.length() != 0 && isPalindrome(str2)){
                    String str1rev = new StringBuilder(str1).reverse().toString();
                    if(map.containsKey(str1rev) && map.get(str1rev) != i ){
                        ans.add(Arrays.asList(i,map.get(str1rev)));
                    }
                }
            }
        }
        return ans;
    }

    private boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left <= right) {
            if (str.charAt(left++) !=  str.charAt(right--)) return false;
        }
        return true;
    }
}
