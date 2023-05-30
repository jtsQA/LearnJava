package org.tasks;

public class IntegerStackUsingArray {
    private final int[] intStack;
    private int top;
    private final int capacity;

    public static void main(String[] args) {
        IntegerStackUsingArray stack = new IntegerStackUsingArray(5);
        stack.push(10).push(20).push(30).push(40).push(50);

        // Print elements in the stack
        System.out.println("Elements in the stack:");
        for (int i = stack.size() - 1; i >= 0; i--) {
            System.out.println(stack.intStack[i]);
        }
        System.out.println("stack.pop = " + stack.pop()); // Output: 50
        System.out.println("stack.peek = " + stack.peek()); // Output: 40
        System.out.println("stack.size = " + stack.size()); // Output: 4
        System.out.println("stack.isEmpty = " + stack.isEmpty()); // Output: false
    }

    public IntegerStackUsingArray(int capacity) {
        this.intStack = new int[capacity];
        this.top = -1;
        this.capacity = capacity;
    }

    public IntegerStackUsingArray push(int element) {
        if (top == capacity - 1) {
            throw new IllegalStateException("Stack is full.");
        }
        intStack[++top] = element;
        return this;
    }

    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty.");
        }
        return intStack[top--];
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty.");
        }
        return intStack[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }

    public int size() {
        return top + 1;
    }
}
