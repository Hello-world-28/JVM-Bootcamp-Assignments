//Design a Data Structure 
// SpecialStack that supports all the stack operations like 
// push(), pop(), isEmpty(), isFull() and an additional operation getMin() which should return minimum element from the SpecialStack. 
// (Expected complexity ­ O(1))
import java.util.Stack;

public class Question3 {
    public static void main(String[] args) {
        SpecialStack s = new SpecialStack();
        s.push(10);
        s.push(20);
        s.push(5);
        s.push(15);

        System.out.println("Minimum element: " + s.getMin());

        s.pop();
        System.out.println("Minimum element after popping: " + s.getMin());

        s.pop();
        System.out.println("Minimum element after popping: " + s.getMin());
    }
    
}
class SpecialStack extends Stack {
    private Stack<Integer> mainStack;
    private Stack<Integer> minStack;

    public SpecialStack() {
        mainStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        mainStack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        } else {
            minStack.push(minStack.peek());
        }
    }

    public Integer pop() {
        if (mainStack.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        minStack.pop();
        return mainStack.pop();
    }

    public int getMin() {
        if (minStack.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return minStack.peek();
    }

    public boolean isEmpty() {
        return mainStack.isEmpty();
    }

    public boolean isFull() {
        // Stack in Java is dynamically sized
        return false;
    }
}