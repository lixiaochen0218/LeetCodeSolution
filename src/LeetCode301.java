import java.util.ArrayList;
import java.util.List;

public class LeetCode301 {
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
            System.out.println("Remove  left:" + left + "  right:" + right);

            int removeLeftIndex = 0;
            List<String> answer = new ArrayList();
            loop1:
            for (int j=0;j<chars.length;j++) {
                int leftToRemove = left;
                int rightToRemove = right;
                char[] removedChars = new char[chars.length];
                System.arraycopy( chars, 0, removedChars, 0, chars.length );
                boolean first = true;
                System.out.println("start searching index: " + removeLeftIndex + String.valueOf(chars));
                for (int i=removeLeftIndex;i<chars.length;i++) {
                    if (i != 0 && removedChars[i] == removedChars[i-1]) {
                        continue;
                    }
                    if (rightToRemove > 0 && removedChars[i] == ')') {
                        removedChars[i] = ' ';
                        rightToRemove--;
                        if (first) {
                            removeLeftIndex = i+1;
                            first = false;
                        }

                    } else if (leftToRemove > 0 && removedChars[i] == '('){
                        removedChars[i] = ' ';
                        leftToRemove--;
                    } else {
                        // ==0
                        if (leftToRemove == 0 && rightToRemove ==0 ) {
                            if (this.isValid(removedChars)) {
                                answer.add(String.valueOf(removedChars).replaceAll(" ", ""));
                                System.out.println("valid:" + String.valueOf(removedChars));
                            } else {
                                System.out.println("Invalid:" + String.valueOf(removedChars));
                            }
                            System.out.println("finish");
                            break;
                        }
                    }

                }
            }

            return answer;


        }

        private boolean isValid(char[] chars) {
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
