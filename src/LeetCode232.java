import java.util.Stack;

public class LeetCode232 {
    Stack<Integer> stack = new Stack();
    Stack<Integer> stackReversed = new Stack();
    /** Initialize your data structure here. */
    public LeetCode232() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(stack.isEmpty() && stackReversed.isEmpty()) return -1;
        if(!stackReversed.isEmpty()){
            return stackReversed.pop();
        } else {
            while(!stack.isEmpty()){
                stackReversed.push(stack.pop());
            }
            return stackReversed.pop();
        }

    }

    /** Get the front element. */
    public int peek() {
        if(stack.isEmpty() && stackReversed.isEmpty()) return -1;
        if(!stackReversed.isEmpty()){
            return stackReversed.peek();
        } else {
            while(!stack.isEmpty()){
                stackReversed.push(stack.pop());
            }
            return stackReversed.peek();
        }
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty() && stackReversed.isEmpty();
    }
}
