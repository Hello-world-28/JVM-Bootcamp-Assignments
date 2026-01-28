//Design a Data Structure 
// SpecialStack that supports all the stack operations like 
// push(), pop(), isEmpty(), isFull() and an additional operation getMin() which should return minimum element from the SpecialStack. 
// (Expected complexity ­ O(1))
import java.util.Stack;

public class Question3 {
    
}
class SpecialStack extends Stack {
    Stack minStack;
    private int min = Math.MAX_VALUE;

    SpecialStack() {
        minStack = new Stack();
    }

    void push(int x){
        minStack.push(int x);
        if(x < min){
            min = x;
        }
    }

    void pop(){
        
    }

}