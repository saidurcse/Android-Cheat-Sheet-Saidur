import java.io.*;
import java.util.*;
import javafx.util.Pair;

public class ReverseStack {

    /*
     * Reverse a stack
     * */
    private static Stack<Character> stack = new Stack<>();
    public static void reverseStack() {
        if(!stack.isEmpty()) {
            char c = stack.peek();
            stack.pop();
            reverseStack();

            insertAtBottom(c);
        }
    }

    private static void insertAtBottom(char c) {
        if(stack.isEmpty()) {
            stack.push(c);
        } else {
            char a = stack.peek();
            stack.pop();

            insertAtBottom(c);
            stack.push(a);
        }
    }


    public static void main(String[] args) {
        // push elements into
        // the stack
        stack.push('1');
        stack.push('2');
        stack.push('3');
        stack.push('4');

        System.out.println("Original Stack");
        System.out.println(stack);

        // function to reverse
        // the stack
        reverseStack();

        System.out.println("Reversed Stack");
        System.out.println(stack);
    }
}

/* Output: 
 * Original Stack
 * [1, 2, 3, 4]
 * Reversed Stack
 * [4, 3, 2, 1]
 */
