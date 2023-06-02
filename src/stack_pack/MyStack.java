package stack_pack;

import java.util.Arrays;

@SuppressWarnings({"unchecked"})
public class MyStack<T> {
    private int top;
    private T[] stackArr;
    private int maxSize;

    public MyStack(int size) {
        top = -1;
        maxSize = size;
        stackArr = (T[]) new Object[size];
    }

    public int size() {
        return top+1;
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == maxSize - 1);
    }

    public void push(T element) throws StackOverflowException {
        if (isFull()) {
            throw new StackOverflowException();
        }
        stackArr[++top] = element;
    }

    public T pop() throws StackUnderflowException {
        if (isEmpty()) {
            throw new StackUnderflowException();
        }
        return stackArr[top--];
    }

    public T peek() {
        return stackArr[top];
    }

    public boolean equals(MyStack otherStack) {
        T[] arr1 = Arrays.copyOf(stackArr, top + 1);
        T[] arr2 = (T[]) Arrays.copyOf(otherStack.stackArr, otherStack.top + 1);
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2);
    }

    // Custom exception for stack overflow
    static class StackOverflowException extends Exception {
        public StackOverflowException() {
            super("Stack overflow");
        }
    }

    // Custom exception for stack underflow
    static class StackUnderflowException extends Exception {
        public StackUnderflowException() {
            super("Stack underflow");
        }
    }

    public static void main(String[] args) {
        MyStack<Integer> stack1 = new MyStack(5);
        MyStack<Integer> stack2 = new MyStack(5);
        try {
            stack1.push(1);
            stack1.push(2);
            stack1.push(3);
            stack2.push(3);
            stack2.push(2);
            stack2.push(1);
        } catch (StackOverflowException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Stack 1: " + Arrays.toString(stack1.stackArr));
        System.out.println("Stack 2: " + Arrays.toString(stack2.stackArr));
        boolean isEqual = stack1.equals(stack2);
        System.out.println("Stacks are equal: " + isEqual);
    }
}
