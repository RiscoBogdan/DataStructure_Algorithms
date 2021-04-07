package DataStructure_Algorithms.Stack;

import java.util.EmptyStackException;

public class StackWithArray {
    static int times = 0;
    public int[] stack;
    static int top;

    public StackWithArray(int capacity) {
        stack = new int[capacity];
    }

    public static void main(String[] args) {
        StackWithArray s = new StackWithArray(10);
        s.push(4);
        s.push(5);
        s.push(6);
        s.push(7);
        s.push(8);
        s.push(9);
        System.out.println("Popped number was: " + s.pop());
        s.printStack();
        System.out.println("Peeked number is: " + s.peek());
        System.out.println("top is: "+ top);

    }

    public void isEmpty() {
        if (top <= 0) {
            System.out.println("true");
            return;
        }
        System.out.println("false");
    }

    public void push(int x) {
        if (top == stack.length) {
            int[] newStack = new int[2 * stack.length];
            System.arraycopy(stack, 0, newStack, 0, stack.length);
            stack = newStack;
            times++;
            System.out.println("Double the array " + times + " times.");
        }
        stack[top++] = x;
//        System.out.println("pushed top is:" + top);
    }

    public int pop() {
        if (top < 0) {
            System.out.println("Stack is empty!");
        }
        return stack[top--] = stack[top];
    }

    public int peek() {
        if (top == 0) {
            throw new EmptyStackException();
        }
        return stack[top - 1];
    }

    public void printStack() {
        for (int i = 0; i < top; i++) {
            System.out.println(stack[i]);
        }
    }
}
