import java.util.ArrayList;
import java.util.List;

public class LeetCode301 {
    class Solution {
        public List<String> removeInvalidParentheses(String s) {
            char[] chars = s.toCharArray();
            int left = 0;
            int right = 0;
            for (int i=0;i<chars.length;i++) {
                if (chars[i] == '(') {
                    left++;
                } else if (chars[i] == ')' && left > 0) {
                    left--;
                } else if (chars[i] == ')' && left == 0) {
                    right++;
                } else {

                }
            }


            List<String> answer = new ArrayList();

            System.out.println("Remove  left:" + left + "  right:" + right );
            helper(s, answer, left , right, 0);
            return answer;

        }

        private void helper(String s, List<String> answer,int left,int right, int searchIndex) {
            if (left == 0 && right == 0 && isValid(s)) {
                answer.add(s);
                return ;
            }
            for (int i = searchIndex; i< s.length(); i++) {
                char ch = s.charAt(i);
                if (i>0 && ch == s.charAt(i-1)){
                    continue;
                }
                if (left > 0 && ch =='(')
                {
                    String new_str = s.substring(0,i) + s.substring(i+1);
                    helper(new_str, answer, left -1, right, i);
                    System.out.println("Remove  left:"+i + new_str );
                }
                if (right > 0 && ch ==')')
                {
                    String new_str = s.substring(0,i) + s.substring(i+1);
                    helper(new_str, answer, left , right-1, i);
                    System.out.println("Remove  right:" +i + new_str );
                }
            }
        }

        private boolean isValid(String s) {
            char[] chars = s.toCharArray();
            int left = 0;
            int right = 0;
            for (int i=0;i<chars.length;i++) {
                if (chars[i] == '(') {
                    left++;
                } else if (chars[i] == ')') {
                    right++;
                } else {

                }

                if (left < right) {
                    return false;
                }
            }
            if (left == right) {
                return true;
            } else {
                return false;
            }
        }
    }
}