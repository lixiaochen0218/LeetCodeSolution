import java.util.Stack;

public class LeetCode739 {
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack();
        int[] ans = new int[T.length];
        for(int i = 0; i < T.length; i++) {
            while(!stack.isEmpty() && T[i] > T[stack.peek()]) {
                int idx = stack.pop();
                ans[idx] = i - idx;
            }
            stack.push(i);
        }
        return ans;
    }
}
