package T1_100;
import java.util.*;

public class TT12 {
	Stack<Integer> stack;
    Stack<Integer> minStack;
    
    public TT12() {
        // do initialize if necessary
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int number) {
        // write your code here
        stack.push(number);
        if(minStack.isEmpty() || number <= minStack.peek()){
            minStack.push(number);
        }
    }

    public int pop() {
        // write your code here
        int res = stack.pop();
        if(minStack.peek() == res){
            minStack.pop();
        }
        return res;
    }

    public int min() {
        // write your code here
        return minStack.peek();
    }
}
