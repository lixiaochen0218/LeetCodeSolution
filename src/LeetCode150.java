import java.util.Stack;

public class LeetCode150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();
        for(String s: tokens){
            if(s.equals("+")){
                int last = stack.pop();
                int beforeLast = stack.pop();
                stack.push(beforeLast + last);
            }else if(s.equals("-")){
                int last = stack.pop();
                int beforeLast = stack.pop();
                stack.push(beforeLast - last);
            }else if(s.equals("*")){
                int last = stack.pop();
                int beforeLast = stack.pop();
                stack.push(beforeLast * last);
            }else if(s.equals("/")){
                int last = stack.pop();
                int beforeLast = stack.pop();
                stack.push(beforeLast / last);
            }else{
                stack.push(Integer.parseInt(s));
            }

        }
        return stack.pop();
    }
}
