import java.util.ArrayList;
import java.util.List;

public class LeetCode301 {
    class Solution {
        public List<String> removeInvalidParentheses(String s) {
            char[] chars = s.toCharArray();
            int left = 0;
            int right = 0;
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == '(') {
                    left++;
                } else if (chars[i] == ')' && left > 0) {
                    left--;
                } else if (chars[i] == ')' && left == 0) {
                    right++;
                } else {

                }
            }

            int searchIndex = 0;
            List<String> answer = new ArrayList();
            int count = s.length() - s.replace(")", "").length();
            if (count == 0) {
                s = s.replaceAll("\\(", "");
                answer.add(s);
                return answer;
            }
            System.out.println("Remove  left:" + left + "  right:" + right + " Count): " + count);
            loop1:
            while (searchIndex < s.length()) {
                int leftToRemove = left;
                int rightToRemove = right;
                char[] removedChars = new char[chars.length];
                System.arraycopy(chars, 0, removedChars, 0, chars.length);
                boolean first = true;
                System.out.println("start searching index: " + searchIndex + String.valueOf(chars));
                for (int i = searchIndex; i < chars.length; i++) {
                    if (i != 0 && removedChars[i] == removedChars[i - 1]) {
                        continue;
                    }
                    if (rightToRemove > 0 && removedChars[i] == ')') {
                        removedChars[i] = '_';
                        rightToRemove--;
                        if (first) {
                            searchIndex = i + 1 - 1;
                            first = false;
                        }

                    } else if (rightToRemove == 0 && leftToRemove > 0 && removedChars[i] == '(') {
                        removedChars[i] = '_';
                        leftToRemove--;
                    } else {

                    }
                    // ==0
                    if (leftToRemove == 0 && rightToRemove == 0) {
                        if (this.isValid(removedChars)) {
                            answer.add(String.valueOf(removedChars).replaceAll("_", ""));
                            System.out.println("valid:" + String.valueOf(removedChars));
                        } else {
                            System.out.println("Invalid:" + String.valueOf(removedChars));
                        }
                        System.out.println("finish");
                        break;
                    }

                }
                searchIndex++;
            }
            if (answer.size() == 0) {
                answer.add(s);
                return answer;
            } else {
                return answer;
            }


        }

        private boolean isValid(char[] chars) {
            int left = 0;
            int right = 0;
            for (int i = 0; i < chars.length; i++) {
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