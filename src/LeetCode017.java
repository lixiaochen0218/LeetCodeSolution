import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static javax.swing.UIManager.put;

public class LeetCode017 {
    Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    List<String> ans = new ArrayList();

    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return ans;

        DFS(0,digits,"");
        return ans;
    }

    public void DFS(int index, String digits, String combine){
        if(index == digits.length()){
            ans.add(combine);
            return;
        }
        char[] chars = phone.get(digits.charAt(index)+"").toCharArray();
        for(char c:chars){
            DFS(index+1,digits,combine + c);
        }
    }

}
